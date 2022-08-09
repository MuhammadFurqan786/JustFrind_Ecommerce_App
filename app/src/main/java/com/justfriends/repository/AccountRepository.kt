package com.justfriends.repository

import android.util.Log
import com.justfriends.model.*
import com.justfriends.network.RetrofitService
import java.lang.Exception

class AccountRepository(private val apiService: RetrofitService) : BaseRepository() {

    suspend fun getPublicProfile(token: String, userID: String): PublicProfileResModel? {
        return try {
            safeApiCall(
                call = { apiService.getPublicProfileAsync(token, userID).await() },
                error = "Error for Server"
            )
        } catch (e: Exception) {
            null
        }
    }

    suspend fun blockUser(token: String, userId: Long): BlockUserResModel? {
        return try {
            safeApiCall(
                call = {
                    apiService.blockUserAsync(token, userId).await()
                },
                error = "Error for Server"
            )
        } catch (e: Exception) {
            Log.d("TAG", "blockUser: exception is ${e.localizedMessage} ")
            null
        }
    }

    suspend fun getMarketPlacePosts(
        token: String,
        userId: Long,
    ): PostsResModel? {
        return try {
            safeApiCall(
                call = { apiService.getUserMarketPlaceAsync(token, userId).await() },
                error = "Error form server"
            )
        } catch (e: Exception) {
            null
        }
    }


}