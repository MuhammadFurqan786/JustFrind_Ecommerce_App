package com.justfriends.model

import com.google.gson.annotations.SerializedName


data class KakaoMapResModel(

	@field:SerializedName("documents")
	val documents: List<DocumentsItem>,

	@field:SerializedName("meta")
	val meta: Meta? = null
)


data class Address(

	@field:SerializedName("mountain_yn")
	val mountainYn: String? = null,

	@field:SerializedName("h_code")
	val hCode: String? = null,

	@field:SerializedName("region_3depth_name")
	val region3depthName: String? = null,

	@field:SerializedName("main_address_no")
	val mainAddressNo: String? = null,

	@field:SerializedName("x")
	val X: String? = null,

	@field:SerializedName("sub_address_no")
	val subAddressNo: String? = null,

	@field:SerializedName("y")
	val Y: String? = null,

	@field:SerializedName("address_name")
	val addressName: String? = null,

	@field:SerializedName("region_2depth_name")
	val region2depthName: String? = null,

	@field:SerializedName("region_3depth_h_name")
	val region3depthHName: String? = null,

	@field:SerializedName("region_1depth_name")
	val region1depthName: String? = null,

	@field:SerializedName("b_code")
	val bCode: String? = null
)


data class DocumentsItem(

	@field:SerializedName("address")
	val address: Address? = null,

	@field:SerializedName("address_type")
	val addressType: String? = null,

	@field:SerializedName("x")
	val X: String? = null,

	@field:SerializedName("y")
	val Y: String? = null,

	@field:SerializedName("address_name")
	val addressName: String? = null,

	@field:SerializedName("road_address")
	val roadAddress: Any? = null
)


data class Meta(

	@field:SerializedName("total_count")
	val totalCount: Int? = null,

	@field:SerializedName("is_end")
	val isEnd: Boolean? = null,

	@field:SerializedName("pageable_count")
	val pageableCount: Int? = null
)
