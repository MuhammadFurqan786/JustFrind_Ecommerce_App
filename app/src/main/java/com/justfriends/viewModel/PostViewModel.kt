package com.justfriends.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.justfriends.R
import com.justfriends.model.*
import com.justfriends.network.ApiFactory
import com.justfriends.repository.PostRepository
import com.justfriends.utils.Global
import com.justfriends.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class PostViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext get() = getApplication<Application>().applicationContext
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val postRepository = PostRepository(ApiFactory.makeServiceApi())

    private val liveDataMessage = SingleLiveEvent<String>()
    private val liveDataProgress = SingleLiveEvent<Boolean>()

    private val liveDataPostDetail = MutableLiveData<PostDetailData>()
    private val liveDataSoldProduct = MutableLiveData<List<SoldProductData>>()
    private val liveDataPublicProfile = MutableLiveData<PublicProfileResModel>()
    private val liveDataUserProduct = MutableLiveData<List<UserProductData>>()
    private val liveDataProduct = MutableLiveData<List<PostDetailData>>()
    private val liveDataBlockUser = MutableLiveData<BlockUserResModel>()
    private val liveDataCategory = MutableLiveData<List<Category>>()
    private val liveDataSubCategory = MutableLiveData<List<SubCategoryItems>>()
    private val liveDataFoundationValue = MutableLiveData<List<FoundationItem>>()
    private val liveDataPosts = MutableLiveData<List<Post>>()


    val getPostDetailObserver: LiveData<PostDetailData> get() = liveDataPostDetail
    val getSoldProductObserver: LiveData<List<SoldProductData>> get() = liveDataSoldProduct
    val getPublicProfileObserver: LiveData<PublicProfileResModel> get() = liveDataPublicProfile
    val getUserProductObserver: MutableLiveData<List<UserProductData>> get() = liveDataUserProduct
    val getBlockUserObserver : MutableLiveData<BlockUserResModel> get() = liveDataBlockUser

    val getFoundationValuesObserver: LiveData<List<FoundationItem>> get() = liveDataFoundationValue
    val getPostsObserver :LiveData<List<Post>> get() = liveDataPosts

    val getMessageObserver
        get()  : LiveData<String>
        = liveDataMessage

    val getProgressObserver
        get() : LiveData<Boolean>
        = liveDataProgress




    fun getRecentPosts(token: String) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = postRepository.getRecentPosts(token)
            result?.let {
                if (it.success) {
                     liveDataPosts.postValue(it.posts)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
                ?: liveDataMessage.postValue(mContext.getString(R.string.message_something_went_wrong))
            liveDataProgress.postValue(false)
        }
    }


    fun getPostDetail(token: String, postId: Long) {
        if (!Global.hasInternet(mContext)){
            liveDataMessage.postValue(mContext.getString(R.string.message_internet_connection))
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = postRepository.getPostDetail(token, postId)
            result?.let {
                if (it.success) {
                    liveDataPostDetail.postValue(it.data)
                } else {

                    liveDataMessage.postValue(it.message)
                }
            } ?: liveDataMessage.postValue(
                mContext.getString(
                    R.string.error_from_server
                )
            )
            liveDataProgress.postValue(false)
        }
    }


    fun getSoldProduct(token: String) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = postRepository.getSoldProduct(token)
            result?.let {
                if (it.success) {
                    liveDataSoldProduct.postValue(it.data)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
                ?: liveDataMessage.postValue(mContext.getString(R.string.message_something_went_wrong))
            liveDataProgress.postValue(false)
        }
    }



    fun getFoundationValues() {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = postRepository.getFoundationValues()
            result?.let {
                if (it.success) {
                    liveDataFoundationValue.postValue(it.data)

                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
            liveDataProgress.postValue(false)
        }

    }

    fun getCategoryPosts(token: String, categoryId: Long) {
        if (!Global.hasInternet(mContext)) return
        scope.launch {
            liveDataProgress.postValue(true)
            val result = postRepository.getCategoryPosts(token, categoryId)

            result?.let {
                if (it.success) {
                    liveDataPosts.postValue(it.posts)

                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
                ?: liveDataMessage.postValue(mContext.getString(R.string.message_something_went_wrong))
            liveDataProgress.postValue(false)
        }
    }

    fun getFilteredPosts(
        token: String,
        categoryId: String,
        sortType: String,
        minPrice: String,
        maxPrice: String,
        condition: String,
        latitude: String,
        longitude: String,
        distance: String,
    ) {
        if (!Global.hasInternet(mContext)) return
        scope.launch {
            liveDataProgress.postValue(true)
            val result = postRepository.getFilteredPosts(
                token,
                categoryId,
                sortType,
                minPrice,
                maxPrice,
                condition,
                latitude,
                longitude,
                distance
            )
            Log.d("TAG", "getPosts: $result")

            result?.let {
                if (it.success) {
                    liveDataPosts.postValue(it.posts)

                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
                ?: liveDataMessage.postValue(mContext.getString(R.string.message_something_went_wrong))
            liveDataProgress.postValue(false)


        }
    }


    fun getSearchPosts(
        token : String,
        keyword: String,

        ) {
        if (!Global.hasInternet(mContext)) {
            liveDataPosts.postValue(ArrayList())
            liveDataMessage.postValue(mContext.getString(R.string.message_check_internet))
            return
        }

        if (keyword.isEmpty()) {
            liveDataPosts.postValue(ArrayList())
            liveDataMessage.postValue(mContext.getString(R.string.message_search_keyword_required))
            return
        }

        scope.launch {
            liveDataProgress.postValue(true)
            val result = postRepository.getSearchPosts(token,keyword)
            liveDataProgress.postValue(false)

            result?.let {
                if (result.success){
                    liveDataPosts.postValue(result.posts) }
                else{
                    liveDataPosts.postValue(ArrayList())
                }

            }


        }

    }




}


