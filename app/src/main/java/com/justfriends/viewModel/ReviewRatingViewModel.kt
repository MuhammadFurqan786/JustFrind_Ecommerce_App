package com.justfriends.viewModel

import android.app.Application
import android.content.Context
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.justfriends.R
import com.justfriends.model.*
import com.justfriends.network.ApiFactory
import com.justfriends.repository.ReviewRatingRepository
import com.justfriends.utils.Global
import com.justfriends.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ReviewRatingViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext: Context get() = getApplication<Application>().applicationContext
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val reviewRatingRepo = ReviewRatingRepository(ApiFactory.makeServiceApi())

    private val liveDataMessage = SingleLiveEvent<String>()
    private val liveDataProgress = SingleLiveEvent<Boolean>()
    private val liveDataWriteReview = SingleLiveEvent<WriteReviewResModel>()
    private val liveDataReviews = MutableLiveData<List<Review>>()
    private val liveDataAddReviewToUserProfile = MutableLiveData<GlobalResModel>()
    private val liveDataDeleteReview = MutableLiveData<GlobalResModel>()
    private val liveDataReportReview = MutableLiveData<GlobalResModel>()


    val getAllReviewsObserver: LiveData<List<Review>> get() = liveDataReviews
    val getDeleteReviewObserver: LiveData<GlobalResModel> get() = liveDataDeleteReview
    val getReportReviewObserver: LiveData<GlobalResModel> get() = liveDataReportReview
    val getAddReviewToUserProfileObserver: LiveData<GlobalResModel> = liveDataAddReviewToUserProfile

    val getProgressObserver
        get() : LiveData<Boolean>
        = liveDataProgress

    val getMessageObserver
        get() : LiveData<String>
        = liveDataMessage


    fun writeReview(
        token: String,
        productId: String,
        review: String,
        rating: Float
    ) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }

        if (TextUtils.isEmpty(review)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_enter_name))
            return
        }

        if (TextUtils.isEmpty(rating.toString())) {
            liveDataMessage.postValue(mContext.getString(R.string.message_rate_a_product))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = reviewRatingRepo.writeReview(token, productId, review, rating)
            result?.let {
                if (it.success) {
                    liveDataWriteReview.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
                liveDataProgress.postValue(false)
            }
        }
    }

    fun getAllReviews(token: String, userId: Long) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = reviewRatingRepo.getAllReviews(token, userId)
            result?.let {
                if (it.success) {
                    liveDataReviews.postValue(it.reviews)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }
                ?: liveDataMessage.postValue(mContext.getString(R.string.message_something_went_wrong))
            liveDataProgress.postValue(false)
        }
    }


    fun addReviewToUserProfile(
        token: String,
        reviewToUserId: Long,
        comment: String,
        rating: Float
    ) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result =
                reviewRatingRepo.addReviewToUserProfile(token, reviewToUserId, comment, rating)
            liveDataProgress.postValue(false)
            result?.let {
                if (it.success) {
                    liveDataAddReviewToUserProfile.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }


        }

    }


    fun editUserProfileReview(
        token: String,
        reviewId: Long,
        reviewToUserId: Long,
        comment: String,
        rating: Float
    ) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = reviewRatingRepo.editUserProfileReview(
                token,
                reviewId,
                reviewToUserId,
                comment,
                rating
            )
            liveDataProgress.postValue(false)
            result?.let {
                if (it.success) {
                    liveDataAddReviewToUserProfile.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }


        }
    }


        fun deleteReviewFromUserProfile(
            token: String,
            reviewToUserId: Long,
            reviewId: Long,
        ) {
            if (!Global.hasInternetConnectivity(mContext)) {
                liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
                return
            }
            scope.launch {
                liveDataProgress.postValue(true)
                val result =
                    reviewRatingRepo.deleteReviewFromUserId(token, reviewToUserId, reviewId)
                liveDataProgress.postValue(false)
                result?.let {
                    if (it.success) {
                        liveDataDeleteReview.postValue(it)
                    } else {
                        liveDataMessage.postValue(it.message)
                    }
                }


            }

        }


    fun reportReview(
        token: String,
        reviewId: Long,
    ) {
        if (!Global.hasInternetConnectivity(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.check_your_internet))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result =
                reviewRatingRepo.reportReview(token, reviewId)
            liveDataProgress.postValue(false)
            result?.let {
                if (it.success) {
                    liveDataReportReview.postValue(it)
                } else {
                    liveDataMessage.postValue(it.message)
                }
            }


        }

    }


}
