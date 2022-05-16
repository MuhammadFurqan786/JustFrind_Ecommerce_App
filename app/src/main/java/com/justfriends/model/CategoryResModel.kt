package com.justfriends.model

import com.google.gson.annotations.SerializedName

data class CategoryResModel(

	@field:SerializedName("data")
	val data: List<Category>,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class Category(

	@field:SerializedName("updatedDtm")
	val updatedDtm: String? = null,

	@field:SerializedName("img")
	val img: String? = null,

	@field:SerializedName("isDeleted")
	val isDeleted: Int? = null,

	@field:SerializedName("createdDtm")
	val createdDtm: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Long
)
