package com.justfriends.network

import com.google.gson.JsonObject
import com.justfriends.model.*
import kotlinx.coroutines.Deferred
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

public interface RetrofitService {


    @POST("user/signup")
    suspend fun signUpAsync(
        @Body signUpRequestBody: JsonObject,
    ): Response<SignUpResModel>


    @POST("user/signin")
    fun loginAsync(
        @Body loginRequestBody: JsonObject,
    ): Deferred<Response<LoginResModel>>

    @GET("user/sendotp/{phone_number}")
    fun getOtpAsync(
        @Path("phone_number") phoneNumber: String,
    ): Deferred<Response<OtpResModel>>

    @POST("user/social")
    fun socialAsync(
        @Body loginRequestBody: JsonObject,
    ): Deferred<Response<LoginResModel>>

    @GET("user/forget/{email}")
    fun forgotPasswordAsync(
        @Path("email")
        email: String,
    ): Deferred<Response<GlobalResModel>>

    @POST("user/updatepassword")
    fun getUpdatePasswordAsync(
        @Header("Authorization") token: String,
        @Body updatePasswordRequestBody: JsonObject,
    ): Deferred<Response<UpdatePasswordResModel>>


    @GET("user/{user_id}")
    suspend fun getUserDataAsync(
        @Header("Authorization") token: String,
        @Path("user_id") userId: String,
    ): Deferred<Response<UserResModel>>


    @GET("user/checkemail/{email}")
    fun checkEmailAsync(
        @Path("email") email: String,
    ): Deferred<Response<CheckEmailResModel>>

    @GET("user/checkmobile/{mobile}")
    fun checkMobileAsync(
        @Path("mobile") mobile: String,
    ): Deferred<Response<CheckMobileResModel>>


    @GET("category")
    fun getCategoryAsync(): Deferred<Response<CategoryResModel>>

    @GET("products")
    fun getRecentPostsAsync(
        @Header("Authorization") token: String,
    ): Deferred<Response<PostsResModel>>

    @GET("category/2")
    fun getSubCategoriesAsync(): Deferred<Response<SubCategoryResModel>>

    @GET("foundation")
    fun getFoundationValuesAsync(): Deferred<Response<FoundationResModel>>


    @Multipart
    @POST("products/create")
    fun addPostAsync(
        @Header("Authorization") token: String,
        @Part("user_id") userId: RequestBody,
        @Part("name") productName: RequestBody,
        @Part("product_desc") productDescription: RequestBody,
        @Part("price") productPrice: RequestBody,
        @Part("category_id") category: RequestBody,
        @Part("latitude") latitude: RequestBody,
        @Part("longitude") longitude: RequestBody,
        @Part img: ArrayList<MultipartBody.Part>,
        @Part("sub_category_id") subCategoryId: RequestBody,
        @Part("product_condition") productCondition: RequestBody,
        @Part("is_charity") isCharity: RequestBody,
        @Part("foundation_id") foundationId: RequestBody,
        @Part("foundation_name") foundationName: RequestBody,
        @Part("charity_amt") charityAmount: RequestBody,
        @Part("terms") terms: RequestBody,
    ): Deferred<Response<AddPostResModel>>


    @POST("products/myproducts")
    fun getMyMarketplaceAsync(
        @Header("Authorization") token: String,
    ): Deferred<Response<PostsResModel>>

    @GET("products/category/{category_id}")
    fun getCategoryPostsAsync(
        @Header("Authorization") token: String,
        @Path("category_id") categoryId: Long,
    ): Deferred<Response<PostsResModel>>

    @POST("products/favourite")
    fun getFavouritesDataAsync(
        @Header("Authorization") token: String,
    ): Deferred<Response<FavouriteItemResModel>>


    @POST("products/favourite/{product_id}")
    fun addToFavAsync(
        @Header("Authorization") token: String,
        @Path("product_id") postId: Long,
    ): Deferred<Response<FavouriteResModel>>

    @DELETE("products/favourite/{product_id}")
    fun removeFromFavAsync(
        @Header("Authorization") token: String,
        @Path("product_id") postId: Long,
    ): Deferred<Response<FavouriteResModel>>

    @PUT("products/marksold/{product_id}")
    fun markAsSoldAsync(
        @Header("Authorization") token: String,
        @Path("product_id") postId: Long,
    ): Deferred<Response<MarkAsSoldResModel>>

    @GET("products/{post_id}")
    fun getPostDetailAsync(
        @Header("Authorization") token: String,
        @Path("post_id") postId: Long,
    ): Deferred<Response<PostDetailResModel>>

    @POST("products/mysoldproducts")
    fun getSoldProductAsync(
        @Header("Authorization") token: String,
    ): Deferred<Response<SoldProductResModel>>

    @GET("user/{user_id}")
    fun getPublicProfileAsync(
        @Header("Authorization") token: String,
        @Path("user_id") userId: String,
    ): Deferred<Response<PublicProfileResModel>>

    @GET("review/{user_id}")
    fun getAllReviewsAsync(
        @Header("Authorization") token: String,
        @Path("user_id") user_id: Long,
    ): Deferred<Response<ReviewsResModel>>

    @DELETE("review/delete/{product_id}/{review_id}")
    fun deleteReviewAsync(
        @Header("Authorization") token: String,
        @Path("product_id") productId: String,
        @Path("review_id") reviewId: String
    ): Deferred<Response<DeleteReviewResModel>>

    @PUT("review/edit/{review_id}")
    fun editReviewAsync(
        @Header("Authorization") token: String,
        @Path("review_id") reviewId: String,
        @Body requestBody: JsonObject
    ): Deferred<Response<EditReviewResModel>>

    @POST("review/report/{report_id}")
    fun reportReviewAsync(
        @Header("Authorization") token: String,
        @Path("report_id") reviewId: String,
        @Body requestBody: JsonObject
    ): Deferred<Response<ReportReviewResModel>>


    @POST("products/productsbyuser/{user_id}")
    fun getUserMarketPlaceAsync(
        @Header("Authorization") token: String,
        @Path("user_id") userId: Long,
    ): Deferred<Response<PostsResModel>>

    @POST("user/report")
    fun reportUserProfileAsync(
        @Header("Authorization") token: String,
        @Body requestBody: JsonObject,
    ): Deferred<Response<ReportResModel>>

    @FormUrlEncoded
    @POST("add_report")
    fun reportPostAsync(
        @Field("user_id") userId: String,
        @Field("service_id") postId: String,
        @Field("report_type") reportType: String,
        @Field("comments") comments: String,
        @Field("status") status: String,
    ): Deferred<Response<ReportResModel>>

    @POST("products/search")
    fun getSearchPostsAsync(
        @Header("Authorization") token: String,
        @Body jsonObject: JsonObject
    ): Deferred<Response<PostsResModel>>

    @POST("products/filter")
    fun filterPostsAsync(
        @Header("Authorization") token: String,
        @Body jsonRequest: JsonObject
    ): Deferred<Response<PostsResModel>>

    @GET("user/blockuser/{user_id}")
    fun blockUserAsync(
        @Header("Authorization") token: String,
        @Path("user_id") userId: Long
    ): Deferred<Response<BlockUserResModel>>


    @POST("user/updateprofile")
    suspend fun updateNameAsync(
        @Header("Authorization") token: String,
        @Body jsonRequest: JsonObject
    ): Deferred<Response<UpdateNameResModel>>

    @POST("review/add")
    fun writeReviewAsync(
        @Header("Authorization") token: String,
        @Body jsonRequest: JsonObject
    ): Deferred<Response<WriteReviewResModel>>

    @POST("user/editemail/{email}")
    fun updateEmailAsync(
        @Header("Authorization") token: String,
        @Path("email") email: String
    ): Deferred<Response<UpdateEmailResModel>>

    @Multipart
    @POST("user/uploadprofileimg")
    fun updateProfileImagesAsync(
        @Header("Authorization") token: String,
        @Part profileImage: MultipartBody.Part,
    ): Deferred<Response<UploadImageResModel>>

    @GET("local/search/address")
    suspend fun getKakaoMapAsync(
        @Header("Authorization") token: String,
        @Query("query") query: String
    ): Deferred<Response<KakaoMapResModel>>


    @POST("review/add")
    fun addReviewToUserProfileAsync(
        @Header("Authorization") token: String,
        @Body requestBody: JsonObject
    ): Deferred<Response<GlobalResModel>>

    @PUT("review/edit/{review_id}")
    fun editUserProfileReviewAsync(
        @Header("Authorization") token: String,
        @Path("review_id") reviewId: Long,
        @Body requestBody: JsonObject
    ): Deferred<Response<GlobalResModel>>


    @DELETE("review/delete/{review_to_user_id}/{review_id}")
    fun deleteReviewFromUserProfileAsync(
        @Header("Authorization") token: String,
        @Path("review_to_user_id") reviewToUserId: Long,
        @Path("review_id") reviewId: Long,
    ): Deferred<Response<GlobalResModel>>


    @POST("review/report/{review_id}")
    fun reportReviewAsync(
        @Header("Authorization") token: String,
        @Path("review_id") reviewId: Long,

        ): Deferred<Response<GlobalResModel>>


}