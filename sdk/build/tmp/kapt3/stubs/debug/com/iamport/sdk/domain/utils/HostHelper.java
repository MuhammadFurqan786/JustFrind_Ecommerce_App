package com.iamport.sdk.domain.utils;

import java.lang.System;

/**
 * SDK 실행 호스트 헬퍼 클래스
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/iamport/sdk/domain/utils/HostHelper;", "", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroidx/activity/ComponentActivity;", "fragmentRef", "Landroidx/fragment/app/Fragment;", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "mode", "Lcom/iamport/sdk/domain/utils/MODE;", "getMode", "()Lcom/iamport/sdk/domain/utils/MODE;", "getActivityRef", "getFragmentRef", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "sdk_debug"})
public final class HostHelper {
    private final java.lang.ref.WeakReference<androidx.activity.ComponentActivity> activityRef = null;
    private final java.lang.ref.WeakReference<androidx.fragment.app.Fragment> fragmentRef = null;
    @org.jetbrains.annotations.NotNull()
    private final com.iamport.sdk.domain.utils.MODE mode = null;
    
    public HostHelper() {
        super();
    }
    
    public HostHelper(@org.jetbrains.annotations.Nullable()
    java.lang.ref.WeakReference<androidx.activity.ComponentActivity> activityRef, @org.jetbrains.annotations.Nullable()
    java.lang.ref.WeakReference<androidx.fragment.app.Fragment> fragmentRef) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.domain.utils.MODE getMode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.activity.ComponentActivity getActivityRef() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.fragment.app.Fragment getFragmentRef() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.ViewModelStoreOwner getViewModelStoreOwner() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LifecycleOwner getLifecycleOwner() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.Lifecycle getLifecycle() {
        return null;
    }
}