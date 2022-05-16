package com.justfriends.model

import com.google.gson.annotations.SerializedName

data class ReviewsResModel(
    @SerializedName("success")
    val success:Boolean,
    @SerializedName("message")
    val message:String,
    @SerializedName("data")
    val reviews:List<Review>
)
