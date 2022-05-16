package com.justfriends.model

import com.google.gson.annotations.SerializedName

data class GlobalResModel(
    @SerializedName("success")
    val success:Boolean,
    @SerializedName("message")
    val message:String
)
