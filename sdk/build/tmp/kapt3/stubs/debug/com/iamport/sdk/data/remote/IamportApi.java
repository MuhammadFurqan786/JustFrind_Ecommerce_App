package com.iamport.sdk.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006JM\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJW\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/iamport/sdk/data/remote/IamportApi;", "", "getUsers", "Lcom/iamport/sdk/data/chai/response/Users;", "impUserCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postApprove", "Lcom/iamport/sdk/data/chai/response/Approve;", "impUid", "paymentId", "idempotencyKey", "status", "Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;", "native", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postApproveSubscription", "impCustomerUid", "subscriptionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postPrepare", "Lcom/iamport/sdk/data/chai/response/Prepare;", "prepareRequest", "Lcom/iamport/sdk/data/chai/request/PrepareRequest;", "(Lcom/iamport/sdk/data/chai/request/PrepareRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_debug"})
public abstract interface IamportApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/users/pg/{impUserCode}")
    @retrofit2.http.Headers(value = {"Content-Type:application/json"})
    public abstract java.lang.Object getUsers(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "impUserCode")
    java.lang.String impUserCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.iamport.sdk.data.chai.response.Users> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/chai_payments/prepare")
    @retrofit2.http.Headers(value = {"Content-Type:application/json"})
    public abstract java.lang.Object postPrepare(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.iamport.sdk.data.chai.request.PrepareRequest prepareRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.iamport.sdk.data.chai.response.Prepare> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "chai_payments/result/{impUserCode}/{impUid}?")
    @retrofit2.http.Headers(value = {"Content-Type:application/json"})
    public abstract java.lang.Object postApprove(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "impUserCode")
    java.lang.String impUserCode, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "impUid")
    java.lang.String impUid, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "paymentId")
    java.lang.String paymentId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "idempotencyKey")
    java.lang.String idempotencyKey, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "status")
    com.iamport.sdk.data.chai.response.ChaiPaymentStatus status, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "native")
    java.lang.String p5_1621174283, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.iamport.sdk.data.chai.response.Approve> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "chai_payments/result/{impUserCode}/{impUid}/{impCustomerUid}?")
    @retrofit2.http.Headers(value = {"Content-Type:application/json"})
    public abstract java.lang.Object postApproveSubscription(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "impUserCode")
    java.lang.String impUserCode, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "impUid")
    java.lang.String impUid, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "impCustomerUid")
    java.lang.String impCustomerUid, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "subscriptionId")
    java.lang.String subscriptionId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "idempotencyKey")
    java.lang.String idempotencyKey, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "status")
    com.iamport.sdk.data.chai.response.ChaiPaymentStatus status, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "native")
    java.lang.String p6_1621174283, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.iamport.sdk.data.chai.response.Approve> continuation);
}