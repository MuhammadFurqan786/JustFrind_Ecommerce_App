package com.justfriends.repository


import android.util.Log
import com.justfriends.model.AddPostResModel
import com.justfriends.model.UploadPostModel
import com.justfriends.network.RetrofitService
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class AddPostRepository(private val apiService: RetrofitService) : BaseRepository() {


    suspend fun addPost(token: String, post: UploadPostModel, userId: String): AddPostResModel? {
        Log.d("TAG", "addPost: $post")

        return try {
            safeApiCall(
                call = {
                    apiService.addPostAsync(
                        token,
                        userId.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.name.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.product_desc.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.price.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.category_id.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.latitude.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.longitude.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.img,
                        post.sub_category_id.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.production_condition.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.is_charity.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.foundation_id.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.foundation_name.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.charity_amt.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
                        post.terms.toRequestBody("multipart/form-data".toMediaTypeOrNull())
                    ).await()
                },
                error = "Error from server"
            )
        } catch (e: Exception) {
            Log.d("TAG", "addPost: ${e.localizedMessage}  ${e.printStackTrace()}")
            null
        }

    }


}