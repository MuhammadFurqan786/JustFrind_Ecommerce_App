package com.justfriends.model

import com.google.gson.annotations.SerializedName

data class PostsResModel(
    @SerializedName("success" ) var success : Boolean,
    @SerializedName("message" ) var message : String,
    @SerializedName("data"    ) var posts    : List<Post> = arrayListOf()
)

data class Post(
    @SerializedName("id"                ) var id               : Long,
    @SerializedName("name"              ) var name             : String? = null,
    @SerializedName("img"               ) var img              : String? = null,
    @SerializedName("imgs"              ) var imgs             : String? = null,
    @SerializedName("product_desc"      ) var productDesc      : String? = null,
    @SerializedName("price"             ) var price            : Int,
    @SerializedName("category_id"       ) var categoryId       : Int,
    @SerializedName("sub_category_id"   ) var subCategoryId    : Int,
    @SerializedName("product_condition" ) var productCondition : String? = null,
    @SerializedName("latitude"          ) var latitude         : String? = null,
    @SerializedName("longitude"         ) var longitude        : String? = null,
    @SerializedName("isDeleted"         ) var isDeleted        : Int,
    @SerializedName("isSold"            ) var isSold           : Int,
    @SerializedName("user_id"           ) var userId           : Int,
    @SerializedName("img_path"          ) var imgPath          : String? = null,
    @SerializedName("createdDtm"        ) var createdDtm       : String? = null,
    @SerializedName("updatedDtm"        ) var updatedDtm       : String? = null,
    @SerializedName("isFeatured"        ) var isFeatured       : Int,
    @SerializedName("featuredUpto"      ) var featuredUpto     : String? = null,
    @SerializedName("is_charity"        ) var isCharity        : Int,
    @SerializedName("foundation_id"     ) var foundationId     : Int,
    @SerializedName("foundation_name"   ) var foundationName   : String? = null,
    @SerializedName("charity_amt"       ) var charityAmt       : Int,
    @SerializedName("terms"             ) var terms            : Int,
    @SerializedName("chat_id"           ) var chatId           : String? = null,
    @SerializedName("isFav"             ) var isFav            : Int
)