package com.justfriends.viewModel

import android.app.Application
import android.content.Context
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.justfriends.R
import com.justfriends.model.*
import com.justfriends.network.ApiFactory
import com.justfriends.repository.AuthRepository
import com.justfriends.utils.Global
import com.justfriends.utils.InternetConnectivity
import com.justfriends.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import kotlin.coroutines.CoroutineContext

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext: Context get() = getApplication<Application>().applicationContext
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val authRepo = AuthRepository(ApiFactory.makeServiceApi())

    private val liveDataMessage = SingleLiveEvent<String>()
    private val liveDataProgress = SingleLiveEvent<Boolean>()

    private val liveDataSignUp = MutableLiveData<SignUpResModel>()
    private val liveDataLogin = MutableLiveData<LoginResModel>()
    private val liveDataForgotPassword = MutableLiveData<GlobalResModel>()
    private val liveDataOtp = SingleLiveEvent<OtpResModel>()
    private val liveDataUpdatePassword = MutableLiveData<UpdatePasswordResModel>()
    private val liveDataUserData = MutableLiveData<UserResModel>()
    private val liveDataCheckEmail = MutableLiveData<CheckEmailResModel>()
    private val liveDataCheckMobile = MutableLiveData<CheckMobileResModel>()

    private val liveDataUpdateName = MutableLiveData<UpdateNameResModel>()
    private val liveDataUpdateEmail = MutableLiveData<UpdateEmailResModel>()
    private val liveDataUpdateImage = MutableLiveData<UploadImageResModel>()


    val getProgressObserver: LiveData<Boolean> get() = liveDataProgress
    val getMessageObserver: LiveData<String> get() = liveDataMessage
    val getSignUpObserver: LiveData<SignUpResModel> get() = liveDataSignUp
    val getLoginObserver: LiveData<LoginResModel> get() = liveDataLogin
    val getFogotPasswordObserver: LiveData<GlobalResModel> get() = liveDataForgotPassword
    val getOtpObserver: LiveData<OtpResModel> get() = liveDataOtp
    val getUpdatePasswordObserver: LiveData<UpdatePasswordResModel> get() = liveDataUpdatePassword
    val getUserDataObserver: LiveData<UserResModel> get() = liveDataUserData
    val getCheckEmailObserver: LiveData<CheckEmailResModel> get() = liveDataCheckEmail
    val getCheckMobileObserver: LiveData<CheckMobileResModel> get() = liveDataCheckMobile
    val getUpdateNameObserver: LiveData<UpdateNameResModel> get() = liveDataUpdateName
    val getUpdateEmailObserver: LiveData<UpdateEmailResModel> get() = liveDataUpdateEmail
    val getProfileImageUpdateObserver
        get() :LiveData<UploadImageResModel>
        = liveDataUpdateImage


    fun signUp(
        email: String,
        password: String,
        name: String,
        countryCode: String,
        mobile: String,
        userImg: String,
        gmail: String,
        facebook: String,
        token: String,
        deviceId: String,
        platform: String = "Manual",
        deviceType: String = "Android",
        latitude: String = "0.0",
        longitude: String = "0.0",
        isActive: Int = 0
    ) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }

        if (TextUtils.isEmpty(name)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_enter_name))
            return
        }

        if (TextUtils.isEmpty(email)) {
            liveDataMessage.postValue(mContext.getString(R.string.messgae_enter_email))
            return
        }

        if (TextUtils.isEmpty(mobile)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_enter_phone))
            return
        }
        if (TextUtils.isEmpty(password)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_enter_password))
            return
        }

        if (mobile.length < 10) {
            liveDataMessage.postValue(mContext.getString(R.string.message_valid_phone))
            return
        }
        if (password.length < 8) {
            liveDataMessage.postValue(mContext.getString(R.string.message_password_length))
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = authRepo.signUp(
                email,
                password,
                name,
                "$countryCode$mobile",
                userImg,
                gmail,
                facebook,
                token,
                deviceId,
                platform,
                deviceType,
                latitude,
                longitude,
                isActive
            )
            result?.let {
                if (it.success) {
                    liveDataSignUp.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
                liveDataProgress.postValue(false)
            }
            liveDataProgress.postValue(false)
        }
    }

    fun login(
        email: String,
        password: String
    ) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        if (TextUtils.isEmpty(email)) {
            liveDataMessage.postValue(mContext.getString(R.string.messgae_enter_email))
            return
        }
        if (TextUtils.isEmpty(password)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_enter_password))
            return
        }
        if (password.length < 8) {
            liveDataMessage.postValue(mContext.getString(R.string.message_password_length))
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = authRepo.login(email, password)
            result?.let {
                if (it.success) {
                    liveDataLogin.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
                liveDataProgress.postValue(false)
            }
            liveDataProgress.postValue(false)
        }
    }

    fun getUpdatePassword(
        token: String,
        oldPassword: String,
        newPassword: String,
        verifyPassword: String
    ) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        if (TextUtils.isEmpty(oldPassword)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_enter_old_password))
            return
        }
        if (newPassword != verifyPassword) {
            liveDataMessage.postValue(mContext.getString(R.string.message_password_same))
        }
        if (TextUtils.isEmpty(newPassword)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_enter_new_password))
            return
        }
        if (oldPassword.length < 8) {
            liveDataMessage.postValue(mContext.getString(R.string.message_password_length))
            return
        }
        if (newPassword.length < 8) {
            liveDataMessage.postValue(mContext.getString(R.string.message_password_length))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = authRepo.getUpdatePassword(
                token, oldPassword, verifyPassword
            )
            result?.let {
                if (it.success) {
                    liveDataUpdatePassword.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
                liveDataProgress.postValue(false)
            }
        }


    }

    fun socialLogin(
        email: String,
        password: String,
        name: String,
        countryCode: String,
        mobile: String,
        userImg: String,
        gmail: String,
        facebook: String,
        token: String,
        deviceId: String,
        platform: String = "Manual",
        deviceType: String = "Android",
        latitude: String = "0.0",
        longitude: String = "0.0",
        isActive: String = "1"
    ) {
        if (InternetConnectivity.isConnected(mContext)) {
            scope.launch {
                liveDataProgress.postValue(true)
                val result = authRepo.socialLogin(
                    email, password, name, "$countryCode$mobile", userImg, gmail, facebook, token,
                    deviceId, platform, deviceType, latitude, longitude, isActive
                )
                liveDataProgress.postValue(false)
                result?.let {
                    if (it.success) {
                        liveDataLogin.postValue(it)
                    } else {
                        liveDataMessage.postValue(it.message)
                    }

                }
            }

        }
    }

    fun getUserData(token: String, userId: String) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }

        scope.launch {
            liveDataProgress.postValue(true)
            val result =
                authRepo.getUserData(
                    token, userId
                )
            result?.let {
                if (it.success) {
                    liveDataUserData.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
            liveDataProgress.postValue(false)
        }
    }

    fun checkEmail(email: String) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        if (TextUtils.isEmpty(email)) {
            liveDataMessage.postValue(mContext.getString(R.string.messgae_enter_email))
            return
        }

        scope.launch {
            liveDataProgress.postValue(true)
            val result =
                authRepo.checkEmail(
                    email
                )
            result?.let {
                if (it.success) {
                    liveDataCheckEmail.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
            liveDataProgress.postValue(false)
        }

    }

    fun checkMobile(mobile: String) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        if (TextUtils.isEmpty(mobile)) {
            liveDataMessage.postValue(mContext.getString(R.string.messgae_enter_email))
            return
        }

        scope.launch {
            liveDataProgress.postValue(true)
            val result =
                authRepo.checkMobile(
                    mobile
                )
            result?.let {
                if (it.success) {
                    liveDataCheckMobile.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
            liveDataProgress.postValue(false)
        }


    }

    fun forgotPassword(email: String) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        if (TextUtils.isEmpty(email)) {
            liveDataMessage.postValue(mContext.getString(R.string.messgae_enter_email))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result =
                authRepo.forgotPassword(
                    email
                )
            result?.let {
                if (it.success) {
                    liveDataForgotPassword.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
            liveDataProgress.postValue(false)
        }
    }

    fun getOtp(
        email: String,
        password: String,
        name: String,
        countryCode: String,
        mobile: String,
        confirmPassword: String
    ) {
        if (TextUtils.isEmpty(name)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_enter_name))
            return
        }
        if (!Global.isEmailValid(email)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_valid_email))
            return
        }
        if (password != confirmPassword) {
            liveDataMessage.postValue(mContext.getString(R.string.message_password_same))
            return
        }

        if (TextUtils.isEmpty(email)) {
            liveDataMessage.postValue(mContext.getString(R.string.messgae_enter_email))
            return
        }

        if (TextUtils.isEmpty(mobile)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_enter_phone))
            return
        }
        if (TextUtils.isEmpty(password)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_enter_password))
            return
        }

        if (mobile.length < 10) {
            liveDataMessage.postValue(mContext.getString(R.string.message_valid_phone))
            return
        }
        if (password.length < 8) {
            liveDataMessage.postValue(mContext.getString(R.string.message_password_length))
            return
        }
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }

        scope.launch {
            liveDataProgress.postValue(true)
            val result = authRepo.getOtp("$countryCode$mobile")
            Log.d("TAG", "getOtp: $result")
            result?.let {
                if (it.success) {
                    liveDataOtp.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
                liveDataProgress.postValue(false)
            }

        }
    }


    fun updateName(token: String, name: String) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }

        if (TextUtils.isEmpty(name)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_enter_name))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = authRepo.updateName(token, name)
            result?.let {
                if (it.success) {
                    liveDataUpdateName.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
                liveDataProgress.postValue(false)
            }
        }
    }

    fun updateEmail(token: String, email: String) {
        if (!Global.hasInternet(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_check_internet))
            return
        }

        scope.launch {
            liveDataProgress.postValue(true)
            val result = authRepo.updateEmail(token, email)
            result?.let {
                if (it.success) {
                    liveDataUpdateEmail.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
            liveDataProgress.postValue(false)
        }
    }

    fun updateProfileImage(
        token: String,
        profileImage: MultipartBody.Part
    ) {
        if (!Global.hasInternet(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_check_internet))
            return
        }

        scope.launch {
            liveDataProgress.postValue(true)
            val result = authRepo.updateProfileImage(
                token, profileImage
            )
            result?.let {
                liveDataUpdateImage.postValue(it)
            }
            liveDataProgress.postValue(false)
        }
    }


}