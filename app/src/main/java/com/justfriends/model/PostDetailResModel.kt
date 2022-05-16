package com.justfriends.model

import com.google.gson.annotations.SerializedName


data class PostDetailResModel(


    @field:SerializedName("success")
    val success: Boolean,
    @field:SerializedName("error")
    val error: Boolean,
    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("data")
    val data: PostDetailData,
)


data class PostDetailData(
    @SerializedName("id") var id: Long,
    @SerializedName("name") var name: String? = null,
    @SerializedName("img") var img: String? = null,
    @SerializedName("imgs") var imgs: ArrayList<String> = arrayListOf(),
    @SerializedName("product_desc") var productDesc: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("category_id") var categoryId: Int? = null,
    @SerializedName("sub_category_id") var subCategoryId: Int? = null,
    @SerializedName("product_condition") var productCondition: String? = null,
    @SerializedName("latitude") var latitude: String? = null,
    @SerializedName("longitude") var longitude: String? = null,
    @SerializedName("isDeleted") var isDeleted: Int? = null,
    @SerializedName("isSold") var isSold: Int? = null,
    @SerializedName("user_id") var userId: Long,
    @SerializedName("img_path") var imgPath: String? = null,
    @SerializedName("createdDtm") var createdDtm: String? = null,
    @SerializedName("updatedDtm") var updatedDtm: String? = null,
    @SerializedName("isFeatured") var isFeatured: Int? = null,
    @SerializedName("featuredUpto") var featuredUpto: String? = null,
    @SerializedName("is_charity") var isCharity: Int? = null,
    @SerializedName("foundation_id") var foundationId: Int? = null,
    @SerializedName("foundation_name") var foundationName: String? = null,
    @SerializedName("charity_amt") var charityAmt: Int? = null,
    @SerializedName("terms") var terms: Int? = null,
    @SerializedName("chat_id") var chatId: String? = null,
    @SerializedName("isFav") var isFav: Int? = null,
    @SerializedName("user_name") var userName: String? = null,
    @SerializedName("userImg") var userImg: String? = null,
    @SerializedName("mobile") var mobile: String? = null,
    @SerializedName("category_name") var categoryName: String? = null


)
