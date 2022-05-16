package com.justfriends.model

import com.google.gson.annotations.SerializedName

data class FavouriteItemResModel(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: ArrayList<FavouriteItem>
)

data class FavouriteItem(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val productName: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("product_desc")
    val productDescription: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("category_id")
    val categoryId: Long,
    @SerializedName("product_id")
    val productId: Long,
    @SerializedName("isFavourite")
    val isFavourite: Int,
    @SerializedName("isDeleted")
    val isDeleted : Int,
    @SerializedName("isSold")
    val isSold : String,
    @SerializedName("createdDtm")
    val createdDtm : String,
    @SerializedName("user_id")
    val userId : Long
)