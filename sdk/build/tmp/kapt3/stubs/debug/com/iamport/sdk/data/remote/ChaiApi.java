package com.iamport.sdk.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ/\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/iamport/sdk/data/remote/ChaiApi;", "", "getChaiPayment", "Lcom/iamport/sdk/data/chai/response/ChaiPayment;", "idempotencyKey", "", "publicApiKey", "chaiPaymentId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChaiPaymentSubscription", "Lcom/iamport/sdk/data/chai/response/ChaiPaymentSubscription;", "chaiSubscriptionId", "sdk_debug"})
public abstract interface ChaiApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/v1/payment/{paymentId}")
    @retrofit2.http.Headers(value = {"Content-Type:application/json"})
    public abstract java.lang.Object getChaiPayment(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Idempotency-Key")
    java.lang.String idempotencyKey, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "public-API-Key")
    java.lang.String publicApiKey, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "paymentId")
    java.lang.String chaiPaymentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.iamport.sdk.data.chai.response.ChaiPayment> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/v1/payment/subscription/{subscriptionId}")
    @retrofit2.http.Headers(value = {"Content-Type:application/json"})
    public abstract java.lang.Object getChaiPaymentSubscription(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Idempotency-Key")
    java.lang.String idempotencyKey, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "public-API-Key")
    java.lang.String publicApiKey, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "subscriptionId")
    java.lang.String chaiSubscriptionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.iamport.sdk.data.chai.response.ChaiPaymentSubscription> continuation);
}