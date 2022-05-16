package com.justfriends.repository

import android.util.Log
import com.google.gson.JsonObject
import com.justfriends.model.ReportResModel
import com.justfriends.network.RetrofitService

class ReportRepository(private val apiService: RetrofitService) : BaseRepository() {


      suspend fun reportPost(
          userId: String,
          postId: String,
          reportType: String,
          comments: String,
          status: String
      ): ReportResModel? {
          return try {
              safeApiCall(
                  call = {
                      apiService.reportPostAsync(
                          userId,
                          postId,
                          reportType,
                          comments,
                          status
                      ).await()
                  },
                  error = "Error form server"
              )
          } catch (e: Exception) {
              null
          }

      }


    suspend fun reportUser(
        token: String,
        reportUserId: Long,
        reportType: String,
        comments: String,
    ): ReportResModel? {
        return try {
            val requestBody = JsonObject()
            requestBody.addProperty("reported_user", reportUserId)
            requestBody.addProperty("type", reportType)
            requestBody.addProperty("comment", comments)
            safeApiCall(
                call = {
                    apiService.reportUserProfileAsync(
                        token,
                        requestBody
                    ).await()
                },
                error = "Error from server"
            )

        } catch (e: Exception) {
            Log.d("TAG", "reportUser: ${e.localizedMessage} ")
            null
        }
    }
}