package com.iamport.sampleapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\'\u001a\u00020(J\b\u0010)\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020+H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b\u00a8\u0006,"}, d2 = {"Lcom/iamport/sampleapp/ViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "amount", "", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "cardDirectCode", "getCardDirectCode", "setCardDirectCode", "merchantUid", "getMerchantUid", "setMerchantUid", "payMethod", "Lcom/iamport/sdk/data/sdk/PayMethod;", "getPayMethod", "()Lcom/iamport/sdk/data/sdk/PayMethod;", "setPayMethod", "(Lcom/iamport/sdk/data/sdk/PayMethod;)V", "paymentName", "getPaymentName", "setPaymentName", "pg", "Lcom/iamport/sdk/data/sdk/PG;", "getPg", "()Lcom/iamport/sdk/data/sdk/PG;", "setPg", "(Lcom/iamport/sdk/data/sdk/PG;)V", "resultCallback", "Landroidx/lifecycle/MutableLiveData;", "Lcom/iamport/sdk/domain/utils/Event;", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "getResultCallback", "()Landroidx/lifecycle/MutableLiveData;", "userCode", "getUserCode", "setUserCode", "createIamPortRequest", "Lcom/iamport/sdk/data/sdk/IamPortRequest;", "getRandomCustomerUid", "onCleared", "", "gateway_debug"})
public final class ViewModel extends androidx.lifecycle.ViewModel {
    public com.iamport.sdk.data.sdk.PG pg;
    public com.iamport.sdk.data.sdk.PayMethod payMethod;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String userCode = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String paymentName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String merchantUid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String amount = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String cardDirectCode = "";
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.IamPortResponse>> resultCallback = null;
    
    public ViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.PG getPg() {
        return null;
    }
    
    public final void setPg(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.PG p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.PayMethod getPayMethod() {
        return null;
    }
    
    public final void setPayMethod(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.PayMethod p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserCode() {
        return null;
    }
    
    public final void setUserCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPaymentName() {
        return null;
    }
    
    public final void setPaymentName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMerchantUid() {
        return null;
    }
    
    public final void setMerchantUid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAmount() {
        return null;
    }
    
    public final void setAmount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCardDirectCode() {
        return null;
    }
    
    public final void setCardDirectCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.IamPortResponse>> getResultCallback() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    /**
     * SDK 에 결제 요청할 데이터 구성
     */
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.IamPortRequest createIamPortRequest() {
        return null;
    }
    
    private final java.lang.String getRandomCustomerUid() {
        return null;
    }
}