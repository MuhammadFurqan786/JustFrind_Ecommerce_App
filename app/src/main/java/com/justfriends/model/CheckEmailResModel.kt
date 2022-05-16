package com.justfriends.model

import com.google.gson.annotations.SerializedName

data class CheckEmailResModel(

    @field:SerializedName("data")
    val data: EmailData,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)

data class EmailData(
    val any: Any? = null
)
