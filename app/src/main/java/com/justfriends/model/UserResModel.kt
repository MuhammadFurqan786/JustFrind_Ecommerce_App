package com.justfriends.model

import com.google.gson.annotations.SerializedName

data class UserResModel(

	@field:SerializedName("data")
	val data: UserDetail,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class UserDetail(

	@field:SerializedName("deviceType")
	val deviceType: String? = null,

	@field:SerializedName("gmail")
	val gmail: String? = null,

	@field:SerializedName("updatedDtm")
	val updatedDtm: String? = null,

	@field:SerializedName("userImg")
	val userImg: String? = null,

	@field:SerializedName("facebook")
	val facebook: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("mobile")
	val mobile: String? = null,

	@field:SerializedName("isActive")
	val isActive: Int? = null,

	@field:SerializedName("deviceId")
	val deviceId: String? = null,

	@field:SerializedName("platform")
	val platform: String? = null,

	@field:SerializedName("token")
	val token: String? = null,

	@field:SerializedName("isDeleted")
	val isDeleted: Int? = null,

	@field:SerializedName("createdDtm")
	val createdDtm: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
)