package com.justfriends.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class FilterResModel(

	@field:SerializedName("data")
	val data: List<FilterDataItem> ,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)


data class FilterDataItem(

	@field:SerializedName("updatedDtm")
	val updatedDtm: String,

	@field:SerializedName("img")
	val img: String,

	@field:SerializedName("distance")
	val distance: Int,

	@field:SerializedName("latitude")
	val latitude: String,

	@field:SerializedName("foundation_id")
	val foundationId: Int,

	@field:SerializedName("product_desc")
	val productDesc: String,

	@field:SerializedName("charity_amt")
	val charityAmt: Int,

	@field:SerializedName("category_id")
	val categoryId: Int,

	@field:SerializedName("isDeleted")
	val isDeleted: Int,

	@field:SerializedName("terms")
	val terms: Int,

	@field:SerializedName("price")
	val price: Int,

	@field:SerializedName("sub_category_id")
	val subCategoryId: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("foundation_name")
	val foundationName: String,

	@field:SerializedName("isFeatured")
	val isFeatured: Int,

	@field:SerializedName("longitude")
	val longitude: String,

	@field:SerializedName("imgs")
	val imgs: String,

	@field:SerializedName("product_condition")
	val productCondition: String,

	@field:SerializedName("isFav")
	val isFav: Int,

	@field:SerializedName("featuredUpto")
	val featuredUpto: String,

	@field:SerializedName("user_id")
	val userId: Int,

	@field:SerializedName("img_path")
	val imgPath: String,

	@field:SerializedName("isSold")
	val isSold: Int,

	@field:SerializedName("createdDtm")
	val createdDtm: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("is_charity")
	val isCharity: Int
)
