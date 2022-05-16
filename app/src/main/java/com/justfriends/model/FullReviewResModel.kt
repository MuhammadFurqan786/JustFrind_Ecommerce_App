package com.justfriends.model

import com.google.gson.annotations.SerializedName

data class FullReviewResModel(

    @field:SerializedName("data")
    val data: List<FullReviewDataItem>,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)


data class FullReviewDataItem(

    @field:SerializedName("user_id")
    val userId: Int? = null,

    @field:SerializedName("review")
    val review: String? = null,

    @field:SerializedName("createdDtm")
    val createdDtm: String? = null,

    @field:SerializedName("user_name")
    val userName: String? = null,

    @field:SerializedName("product_id")
    val productId: Int? = null,

    @field:SerializedName("rating")
    val rating: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("user_img")
    val userImg: String? = null
)
