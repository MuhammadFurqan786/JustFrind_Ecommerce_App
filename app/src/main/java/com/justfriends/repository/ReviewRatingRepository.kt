package com.justfriends.repository

import com.google.gson.JsonObject
import com.justfriends.model.*
import com.justfriends.network.RetrofitService
import java.lang.Exception

class ReviewRatingRepository(private val apiService: RetrofitService) : BaseRepository() {


    suspend fun writeReview(
        token: String,
        productId: String,
        review: String,
        rating: Float
    ): WriteReviewResModel? {
        val jsonRequest = JsonObject()
        jsonRequest.addProperty("product_id", productId)
        jsonRequest.addProperty("review", review)
        jsonRequest.addProperty("rating", rating)

        return try {
            safeApiCall(
                call = {
                    apiService.writeReviewAsync(
                        token, jsonRequest
                    ).await()
                },
                error = "Error form server"
            )
        } catch (e: Exception) {
            null
        }

    }

    suspend fun getAllReviews(token: String, userId: Long): ReviewsResModel? {
        return try {
            safeApiCall(
                call = { apiService.getAllReviewsAsync(token, userId).await() },
                error = "Error for Server"
            )
        } catch (e: Exception) {
            null
        }
    }

    suspend fun deleteReview(
        token: String,
        productId: String,
        reviewId: String
    ): DeleteReviewResModel? {
        return try {
            safeApiCall(
                call = { apiService.deleteReviewAsync(token, productId, reviewId).await() },
                error = "Error for Server"
            )
        } catch (e: Exception) {
            null
        }
    }

    suspend fun editReview(
        token: String,
        reviewId: String,
        productId: String,
        review: String,
        rating: Float
    ): EditReviewResModel? {
        val requestBody = JsonObject()
        requestBody.addProperty("product_id", productId)
        requestBody.addProperty("review", review)
        requestBody.addProperty("rating", rating)
        return try {
            safeApiCall(
                call = { apiService.editReviewAsync(token, reviewId, requestBody).await() },
                error = "Error for Server"
            )
        } catch (e: Exception) {
            null
        }
    }




    suspend fun addReviewToUserProfile(
        token: String,
        reviewToUserId: Long,
        comment: String,
        rating: Float
    ): GlobalResModel? {
        val requestBody = JsonObject()
        requestBody.addProperty("review_to_user_id", reviewToUserId)
        requestBody.addProperty("review", comment)
        requestBody.addProperty("rating", rating)
        return safeApiCall(
            call = { apiService.addReviewToUserProfileAsync(token, requestBody).await() },
            error = "Error from server"
        )
    }


    suspend fun editUserProfileReview(
        token: String,
        reviewId: Long,
        reviewToUserId:Long,
        comment: String,
        rating: Float
    ): GlobalResModel? {
        val requestBody = JsonObject()
        requestBody.addProperty("review_to_user_id", reviewToUserId)
        requestBody.addProperty("review", comment)
        requestBody.addProperty("rating", rating)
        return safeApiCall(
            call = { apiService.editUserProfileReviewAsync(token,reviewId, requestBody).await() },
            error = "Error from server"
        )
    }



    suspend fun deleteReviewFromUserId(
        token: String,
        reviewToUserId:Long,
        reviewId: Long,

    ): GlobalResModel? {
        return safeApiCall(
            call = { apiService.deleteReviewFromUserProfileAsync(token,reviewToUserId, reviewId).await() },
            error = "Error from server"
        )
    }

    suspend fun reportReview(
        token: String,
        reviewId: Long,

        ): GlobalResModel? {
        return safeApiCall(
            call = { apiService.reportReviewAsync(token, reviewId).await() },
            error = "Error from server"
        )
    }

}