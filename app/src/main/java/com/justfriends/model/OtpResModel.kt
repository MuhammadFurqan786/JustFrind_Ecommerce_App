package com.justfriends.model

import com.google.gson.annotations.SerializedName


data class OtpResModel(

    @field:SerializedName("data")
    val data: OtpData,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)

data class OtpData(

    @field:SerializedName("OTP")
    val oTP: Int? = null
)
