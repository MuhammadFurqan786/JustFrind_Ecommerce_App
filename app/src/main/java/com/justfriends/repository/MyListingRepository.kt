package com.justfriends.repository

import com.justfriends.model.MarkAsSoldResModel
import com.justfriends.model.PostsResModel
import com.justfriends.network.RetrofitService
import java.lang.Exception

class MyListingRepository(private val apiService: RetrofitService) : BaseRepository() {

    suspend fun getMyMarketPlacePosts(
        token: String,

        ): PostsResModel? {
        return try {
            safeApiCall(
                call = { apiService.getMyMarketplaceAsync(token).await() },
                error = "Error from server"
            )
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getMarkAsSold(
        token: String, productId: Long,
    ): MarkAsSoldResModel? {
        return try {
            safeApiCall(
                call = { apiService.markAsSoldAsync(token, productId).await() },
                error = "Error from server"
            )
        } catch (e: Exception) {
            null
        }
    }
}