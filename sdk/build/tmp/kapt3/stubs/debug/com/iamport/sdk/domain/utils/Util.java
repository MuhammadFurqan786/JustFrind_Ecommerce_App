package com.iamport.sdk.domain.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002/0B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u001b\u0010!\u001a\u00020\"\"\u0010\b\u0000\u0010#\u0018\u0001*\b\u0012\u0004\u0012\u0002H#0$H\u0086\bJ\u001c\u0010%\u001a\u00020&2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\bJ3\u0010(\u001a\u00020\"\"\u0004\b\u0000\u0010#*\b\u0012\u0004\u0012\u0002H#0)2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u0002H#0-H\u0000\u00a2\u0006\u0002\b.R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/iamport/sdk/domain/utils/Util;", "", "()V", "defaultPayMethod", "", "Lcom/iamport/sdk/data/sdk/PayMethod;", "convertPayMethodNames", "", "", "pg", "Lcom/iamport/sdk/data/sdk/PG;", "getMappingPayMethod", "getMarketId", "pkg", "getOrEmpty", "value", "getOrZeroString", "getQueryStringToImpResponse", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "uri", "Landroid/net/Uri;", "gson", "Lcom/google/gson/Gson;", "getRedirectUrl", "str", "getUserCode", "position", "", "getUserCodeList", "isInternetAvailable", "", "context", "Landroid/content/Context;", "printAllValues", "", "T", "", "versionCode", "", "name", "observeAlways", "Landroidx/lifecycle/LiveData;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "observeAlways$sdk_debug", "DevUserCode", "SampleUserCode", "sdk_debug"})
public final class Util {
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.domain.utils.Util INSTANCE = null;
    private static final java.util.Set<com.iamport.sdk.data.sdk.PayMethod> defaultPayMethod = null;
    
    private Util() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getUserCodeList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserCode(int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> convertPayMethodNames(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.PG pg) {
        return null;
    }
    
    /**
     * pg사별 지원하는 결제수단
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<com.iamport.sdk.data.sdk.PayMethod> getMappingPayMethod(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.PG pg) {
        return null;
    }
    
    /**
     * uri 쿼리 파싱해서 IamPortResponse 가져오기
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.KITKAT)
    public final com.iamport.sdk.data.sdk.IamPortResponse getQueryStringToImpResponse(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
    
    /**
     * 플레이 스토어 이동 주소
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMarketId(@org.jetbrains.annotations.NotNull()
    java.lang.String pkg) {
        return null;
    }
    
    @kotlin.Suppress(names = {"DEPRECATION"})
    public final boolean isInternetAvailable(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrZeroString(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrEmpty(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
        return null;
    }
    
    public final <T extends java.lang.Object>void observeAlways$sdk_debug(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<T> $this$observeAlways, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner lifecycleOwner, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Observer<T> observer) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Number versionCode(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRedirectUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\u000b"}, d2 = {"Lcom/iamport/sdk/domain/utils/Util$DevUserCode;", "", "desc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "imp96304110", "imp55870459", "imp60029475", "Companion", "sdk_debug"})
    public static enum DevUserCode {
        /*public static final*/ imp96304110 /* = new imp96304110(null) */,
        /*public static final*/ imp55870459 /* = new imp55870459(null) */,
        /*public static final*/ imp60029475 /* = new imp60029475(null) */;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String desc = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.iamport.sdk.domain.utils.Util.DevUserCode.Companion Companion = null;
        
        DevUserCode(java.lang.String desc) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDesc() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/iamport/sdk/domain/utils/Util$DevUserCode$Companion;", "", "()V", "getUserCodes", "", "", "sdk_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.List<java.lang.String> getUserCodes() {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/iamport/sdk/domain/utils/Util$SampleUserCode;", "", "desc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "imp19424728", "iamport", "imp10391932", "imp09350031", "imp60029475", "imp41073887", "imp49241793", "imp37739582", "imp87936124", "imp02690184", "imp42284830", "imp46277621", "Companion", "sdk_debug"})
    public static enum SampleUserCode {
        /*public static final*/ imp19424728 /* = new imp19424728(null) */,
        /*public static final*/ iamport /* = new iamport(null) */,
        /*public static final*/ imp10391932 /* = new imp10391932(null) */,
        /*public static final*/ imp09350031 /* = new imp09350031(null) */,
        /*public static final*/ imp60029475 /* = new imp60029475(null) */,
        /*public static final*/ imp41073887 /* = new imp41073887(null) */,
        /*public static final*/ imp49241793 /* = new imp49241793(null) */,
        /*public static final*/ imp37739582 /* = new imp37739582(null) */,
        /*public static final*/ imp87936124 /* = new imp87936124(null) */,
        /*public static final*/ imp02690184 /* = new imp02690184(null) */,
        /*public static final*/ imp42284830 /* = new imp42284830(null) */,
        /*public static final*/ imp46277621 /* = new imp46277621(null) */;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String desc = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.iamport.sdk.domain.utils.Util.SampleUserCode.Companion Companion = null;
        
        SampleUserCode(java.lang.String desc) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDesc() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/iamport/sdk/domain/utils/Util$SampleUserCode$Companion;", "", "()V", "getUserCodes", "", "", "sdk_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.List<java.lang.String> getUserCodes() {
                return null;
            }
        }
    }
}