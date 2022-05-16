package com.justfriends.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.justfriends.R
import com.justfriends.model.Category
import com.justfriends.model.SubCategoryItems
import com.justfriends.network.ApiFactory
import com.justfriends.repository.CategoryRepository
import com.justfriends.repository.PostRepository
import com.justfriends.utils.Global
import com.justfriends.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CategoryViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext get() = getApplication<Application>().applicationContext
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val categoryRepository = CategoryRepository(ApiFactory.makeServiceApi())

    private val liveDataMessage = SingleLiveEvent<String>()
    private val liveDataProgress = SingleLiveEvent<Boolean>()
    private val liveDataCategory = MutableLiveData<List<Category>>()
    private val liveDataSubCategory = MutableLiveData<List<SubCategoryItems>>()


    val getProgressObserver : LiveData<Boolean> get() = liveDataProgress
    val getMessageObserver :LiveData<String>get() = liveDataMessage
    val getCategoryObserver: LiveData<List<Category>> get() = liveDataCategory
    val getSubCategoriesObserver: LiveData<List<SubCategoryItems>> get() = liveDataSubCategory


    fun getCategories() {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = categoryRepository.getCategories()

            result?.let {
                if (it.success) {
                    liveDataCategory.postValue(it.data)

                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
            liveDataProgress.postValue(false)
        }
    }

    fun getSubCategories() {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = categoryRepository.getSubCategories()
            result?.let {
                if (it.success) {
                    liveDataSubCategory.postValue(it.data)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
            liveDataProgress.postValue(false)
        }
    }



}