package com.iamport.sdk.domain.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/iamport/sdk/domain/utils/NativeLiveDataEventBus;", "", "()V", "chaiApprove", "Landroidx/lifecycle/MutableLiveData;", "Lcom/iamport/sdk/domain/utils/Event;", "Lcom/iamport/sdk/data/sdk/IamPortApprove;", "getChaiApprove", "()Landroidx/lifecycle/MutableLiveData;", "chaiUri", "", "getChaiUri", "impResponse", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "getImpResponse", "isPolling", "", "webViewActivityPayment", "Lcom/iamport/sdk/data/sdk/Payment;", "getWebViewActivityPayment", "sdk_debug"})
public class NativeLiveDataEventBus {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.IamPortResponse>> impResponse = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<java.lang.String>> chaiUri = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.Payment>> webViewActivityPayment = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.IamPortApprove>> chaiApprove = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<java.lang.Boolean>> isPolling = null;
    
    public NativeLiveDataEventBus() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.IamPortResponse>> getImpResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<java.lang.String>> getChaiUri() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.Payment>> getWebViewActivityPayment() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.IamPortApprove>> getChaiApprove() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<java.lang.Boolean>> isPolling() {
        return null;
    }
}