package com.justfriends.repository

import android.util.Log
import com.google.gson.JsonObject
import com.justfriends.model.*
import com.justfriends.network.RetrofitService
import java.lang.Exception

class PostRepository(private val apiService:RetrofitService):BaseRepository() {




    suspend fun getFoundationValues(): FoundationResModel? {
        return try {
            safeApiCall(
                call = {
                    apiService.getFoundationValuesAsync().await()
                }, error = "Error from server" + ""
            )
        } catch (e: Exception) {
            null
        }
    }


    suspend fun getPostDetail(token: String, postId: Long): PostDetailResModel? {
        return try {
            safeApiCall(
                call = { apiService.getPostDetailAsync(token, postId).await() },
                error = "Error for Server"
            )
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getSoldProduct(token: String): SoldProductResModel? {
        return try {
            safeApiCall(
                call = { apiService.getSoldProductAsync(token).await() }, error = "Error for Server"
            )
        } catch (e: Exception) {
            null
        }
    }






    suspend fun getRecentPosts(token: String): PostsResModel? {
        return try {
            safeApiCall(
                call = { apiService.getRecentPostsAsync(token).await() },
                error = "Error form server"
            )
        } catch (e: Exception) {
            null
        }
    }


    suspend fun getCategoryPosts(
        token  :String,
        categoryId: Long
    ): PostsResModel? {
        return try {
            safeApiCall(
                call = { apiService.getCategoryPostsAsync(token,categoryId).await() },
                error = "Error from Server"
            )
        } catch (e: Exception) {
            Log.d("TAG", "getPosts: $e")
            null
        }
    }

    suspend fun getFilteredPosts(
        token: String,
        categoryId: String,
        sortType: String,
        minPrice: String,
        maxPrice: String,
        condition: String,
        latitude:String,
        longitude:String,
        distance: String
    ): PostsResModel?{
        val jsonRequest = JsonObject()
        jsonRequest.addProperty("category_id",categoryId)
        jsonRequest.addProperty("sort_type",sortType)
        jsonRequest.addProperty("minPrice",minPrice)
        jsonRequest.addProperty("maxPrice",maxPrice)
        jsonRequest.addProperty("condition",condition)
        jsonRequest.addProperty("latitude",latitude)
        jsonRequest.addProperty("longitude",longitude)
        jsonRequest.addProperty("distance",distance)

        return try {
            safeApiCall(
                call = {apiService.filterPostsAsync(token,jsonRequest).await()},
                error = "error from server"
            )

        }catch (e:Exception){
            null
        }
    }

    suspend fun getSearchPosts(
        token : String,
        keyboard: String,
    ): PostsResModel? {

        val jsonRequest = JsonObject()
        jsonRequest.addProperty("keyword",keyboard)
        return try {
            safeApiCall(
                call = {
                    apiService.getSearchPostsAsync(
                        token,
                        jsonRequest
                    ).await()
                },
                error = "Error from server"
            )
        } catch (e: Exception) {
            null
        }

    }
}