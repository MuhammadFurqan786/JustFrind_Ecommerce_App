package com.iamport.sdk.domain.core;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00072\u001e\u0010\b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\n\u0012\u0004\u0012\u00020\u000b0\tJ\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\n\u0012\u0004\u0012\u00020\u000b0\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/iamport/sdk/domain/core/IamportLifecycleObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "registry", "Landroidx/activity/result/ActivityResultRegistry;", "(Landroidx/activity/result/ActivityResultRegistry;)V", "bankPayLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "resultCallback", "Lkotlin/Function1;", "Lkotlin/Pair;", "", "getResultCallback", "()Lkotlin/jvm/functions/Function1;", "setResultCallback", "(Lkotlin/jvm/functions/Function1;)V", "bankPayLaunch", "it", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", "sdk_debug"})
public final class IamportLifecycleObserver implements androidx.lifecycle.DefaultLifecycleObserver {
    private final androidx.activity.result.ActivityResultRegistry registry = null;
    private androidx.activity.result.ActivityResultLauncher<java.lang.String> bankPayLauncher;
    public kotlin.jvm.functions.Function1<? super kotlin.Pair<java.lang.String, java.lang.String>, kotlin.Unit> resultCallback;
    
    public IamportLifecycleObserver(@org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultRegistry registry) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<kotlin.Pair<java.lang.String, java.lang.String>, kotlin.Unit> getResultCallback() {
        return null;
    }
    
    public final void setResultCallback(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.Pair<java.lang.String, java.lang.String>, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner) {
    }
    
    public final void bankPayLaunch(@org.jetbrains.annotations.NotNull()
    java.lang.String it, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.Pair<java.lang.String, java.lang.String>, kotlin.Unit> resultCallback) {
    }
}