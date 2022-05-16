package com.justfriends.repository

import android.util.Log
import com.justfriends.model.CategoryResModel
import com.justfriends.model.SubCategoryResModel
import com.justfriends.network.RetrofitService
import java.lang.Exception

class CategoryRepository(private val apiService:RetrofitService):BaseRepository() {

    suspend fun getCategories(): CategoryResModel? {
        return try {
            safeApiCall(
                call = {
                    apiService.getCategoryAsync().await()
                }, error = "Error from server" + ""
            )
        } catch (e: Exception) {
            Log.d("TAG", "getCategories: ${e.localizedMessage}")
            null
        }
    }


    suspend fun getSubCategories(): SubCategoryResModel? {
        return try {
            safeApiCall(
                call =
                {
                    apiService.getSubCategoriesAsync().await()
                }, error = "Error from server" + ""
            )
        } catch (e: Exception) {
            null
        }
    }
}