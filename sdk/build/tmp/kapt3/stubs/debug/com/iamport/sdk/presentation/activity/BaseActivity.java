package com.iamport.sdk.presentation.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0011\b\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\u001f\u001a\u00020 H&J\u0012\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020 H\u0014J\t\u0010%\u001a\u00020 H\u0096\u0001J\b\u0010&\u001a\u00020 H\u0002R\u0012\u0010\n\u001a\u00020\u000bX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001c\u001a\u00028\u0001X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\'"}, d2 = {"Lcom/iamport/sdk/presentation/activity/BaseActivity;", "T", "Landroidx/databinding/ViewDataBinding;", "R", "Lcom/iamport/sdk/presentation/viewmodel/BaseViewModel;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/iamport/sdk/presentation/activity/BaseMain;", "Lcom/iamport/sdk/domain/utils/BaseCoroutineScope;", "scope", "(Lcom/iamport/sdk/domain/utils/BaseCoroutineScope;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "layoutResourceId", "", "getLayoutResourceId", "()I", "viewDataBinding", "getViewDataBinding", "()Landroidx/databinding/ViewDataBinding;", "setViewDataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "viewModel", "getViewModel", "()Lcom/iamport/sdk/presentation/viewmodel/BaseViewModel;", "initStart", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "releaseCoroutine", "snackbarObserving", "sdk_debug"})
public abstract class BaseActivity<T extends androidx.databinding.ViewDataBinding, R extends com.iamport.sdk.presentation.viewmodel.BaseViewModel> extends androidx.appcompat.app.AppCompatActivity implements com.iamport.sdk.presentation.activity.BaseMain, com.iamport.sdk.domain.utils.BaseCoroutineScope {
    public T viewDataBinding;
    
    @kotlin.jvm.JvmOverloads()
    public BaseActivity() {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public BaseActivity(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.domain.utils.BaseCoroutineScope scope) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final T getViewDataBinding() {
        return null;
    }
    
    public final void setViewDataBinding(@org.jetbrains.annotations.NotNull()
    T p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract R getViewModel();
    
    public abstract int getLayoutResourceId();
    
    public abstract void initStart();
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void snackbarObserving() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.Job getJob() {
        return null;
    }
    
    /**
     * Coroutine job cancel
     */
    @java.lang.Override()
    public void releaseCoroutine() {
    }
    
    /**
     * 웹뷰 기본 세팅
     */
    public void settingsWebView(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView) {
    }
}