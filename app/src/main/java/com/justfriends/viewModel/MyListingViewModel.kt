package com.justfriends.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.justfriends.R
import com.justfriends.model.MarkAsSoldResModel
import com.justfriends.model.Post
import com.justfriends.network.ApiFactory
import com.justfriends.repository.MyListingRepository
import com.justfriends.utils.Global
import com.justfriends.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MyListingViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext: Context get() = getApplication<Application>().applicationContext
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val myListingRepo = MyListingRepository(ApiFactory.makeServiceApi())
    private val liveDataMessage = SingleLiveEvent<String>()
    private val liveDataProgress = SingleLiveEvent<Boolean>()
    private val liveDataMarketPlace = SingleLiveEvent<List<Post>>()
    private val liveDataMarkAsSold = SingleLiveEvent<MarkAsSoldResModel>()


    val getProgressObserver: LiveData<Boolean> get() = liveDataProgress
    val getMessageObserver: LiveData<String> get() = liveDataMessage
    val getMyListingSellingProduct: LiveData<List<Post>> get() = liveDataMarketPlace
    val getMarkAsSold: LiveData<MarkAsSoldResModel> get() = liveDataMarkAsSold

    val getMarketPlaceObserver
        get() : LiveData<List<Post>>
        = liveDataMarketPlace


    fun getMyMarketPlacePosts(
        token: String,
    ) {
        if (!Global.hasInternet(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_check_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = myListingRepo.getMyMarketPlacePosts(token)
            result?.let {
                if (it.success) {
                    liveDataMarketPlace.postValue(it.posts)
                } else {
                    liveDataMarketPlace.postValue(ArrayList())
                }

            } ?: liveDataMessage.postValue(mContext.getString(R.string.error_from_server))
            liveDataProgress.postValue(false)
        }
    }

    fun markAsSold(
        token: String,
        productId: Long,
    ) {
        if (!Global.hasInternet(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_check_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = myListingRepo.getMarkAsSold(token, productId)
            result?.let {
                if (it.success) {
                    liveDataMarkAsSold.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            } ?: liveDataMessage.postValue(mContext.getString(R.string.error_from_server))
            liveDataProgress.postValue(false)
        }

    }
}