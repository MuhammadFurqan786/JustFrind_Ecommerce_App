package com.justfriends.model

import com.google.gson.annotations.SerializedName

data class AddPostResModel(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: AddPostData

)

data class AddPostData(
    @SerializedName("product_id")
    val productId: Long
)
