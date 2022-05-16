package com.justfriends.model

import com.google.gson.annotations.SerializedName


data class CheckMobileResModel(

    @field:SerializedName("data")
    val data: CheckMobileData,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)


data class CheckMobileData(
    val any: Any? = null
)
