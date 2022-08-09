package com.justfriends.model

import com.google.gson.annotations.SerializedName

data class AddressResModel(

    @field:SerializedName("data")
    val data: AddressModel,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)

data class AddressModel(
    @field:SerializedName("affectedRows")
    val affectedRows: Int
)