package com.iamport.sdk.presentation.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\r0\u0011J(\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0004\u0012\u00020\r0\u0011J:\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2*\u0010\u0010\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n0\u0005\u0012\u0004\u0012\u00020\r0\u0011J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\bJ\u001e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000bR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\t\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/iamport/sdk/presentation/viewmodel/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "snackbarMessage", "Landroidx/lifecycle/MutableLiveData;", "Lcom/iamport/sdk/domain/utils/Event;", "", "snackbarMessageString", "", "snackbarMessageStringButton", "Lkotlin/Triple;", "Landroid/view/View$OnClickListener;", "observeSnackbarMessage", "", "lifeCycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "ob", "Lkotlin/Function1;", "observeSnackbarMessageStr", "observeSnackbarStrBtn", "showSnackbar", "stringResourceId", "str", "showSnackbarBtn", "btnName", "listener", "sdk_debug"})
public class BaseViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<java.lang.Integer>> snackbarMessage = null;
    private final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<java.lang.String>> snackbarMessageString = null;
    private final androidx.lifecycle.MutableLiveData<com.iamport.sdk.domain.utils.Event<kotlin.Triple<java.lang.String, java.lang.String, android.view.View.OnClickListener>>> snackbarMessageStringButton = null;
    
    public BaseViewModel() {
        super();
    }
    
    public final void showSnackbar(int stringResourceId) {
    }
    
    public final void showSnackbar(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
    }
    
    public final void showSnackbarBtn(@org.jetbrains.annotations.NotNull()
    java.lang.String str, @org.jetbrains.annotations.NotNull()
    java.lang.String btnName, @org.jetbrains.annotations.NotNull()
    android.view.View.OnClickListener listener) {
    }
    
    public final void observeSnackbarMessage(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner lifeCycleOwner, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.domain.utils.Event<java.lang.Integer>, kotlin.Unit> ob) {
    }
    
    public final void observeSnackbarMessageStr(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner lifeCycleOwner, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.domain.utils.Event<java.lang.String>, kotlin.Unit> ob) {
    }
    
    public final void observeSnackbarStrBtn(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner lifeCycleOwner, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.iamport.sdk.domain.utils.Event<? extends kotlin.Triple<java.lang.String, java.lang.String, ? extends android.view.View.OnClickListener>>, kotlin.Unit> ob) {
    }
}