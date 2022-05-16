package com.justfriends.model

import com.google.gson.annotations.SerializedName


data class FoundationResModel(

    @field:SerializedName("data")
    val data: List<FoundationItem>,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)


data class FoundationItem(

    @field:SerializedName("isDeleted")
    val isDeleted: Int? = null,

    @field:SerializedName("updateDtm")
    val updateDtm: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("createDtm")
    val createDtm: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)



