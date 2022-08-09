package com.iamport.sdk.domain.strategy.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J$\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/iamport/sdk/domain/strategy/base/IStrategy;", "", "doWork", "", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "(Lcom/iamport/sdk/data/sdk/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "failureFinish", "prepareData", "Lcom/iamport/sdk/data/chai/response/PrepareData;", "msg", "", "merchantUid", "impUid", "init", "sdkFinish", "response", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "successFinish", "sdk_debug"})
public abstract interface IStrategy {
    
    public abstract void init();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    public abstract void sdkFinish(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortResponse response);
    
    public abstract void successFinish(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.chai.response.PrepareData prepareData, @org.jetbrains.annotations.NotNull()
    java.lang.String msg);
    
    public abstract void failureFinish(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.chai.response.PrepareData prepareData, @org.jetbrains.annotations.NotNull()
    java.lang.String msg);
    
    public abstract void successFinish(@org.jetbrains.annotations.NotNull()
    java.lang.String merchantUid, @org.jetbrains.annotations.NotNull()
    java.lang.String impUid, @org.jetbrains.annotations.NotNull()
    java.lang.String msg);
    
    public abstract void failureFinish(@org.jetbrains.annotations.NotNull()
    java.lang.String merchantUid, @org.jetbrains.annotations.NotNull()
    java.lang.String impUid, @org.jetbrains.annotations.NotNull()
    java.lang.String msg);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
        com.iamport.sdk.domain.strategy.base.IStrategy $this, @org.jetbrains.annotations.NotNull()
        com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
            return null;
        }
        
        public static void successFinish(@org.jetbrains.annotations.NotNull()
        com.iamport.sdk.domain.strategy.base.IStrategy $this, @org.jetbrains.annotations.NotNull()
        com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
        com.iamport.sdk.data.chai.response.PrepareData prepareData, @org.jetbrains.annotations.NotNull()
        java.lang.String msg) {
        }
        
        public static void failureFinish(@org.jetbrains.annotations.NotNull()
        com.iamport.sdk.domain.strategy.base.IStrategy $this, @org.jetbrains.annotations.NotNull()
        com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.Nullable()
        com.iamport.sdk.data.chai.response.PrepareData prepareData, @org.jetbrains.annotations.NotNull()
        java.lang.String msg) {
        }
        
        public static void successFinish(@org.jetbrains.annotations.NotNull()
        com.iamport.sdk.domain.strategy.base.IStrategy $this, @org.jetbrains.annotations.NotNull()
        java.lang.String merchantUid, @org.jetbrains.annotations.NotNull()
        java.lang.String impUid, @org.jetbrains.annotations.NotNull()
        java.lang.String msg) {
        }
        
        public static void failureFinish(@org.jetbrains.annotations.NotNull()
        com.iamport.sdk.domain.strategy.base.IStrategy $this, @org.jetbrains.annotations.NotNull()
        java.lang.String merchantUid, @org.jetbrains.annotations.NotNull()
        java.lang.String impUid, @org.jetbrains.annotations.NotNull()
        java.lang.String msg) {
        }
    }
}