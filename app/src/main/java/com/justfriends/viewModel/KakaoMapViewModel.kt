package com.justfriends.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.justfriends.R
import com.justfriends.model.KakaoMapResModel
import com.justfriends.network.ApiFactory
import com.justfriends.repository.KakaoMapRepository
import com.justfriends.utils.Global
import com.justfriends.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class KakaoMapViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext: Context get() = getApplication<Application>().applicationContext
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val kakaoMapRepo = KakaoMapRepository(ApiFactory.makeServiceCallApi())

    private val liveDataMessage = SingleLiveEvent<String>()
    private val liveDataProgress = SingleLiveEvent<Boolean>()
    private val liveDataKakaoMap = MutableLiveData<KakaoMapResModel>()



    val getProgressObserver: LiveData<Boolean> get() = liveDataProgress
    val getMessageObserver: LiveData<String> get() = liveDataMessage
    val getKakaoMapObserver: LiveData<KakaoMapResModel> get() = liveDataKakaoMap


    fun getKakaoMap(token: String, location : String) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }

        scope.launch {
            val result =
                kakaoMapRepo.getKakaoMap(token,location)
            result?.let {
                    liveDataKakaoMap.postValue(it)
            }
        }
    }


}