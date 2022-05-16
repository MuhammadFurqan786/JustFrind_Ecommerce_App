package com.justfriends.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.justfriends.R
import com.justfriends.model.FavouriteItem
import com.justfriends.network.ApiFactory
import com.justfriends.repository.FavouriteRepository
import com.justfriends.utils.Global
import com.justfriends.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class FavouriteViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext: Context get() = getApplication<Application>().applicationContext
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val favourites = ArrayList<FavouriteItem>()
    private val favouriteRepo = FavouriteRepository(ApiFactory.makeServiceApi())
    private val liveDataMessage = SingleLiveEvent<String>()
    private val liveDataProgress = SingleLiveEvent<Boolean>()
    private val liveDataFavourites = MutableLiveData<ArrayList<FavouriteItem>>()
    private val liveDataFavouriteStatus = MutableLiveData<Boolean>()


    val getMessageObserver
        get() : LiveData<String>
        = liveDataMessage

    val getProgressObserver
        get() : LiveData<Boolean>
        = liveDataProgress
    val getFavouritesObserver
        get() : LiveData<ArrayList<FavouriteItem>>
        = liveDataFavourites

    val getFavouriteStatusObserver
        get() : LiveData<Boolean>
        = liveDataFavouriteStatus


    fun getFavouritePosts(token: String) {
        if (!Global.hasInternet(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_check_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            favourites.clear()
            val result = favouriteRepo.getFavouriteData(token)
            result?.let {
                if (it.success) {
                    liveDataFavourites.postValue(result.data)
                } else {
                    liveDataFavourites.postValue(ArrayList())
                }

            } ?: liveDataMessage.postValue(mContext.getString(R.string.error_from_server))

            liveDataProgress.postValue(false)
        }
    }


    fun addToFav(
        token: String,
        postId: Long,
    ) {
        if (!Global.hasInternet(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_check_internet))
            return
        }
        scope.launch {
            val result = favouriteRepo.addToFav(token, postId)
            result?.let {
                if (it.success) {
                    liveDataFavouriteStatus.postValue(true)
                }
                // liveDataMessage.postValue(it.message)
                return@launch
            }

        }


    }
    fun removeFromFav(
        token: String,
        postId: Long,
    ) {
        if (!Global.hasInternet(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_check_internet))
            return
        }
        scope.launch {
            val result = favouriteRepo.removeFromFav(token, postId)
            result?.let {
                if (it.success) {
                    liveDataFavouriteStatus.postValue(false)
                }
                return@launch
            }

        }


    }



}