package com.justfriends.model

import com.google.gson.annotations.SerializedName


data class PublicProfileResModel(

    @field:SerializedName("data")
    val data: PublicProfileData,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)


data class PublicProfileData(

    @SerializedName("id"         ) var id         : Long,
    @SerializedName("email"      ) var email      : String,
    @SerializedName("name"       ) var name       : String,
    @SerializedName("mobile"     ) var mobile     : String,
    @SerializedName("isDeleted"  ) var isDeleted  : Int,
    @SerializedName("createdDtm" ) var createdDtm : String,
    @SerializedName("updatedDtm" ) var updatedDtm : String,
    @SerializedName("deviceId"   ) var deviceId   : String,
    @SerializedName("platform"   ) var platform   : String,
    @SerializedName("userImg"    ) var userImg    : String,
    @SerializedName("deviceType" ) var deviceType : String,
    @SerializedName("gmail"      ) var gmail      : String,
    @SerializedName("facebook"   ) var facebook   : String,
    @SerializedName("kakao"      ) var kakao      : String,
    @SerializedName("latitude"   ) var latitude   : String,
    @SerializedName("longitude"  ) var longitude  : String,
    @SerializedName("token"      ) var token      : String,
    @SerializedName("isActive"   ) var isActive   : Int,
    @SerializedName("chat_id"    ) var chatId     : String,
    @SerializedName("rating"     ) var rating     : Float,
    @SerializedName("myreview"   ) var myreview   : ArrayList<Review>  = arrayListOf(),
    @SerializedName("reviews"    ) var reviews    : ArrayList<Review> = arrayListOf()
)

data class Review (
    @SerializedName("id"                ) var id             : Long,
    @SerializedName("review_to_user_id" ) var reviewToUserId : Long,
    @SerializedName("review_by_user_id" ) var reviewByUserId : Long,
    @SerializedName("review"            ) var review         : String,
    @SerializedName("rating"            ) var rating         : Float,
    @SerializedName("createdDtm"        ) var createdDtm     : String,
    @SerializedName("user_img"          ) var userImg        : String,
    @SerializedName("user_name"         ) var userName       : String,

)
