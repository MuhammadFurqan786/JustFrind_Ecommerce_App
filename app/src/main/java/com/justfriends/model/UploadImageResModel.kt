package com.justfriends.model

import com.google.gson.annotations.SerializedName


data class UploadImageResModel(

    @field:SerializedName("data")
    val data: UploadImagData,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)


data class UploadImagData(

    @field:SerializedName("userImg")
    val userImg: String? = null
)
