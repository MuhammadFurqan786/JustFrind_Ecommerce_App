package com.justfriends.viewModel

import android.app.Application
import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.justfriends.R
import com.justfriends.model.ReportResModel
import com.justfriends.network.ApiFactory
import com.justfriends.repository.ReportRepository
import com.justfriends.utils.Global
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ReportViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext get() = getApplication<Application>().applicationContext
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val reportRepo = ReportRepository(ApiFactory.makeServiceApi())

    private val liveDataProgress = MutableLiveData<Boolean>()
    private val liveDataMessage = MutableLiveData<String>()
    private val liveDataReport = MutableLiveData<ReportResModel>()

    val getProgressObserver
        get() : LiveData<Boolean>
        = liveDataProgress

    val getReportObserver
        get() : LiveData<ReportResModel>
        = liveDataReport

    val getMessageObserver
        get() : LiveData<String>
        = liveDataMessage


   /* fun reportPost(
        userId: String,
        postId: String,
        reportType: String,
        comments: String,
        status: String = "1",

        ) {


        if (!Global.hasInternet(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_check_internet))
            return
        }

        if (userId.isEmpty()) {
            liveDataMessage.postValue(mContext.getString(R.string.message_login_first))
            return
        }
        scope.launch {
            liveDataProgress.postValue(true)
            val result = reportRepo.reportPost(userId, postId, reportType, comments, status)

            result?.let {
                if (it.success) {
                    liveDataReport.postValue(result)
                } else {
                    liveDataMessage.postValue(mContext.getString(R.string.error_from_server))
                }

            }



            liveDataProgress.postValue(false)
        }

    }*/

    fun reportUser(
        token: String,
        reportUserId: Long,
        reportType: String,
        comments: String,
    ) {
        if (!Global.hasInternet(mContext)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_check_internet))
            return
        }

        if (TextUtils.isEmpty(comments)) {
            liveDataMessage.postValue(mContext.getString(R.string.message_comment_required))
        }
        if (token.isEmpty()) {
            liveDataMessage.postValue(mContext.getString(R.string.message_login_first))
            return
        }
        if(reportUserId < 1){
            Log.d("TAG", "reportUser: Report user id is $reportUserId")
            return
        }

        scope.launch {
            liveDataProgress.postValue(true)
            val result = reportRepo.reportUser(token, reportUserId, reportType,comments)
            liveDataProgress.postValue(false)
            result?.let {
                if (it.success) {
                    liveDataReport.postValue(it)
                }
                else{
                    liveDataMessage.postValue(it.message)
                }




            } ?: liveDataMessage.postValue(mContext.getString(R.string.error_from_server))

        }
    }
}