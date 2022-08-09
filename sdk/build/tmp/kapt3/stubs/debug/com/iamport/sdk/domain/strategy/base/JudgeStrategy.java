package com.iamport.sdk.domain.strategy.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0015j\b\u0012\u0004\u0012\u00020\u0013`\u0016H\u0002J,\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J7\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/iamport/sdk/domain/strategy/base/JudgeStrategy;", "Lcom/iamport/sdk/domain/strategy/base/BaseStrategy;", "Lcom/iamport/sdk/domain/di/IamportKoinComponent;", "()V", "iamportApi", "Lcom/iamport/sdk/data/remote/IamportApi;", "getIamportApi", "()Lcom/iamport/sdk/data/remote/IamportApi;", "iamportApi$delegate", "Lkotlin/Lazy;", "ignoreNative", "", "apiGetUsers", "Lcom/iamport/sdk/data/remote/ResultWrapper;", "Lcom/iamport/sdk/data/chai/response/Users;", "userCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findDefaultUserData", "Lcom/iamport/sdk/data/chai/response/UserData;", "userDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPgTriple", "Lkotlin/Triple;", "Lcom/iamport/sdk/domain/strategy/base/JudgeStrategy$JudgeKinds;", "Lcom/iamport/sdk/data/sdk/Payment;", "user", "payment", "judge", "(Lcom/iamport/sdk/data/sdk/Payment;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replacePG", "pg", "Lcom/iamport/sdk/data/sdk/PG;", "JudgeKinds", "sdk_debug"})
public final class JudgeStrategy extends com.iamport.sdk.domain.strategy.base.BaseStrategy implements com.iamport.sdk.domain.di.IamportKoinComponent {
    private final kotlin.Lazy iamportApi$delegate = null;
    private boolean ignoreNative = false;
    
    public JudgeStrategy() {
        super();
    }
    
    private final com.iamport.sdk.data.remote.IamportApi getIamportApi() {
        return null;
    }
    
    private final java.lang.Object apiGetUsers(java.lang.String userCode, kotlin.coroutines.Continuation<? super com.iamport.sdk.data.remote.ResultWrapper<com.iamport.sdk.data.chai.response.Users>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object judge(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, boolean ignoreNative, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Triple<? extends com.iamport.sdk.domain.strategy.base.JudgeStrategy.JudgeKinds, com.iamport.sdk.data.chai.response.UserData, com.iamport.sdk.data.sdk.Payment>> continuation) {
        return null;
    }
    
    private final com.iamport.sdk.data.chai.response.UserData findDefaultUserData(java.util.ArrayList<com.iamport.sdk.data.chai.response.UserData> userDataList) {
        return null;
    }
    
    /**
     * pg 정보 값 가져옴 first : 타입, second : pg유저, third : 결제 요청 데이터
     */
    private final kotlin.Triple<com.iamport.sdk.domain.strategy.base.JudgeStrategy.JudgeKinds, com.iamport.sdk.data.chai.response.UserData, com.iamport.sdk.data.sdk.Payment> getPgTriple(com.iamport.sdk.data.chai.response.UserData user, com.iamport.sdk.data.sdk.Payment payment) {
        return null;
    }
    
    /**
     * payment PG 를 default PG 로 수정함
     */
    private final com.iamport.sdk.data.sdk.Payment replacePG(com.iamport.sdk.data.sdk.PG pg, com.iamport.sdk.data.sdk.Payment payment) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/iamport/sdk/domain/strategy/base/JudgeStrategy$JudgeKinds;", "", "(Ljava/lang/String;I)V", "CHAI", "WEB", "CERT", "ERROR", "sdk_debug"})
    public static enum JudgeKinds {
        /*public static final*/ CHAI /* = new CHAI() */,
        /*public static final*/ WEB /* = new WEB() */,
        /*public static final*/ CERT /* = new CERT() */,
        /*public static final*/ ERROR /* = new ERROR() */;
        
        JudgeKinds() {
        }
    }
}