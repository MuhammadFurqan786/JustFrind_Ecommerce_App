package com.justfriends.repository

import com.justfriends.model.FavouriteItemResModel
import com.justfriends.model.FavouriteResModel
import com.justfriends.network.RetrofitService

class FavouriteRepository(private val apiService: RetrofitService) : BaseRepository() {

    suspend fun getFavouriteData(token : String): FavouriteItemResModel? {
        return try {
            safeApiCall(
                call = { apiService.getFavouritesDataAsync(token).await() },
                error = "Error from Server"
            )
        } catch (e: Exception) {
            null
        }
    }
    suspend fun addToFav(
        token:String,
        postId: Long
    ): FavouriteResModel? {
        return try {
            safeApiCall(
                call = {
                    apiService.addToFavAsync(
                        token,
                        postId
                    ).await()
                },
                error = "Error from server"
            )

        } catch (e: Exception) {
            null
        }
    }
    suspend fun removeFromFav(
        token:String,
        postId: Long
    ): FavouriteResModel? {
        return try {
            safeApiCall(
                call = {
                    apiService.removeFromFavAsync(
                        token,
                        postId
                    ).await()
                },
                error = "Error from server"
            )

        } catch (e: Exception) {
            null
        }
    }


}