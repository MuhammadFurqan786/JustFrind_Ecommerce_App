package com.justfriends.model

import com.google.gson.annotations.SerializedName


data class UpdateEmailResModel(

    @field:SerializedName("data")
    val data: UpdateEmailData,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)


data class UpdateEmailData(
    val any: Any? = null
)
