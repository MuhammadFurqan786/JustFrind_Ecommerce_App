package com.justfriends.model

import okhttp3.MultipartBody

data class UploadPostModel(
    var name: String = "",
    var img: ArrayList<MultipartBody.Part> = ArrayList(),
    var product_desc: String = "",
    var price: String = "",
    var category_id: String = "",
    var sub_category_id: String = "",
    var production_condition: String = "",
    var latitude: String = "",
    var longitude: String = "",
    var user_id: String = "",
    var is_charity: String = "",
    var foundation_id: String = "",
    var charity_amt: String = "",
    var terms: String = "",
    var foundation_name : String = ""
)