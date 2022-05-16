package com.justfriends.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.justfriends.R
import com.justfriends.model.*
import com.justfriends.network.ApiFactory
import com.justfriends.repository.AccountRepository
import com.justfriends.repository.PostRepository
import com.justfriends.utils.Global
import com.justfriends.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class AccountViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext get() = getApplication<Application>().applicationContext
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val accountRepo = AccountRepository(ApiFactory.makeServiceApi())

    private val liveDataMessage = SingleLiveEvent<String>()
    private val liveDataProgress = SingleLiveEvent<Boolean>()
    private val liveDataPublicProfile = MutableLiveData<PublicProfileData>()
    private val liveDataBlockUser = MutableLiveData<BlockUserResModel>()
    private val liveDataMarketplacePosts = MutableLiveData<List<Post>>()



    val getProgressObserver : LiveData<Boolean> get() = liveDataProgress
    val getMessageObserver : LiveData<String> get() = liveDataMessage
    val getPublicProfileObserver: LiveData<PublicProfileData> get() = liveDataPublicProfile
    val getBlockUserObserver : LiveData<BlockUserResModel> get() = liveDataBlockUser
    val getMarketplacePostsObserver : LiveData<List<Post>>get() = liveDataMarketplacePosts





    fun getPublicProfile(token: String, userID: String) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = accountRepo.getPublicProfile(token, userID)
            result?.let {
                if (it.success) {
                    liveDataPublicProfile.postValue(it.data)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
                ?: liveDataMessage.postValue(mContext.getString(R.string.message_something_went_wrong))
            liveDataProgress.postValue(false)
        }
    }




    fun blockUser(token: String, userId: Long) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = accountRepo.blockUser(token, userId)
            liveDataProgress.postValue(false)
            result?.let {
                if (it.success) {
                    liveDataBlockUser.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }


        }
    }



    fun getMarketPlacePosts(
        token: String,
        userId: Long,
    ) {
        if (!Global.hasInternet(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_check_internet))
            return
        }

        if (userId == 0L) {
            liveDataMarketplacePosts.postValue(ArrayList())
            liveDataProgress.postValue(false)
            return
        }

        scope.launch {
            liveDataProgress.postValue(true)
            val result = accountRepo.getMarketPlacePosts(token, userId)

            result?.let {
                if (it.success) {
                    liveDataMarketplacePosts.postValue(it.posts)
                } else {
                    liveDataMarketplacePosts.postValue(ArrayList())
                }

            } ?: liveDataMessage.postValue(mContext.getString(R.string.error_from_server))
            liveDataProgress.postValue(false)
        }
    }
}