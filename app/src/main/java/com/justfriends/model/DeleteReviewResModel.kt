package com.justfriends.model

import com.google.gson.annotations.SerializedName


data class DeleteReviewResModel(

    @field:SerializedName("data")
    val data: DeleteReviewData,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)


data class DeleteReviewData(

    @field:SerializedName("fieldCount")
    val fieldCount: Int? = null,

    @field:SerializedName("serverStatus")
    val serverStatus: Int? = null,

    @field:SerializedName("protocol41")
    val protocol41: Boolean? = null,

    @field:SerializedName("changedRows")
    val changedRows: Int? = null,

    @field:SerializedName("affectedRows")
    val affectedRows: Int? = null,

    @field:SerializedName("warningCount")
    val warningCount: Int? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("insertId")
    val insertId: Int? = null
)
