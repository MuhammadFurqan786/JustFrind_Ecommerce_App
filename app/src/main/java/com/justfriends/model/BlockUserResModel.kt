package com.justfriends.model

import com.google.gson.annotations.SerializedName


data class BlockUserResModel(



    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String
)


