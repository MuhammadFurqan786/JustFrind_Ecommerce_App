package com.justfriends.repository

import android.util.Log
import com.google.gson.JsonObject
import com.justfriends.model.*
import com.justfriends.network.RetrofitService
import okhttp3.MultipartBody


class AuthRepository(private val apiService: RetrofitService) : BaseRepository() {

    suspend fun signUp(
        email: String,
        password: String,
        name: String,
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
    ): SignUpResModel? {
        val body = JsonObject()
        body.addProperty("email", email)
        body.addProperty("password", password)
        body.addProperty("name", name)
        body.addProperty("mobile", mobile)
        body.addProperty("deviceId", deviceId)
        body.addProperty("platform", platform)
        body.addProperty("userImg", userImg)
        body.addProperty("deviceType", deviceType)
        body.addProperty("gmail", gmail)
        body.addProperty("facebook", facebook)
        body.addProperty("latitude", latitude)
        body.addProperty("longitude", longitude)
        body.addProperty("token", token)
        body.addProperty("isActive", isActive)

        return try {
            Log.d("TAG", "signUp: result is in try")
            safeApiCall(
                call = {
                    apiService.signUpAsync(body)
                },
                error = "Error from server" + ""
            )

        } catch (e: Exception) {
            Log.d("TAG", "signUp: Exception = ${e.localizedMessage}")
            null
        }
    }

    suspend fun login(email: String, password: String): LoginResModel? {
        val body = JsonObject()
        body.addProperty("email", email)
        body.addProperty("password", password)
        return try {
            safeApiCall(call = {
                apiService.loginAsync(body).await()
            }, error = "Error from server" + "")
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getUpdatePassword(
        token: String,
        oldPassword: String,
        newPassword: String
    ): UpdatePasswordResModel? {
        val body = JsonObject()
        body.addProperty("oldPassword", oldPassword)
        body.addProperty("password", newPassword)
        return try {
            safeApiCall(
                call = {
                    apiService.getUpdatePasswordAsync(token, body).await()
                },
                error = "Error from server" + ""
            )
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getUserData(
        token: String,
        userId: String
    ): UserResModel? {
        return try {

            safeApiCall(
                call = {
                    apiService.getUserDataAsync(token, userId).await()
                },
                error = "Error from server" + ""
            )
        } catch (e: Exception) {
            null
        }
    }

    suspend fun checkEmail(email: String): CheckEmailResModel? {
        return try {
            safeApiCall(
                call = {
                    apiService.checkEmailAsync(email).await()
                },
                error = "Error from server" + ""
            )
        } catch (e: Exception) {
            null
        }
    }

    suspend fun checkMobile(mobile: String): CheckMobileResModel? {
        return try {
            safeApiCall(
                call = {
                    apiService.checkMobileAsync(mobile).await()
                },
                error = "Error from server" + ""
            )
        } catch (e: Exception) {
            null
        }
    }

    suspend fun socialLogin(
        email: String,
        password: String,
        name: String,
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
    ): LoginResModel? {
        val body = JsonObject()
        body.addProperty("email", email)
        body.addProperty("password", password)
        body.addProperty("name", name)
        body.addProperty("mobile", mobile)
        body.addProperty("deviceId", deviceId)
        body.addProperty("platform", platform)
        body.addProperty("userImg", userImg)
        body.addProperty("deviceType", deviceType)
        body.addProperty("gmail", gmail)
        body.addProperty("facebook", facebook)
        body.addProperty("latitude", latitude)
        body.addProperty("longitude", longitude)
        body.addProperty("token", token)
        body.addProperty("isActive", isActive)

        return try {
            safeApiCall(
                call = {
                    apiService.socialAsync(body).await()
                },
                error = "Error from server" + ""
            )
        } catch (e: Exception) {
            null
        }
    }

    suspend fun forgotPassword(email: String): GlobalResModel? {
        return try {
            safeApiCall(
                call = {
                    apiService.forgotPasswordAsync(email).await()
                }, error = "Error from server" + ""
            )
        } catch (e: Exception) {
            null
        }

    }

    suspend fun getOtp(phone: String): OtpResModel? {
        return try {
            safeApiCall(
                call = { apiService.getOtpAsync(phone).await() },
                error = "Error for Server"
            )
        } catch (e: Exception) {
            Log.d("TAG", "getOtp: error ${e.localizedMessage}")
            null
        }
    }


    suspend fun updateName(
        token: String,
        name: String,
    ): UpdateNameResModel? {
        val jsonRequest = JsonObject()
        jsonRequest.addProperty("name", name)
        return try {
            safeApiCall(
                call = {
                    apiService.updateNameAsync(
                        token, jsonRequest
                    ).await()
                },
                error = "Error form server"
            )
        } catch (e: Exception) {
            null
        }

    }


    suspend fun updateEmail(token: String, email: String): UpdateEmailResModel? {

        return try {
            safeApiCall(
                call = { apiService.updateEmailAsync(token, email).await() },
                error = "Error from server"
            )

        } catch (e: Exception) {
            null
        }
    }

    suspend fun updateProfileImage(
        token: String,
        profileImage: MultipartBody.Part
    ): UploadImageResModel? {
        return try {
            safeApiCall(
                call = {
                    apiService.updateProfileImagesAsync(
                        token,
                        profileImage
                    ).await()
                },
                error = "Error from server"
            )

        } catch (e: Exception) {
            null
        }
    }



}