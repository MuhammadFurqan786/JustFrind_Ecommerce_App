package com.justfriends.model

import com.google.gson.annotations.SerializedName


data class SoldProductResModel(

	@field:SerializedName("data")
	val data: List<SoldProductData>,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)


data class SoldProductData(

	@field:SerializedName("updatedDtm")
	val updatedDtm: String? = null,

	@field:SerializedName("img")
	val img: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("foundation_id")
	val foundationId: Int? = null,

	@field:SerializedName("product_desc")
	val productDesc: String? = null,

	@field:SerializedName("charity_amt")
	val charityAmt: Int? = null,

	@field:SerializedName("category_id")
	val categoryId: Int? = null,

	@field:SerializedName("isDeleted")
	val isDeleted: Int? = null,

	@field:SerializedName("terms")
	val terms: Int? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("sub_category_id")
	val subCategoryId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("foundation_name")
	val foundationName: String? = null,

	@field:SerializedName("isFeatured")
	val isFeatured: Int? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null,

	@field:SerializedName("imgs")
	val imgs: String? = null,

	@field:SerializedName("product_condition")
	val productCondition: String? = null,

	@field:SerializedName("isFav")
	val isFav: Int? = null,

	@field:SerializedName("featuredUpto")
	val featuredUpto: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("img_path")
	val imgPath: String? = null,

	@field:SerializedName("isSold")
	val isSold: Int? = null,

	@field:SerializedName("createdDtm")
	val createdDtm: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("is_charity")
	val isCharity: Int? = null
)
