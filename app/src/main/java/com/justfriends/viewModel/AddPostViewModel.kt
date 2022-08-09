package com.justfriends.viewModel

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.justfriends.R
import com.justfriends.model.AddPostResModel
import com.justfriends.model.UploadPostModel
import com.justfriends.network.ApiFactory
import com.justfriends.repository.AddPostRepository
import com.justfriends.utils.Global
import com.justfriends.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import kotlin.coroutines.CoroutineContext

class AddPostViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext: Context get() = getApplication<Application>().applicationContext
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val postImages = ArrayList<String>()
    private val postImagesBitmap = ArrayList<Bitmap>()
    private lateinit var mCoverImageBitmap: Bitmap
    private var mCoverImage: String = ""
    private val mUploadPostData = UploadPostModel()
    private val addPostRepo = AddPostRepository(ApiFactory.makeServiceApi())


    private val liveDataPostImages = MutableLiveData<ArrayList<String>>()
    private val liveDataPostImagesBitmap = MutableLiveData<ArrayList<Bitmap>>()
    private val liveDataCoverImage = MutableLiveData<String>()
    private val liveDataCoverImageBitmap = MutableLiveData<Bitmap>()
    private val liveDataProgress = MutableLiveData<Boolean>()
    private val liveDataMessage = MutableLiveData<String>()
    private val liveDataAddPost = SingleLiveEvent<AddPostResModel>()


    val getLiveDataImages
        get() : LiveData<ArrayList<String>>
        = liveDataPostImages


    val getProgressObserver
        get() : LiveData<Boolean>
        = liveDataProgress

    val getMessageObserver
        get()  :LiveData<String>
        = liveDataMessage

    val getAddPostObserver
        get() : LiveData<AddPostResModel>
        = liveDataAddPost

    fun addImageBitmap(image:Bitmap){
        if (postImagesBitmap.isEmpty()) {
            mCoverImageBitmap = image
            liveDataCoverImageBitmap.postValue(mCoverImageBitmap)
        }
        postImagesBitmap.add(image)
        liveDataPostImagesBitmap.postValue(postImagesBitmap)
    }


    fun addImage(image: String) {
        if (postImages.isEmpty()) {
            mCoverImage = image
            liveDataCoverImage.postValue(mCoverImage)
        }
        postImages.add(image)
        liveDataPostImages.postValue(postImages)
    }

    fun removeAllImages() {
        postImages.clear()
        liveDataPostImages.postValue(postImages)
    }

    fun removeAllImagesBitMap() {
        postImagesBitmap.clear()
        liveDataPostImagesBitmap.postValue(postImagesBitmap)
    }

    val getPostData: UploadPostModel get() = mUploadPostData


    fun addPost(token: String, userId: String) {
        if (!Global.hasInternet(mContext)) {

            liveDataMessage.postValue(mContext.getString(R.string.message_check_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val postImagesPart = ArrayList<MultipartBody.Part>()

            for (image in postImagesBitmap) {
                postImagesPart.add(Global.prepareFilePart(mContext,"img", image))
            }
            mUploadPostData.img = postImagesPart
            val result = addPostRepo.addPost(token, mUploadPostData, userId)
            result?.let {
                if (it.success) {
                    liveDataAddPost.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            } ?: liveDataMessage.postValue(mContext.getString(R.string.error_from_server))
            liveDataProgress.postValue(false)
        }
    }
}