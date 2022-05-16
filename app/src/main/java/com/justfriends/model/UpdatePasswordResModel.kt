package com.justfriends.model

import com.google.gson.annotations.SerializedName

data class UpdatePasswordResModel(

    @field:SerializedName("data")
    val data: UpdatePasswordData,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)

data class UpdatePasswordData(
    val any: Any? = null
)
