package com.justfriends.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class SubCategoryResModel(

    @field:SerializedName("data")
    val data: List<SubCategoryItems>,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String
)

data class SubCategoryItems(

    @field:SerializedName("category_id")
    val categoryId: Int? = null,

    @field:SerializedName("createdDtm")
    val createdDtm: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)
