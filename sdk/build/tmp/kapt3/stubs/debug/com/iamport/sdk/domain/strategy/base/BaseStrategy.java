package com.iamport.sdk.domain.strategy.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J7\u0010\u001c\u001a\u0004\u0018\u00010\u0016\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001d0\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00160 H\u0086\u0004\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"R\u001b\u0010\u0004\u001a\u00020\u00058DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/iamport/sdk/domain/strategy/base/BaseStrategy;", "Lcom/iamport/sdk/domain/strategy/base/IStrategy;", "Lcom/iamport/sdk/domain/di/IamportKoinComponent;", "()V", "bus", "Lcom/iamport/sdk/domain/utils/NativeLiveDataEventBus;", "getBus", "()Lcom/iamport/sdk/domain/utils/NativeLiveDataEventBus;", "bus$delegate", "Lkotlin/Lazy;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "getPayment", "()Lcom/iamport/sdk/data/sdk/Payment;", "setPayment", "(Lcom/iamport/sdk/data/sdk/Payment;)V", "doWork", "", "(Lcom/iamport/sdk/data/sdk/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "init", "sdkFinish", "response", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "catchNotCancelled", "T", "Lkotlin/Result;", "block", "Lkotlin/Function1;", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "sdk_debug"})
public abstract class BaseStrategy implements com.iamport.sdk.domain.strategy.base.IStrategy, com.iamport.sdk.domain.di.IamportKoinComponent {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy gson$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy bus$delegate = null;
    public com.iamport.sdk.data.sdk.Payment payment;
    
    public BaseStrategy() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.google.gson.Gson getGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.iamport.sdk.domain.utils.NativeLiveDataEventBus getBus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.Payment getPayment() {
        return null;
    }
    
    public final void setPayment(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment p0) {
    }
    
    @java.lang.Override()
    public void init() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * SDK 종료
     */
    @java.lang.Override()
    public void sdkFinish(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortResponse response) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>kotlin.Unit catchNotCancelled(@org.jetbrains.annotations.NotNull()
    java.lang.Object $this$catchNotCancelled, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> block) {
        return null;
    }
    
    public void failureFinish(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.chai.response.PrepareData prepareData, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public void failureFinish(@org.jetbrains.annotations.NotNull()
    java.lang.String merchantUid, @org.jetbrains.annotations.NotNull()
    java.lang.String impUid, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.koin.core.Koin getKoin() {
        return null;
    }
    
    public void successFinish(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.chai.response.PrepareData prepareData, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public void successFinish(@org.jetbrains.annotations.NotNull()
    java.lang.String merchantUid, @org.jetbrains.annotations.NotNull()
    java.lang.String impUid, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
}