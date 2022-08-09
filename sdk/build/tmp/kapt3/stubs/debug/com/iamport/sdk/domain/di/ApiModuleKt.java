package com.iamport.sdk.domain.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\u0012\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\u00a8\u0006\u0015"}, d2 = {"apiModule", "Lorg/koin/core/module/Module;", "getApiModule", "()Lorg/koin/core/module/Module;", "httpClientModule", "getHttpClientModule", "provideChaiApi", "Lcom/iamport/sdk/data/remote/ChaiApi;", "url", "", "gson", "Lcom/google/gson/Gson;", "client", "Lokhttp3/OkHttpClient;", "provideIamportApi", "Lcom/iamport/sdk/data/remote/IamportApi;", "provideNiceApi", "Lcom/iamport/sdk/data/remote/NiceApi;", "provideOkHttpClient", "context", "Landroid/content/Context;", "sdk_debug"})
public final class ApiModuleKt {
    @org.jetbrains.annotations.NotNull()
    private static final org.koin.core.module.Module httpClientModule = null;
    @org.jetbrains.annotations.NotNull()
    private static final org.koin.core.module.Module apiModule = null;
    
    @org.jetbrains.annotations.Nullable()
    public static final okhttp3.OkHttpClient provideOkHttpClient(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.data.remote.IamportApi provideIamportApi(@org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson, @org.jetbrains.annotations.Nullable()
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.data.remote.NiceApi provideNiceApi(@org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson, @org.jetbrains.annotations.Nullable()
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.data.remote.ChaiApi provideChaiApi(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson, @org.jetbrains.annotations.Nullable()
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final org.koin.core.module.Module getHttpClientModule() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final org.koin.core.module.Module getApiModule() {
        return null;
    }
}