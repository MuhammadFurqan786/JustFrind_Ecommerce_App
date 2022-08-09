package com.iamport.sdk.presentation.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001;B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0 J\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0!0 J\u0006\u0010%\u001a\u00020&J\u000e\u0010\'\u001a\u00020&2\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020&J\u0006\u0010+\u001a\u00020&J\u0014\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010-0!0 J\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0!0 J\u0018\u0010/\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u00100\u001a\u00020)J\b\u00101\u001a\u00020&H\u0014J\u0016\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\"J\u0016\u00109\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u0012\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180!0 R\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u00020\u00148BX\u0082\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/iamport/sdk/presentation/viewmodel/MainViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lcom/iamport/sdk/domain/di/IamportKoinComponent;", "bus", "Lcom/iamport/sdk/domain/utils/NativeLiveDataEventBus;", "repository", "Lcom/iamport/sdk/domain/repository/StrategyRepository;", "application", "Landroid/app/Application;", "(Lcom/iamport/sdk/domain/utils/NativeLiveDataEventBus;Lcom/iamport/sdk/domain/repository/StrategyRepository;Landroid/app/Application;)V", "app", "getApp", "()Landroid/app/Application;", "approved", "Lcom/iamport/sdk/presentation/viewmodel/MainViewModel$Status;", "getApproved", "()Lcom/iamport/sdk/presentation/viewmodel/MainViewModel$Status;", "setApproved", "(Lcom/iamport/sdk/presentation/viewmodel/MainViewModel$Status;)V", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob", "()Lkotlinx/coroutines/CompletableJob;", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "getPayment", "()Lcom/iamport/sdk/data/sdk/Payment;", "setPayment", "(Lcom/iamport/sdk/data/sdk/Payment;)V", "screenBrFilter", "Landroid/content/IntentFilter;", "chaiApprove", "Landroidx/lifecycle/LiveData;", "Lcom/iamport/sdk/domain/utils/Event;", "Lcom/iamport/sdk/data/sdk/IamPortApprove;", "chaiUri", "", "clearData", "", "controlForegroundService", "it", "", "failSdkFinish", "forceChaiStatusCheck", "impResponse", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "isPolling", "judgePayment", "ignoreNative", "onCleared", "registerIamportReceiver", "iamportReceiver", "Lcom/iamport/sdk/domain/core/IamportReceiver;", "screenBrReceiver", "Landroid/content/BroadcastReceiver;", "requestApprovePayments", "approve", "unregisterIamportReceiver", "webViewActivityPayment", "Status", "sdk_debug"})
public final class MainViewModel extends androidx.lifecycle.AndroidViewModel implements com.iamport.sdk.domain.di.IamportKoinComponent {
    private final com.iamport.sdk.domain.utils.NativeLiveDataEventBus bus = null;
    private final com.iamport.sdk.domain.repository.StrategyRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application app = null;
    @org.jetbrains.annotations.Nullable()
    private com.iamport.sdk.data.sdk.Payment payment;
    @org.jetbrains.annotations.NotNull()
    private com.iamport.sdk.presentation.viewmodel.MainViewModel.Status approved;
    private final android.content.IntentFilter screenBrFilter = null;
    private kotlinx.coroutines.CompletableJob job;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.domain.utils.NativeLiveDataEventBus bus, @org.jetbrains.annotations.NotNull()
    com.iamport.sdk.domain.repository.StrategyRepository repository, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getApp() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.Payment getPayment() {
        return null;
    }
    
    public final void setPayment(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.Payment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.presentation.viewmodel.MainViewModel.Status getApproved() {
        return null;
    }
    
    public final void setApproved(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.presentation.viewmodel.MainViewModel.Status p0) {
    }
    
    private final kotlinx.coroutines.CompletableJob getJob() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void failSdkFinish() {
    }
    
    /**
     * 결제 데이터
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.Payment>> webViewActivityPayment() {
        return null;
    }
    
    /**
     * 차이앱 열기
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<java.lang.String>> chaiUri() {
        return null;
    }
    
    /**
     * 차이 결제 상태 approve
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.IamPortApprove>> chaiApprove() {
        return null;
    }
    
    /**
     * 결제 결과 콜백 및 종료
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<com.iamport.sdk.data.sdk.IamPortResponse>> impResponse() {
        return null;
    }
    
    /**
     * 외부 노출용 폴링여부
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.iamport.sdk.domain.utils.Event<java.lang.Boolean>> isPolling() {
        return null;
    }
    
    /**
     * 결제 요청
     */
    public final void judgePayment(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, boolean ignoreNative) {
    }
    
    /**
     * 차이 데이터 클리어
     */
    public final void clearData() {
    }
    
    /**
     * 차이 최종 결제 요청
     */
    public final void requestApprovePayments(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.IamPortApprove approve) {
    }
    
    public final void forceChaiStatusCheck() {
    }
    
    public final void registerIamportReceiver(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.domain.core.IamportReceiver iamportReceiver, @org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver screenBrReceiver) {
    }
    
    public final void unregisterIamportReceiver(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.domain.core.IamportReceiver iamportReceiver, @org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver screenBrReceiver) {
    }
    
    public final void controlForegroundService(boolean it) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.koin.core.Koin getKoin() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/iamport/sdk/presentation/viewmodel/MainViewModel$Status;", "", "()V", "None", "Waiting", "Lcom/iamport/sdk/presentation/viewmodel/MainViewModel$Status$Waiting;", "Lcom/iamport/sdk/presentation/viewmodel/MainViewModel$Status$None;", "sdk_debug"})
    public static abstract class Status {
        
        private Status() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/iamport/sdk/presentation/viewmodel/MainViewModel$Status$Waiting;", "Lcom/iamport/sdk/presentation/viewmodel/MainViewModel$Status;", "()V", "sdk_debug"})
        public static final class Waiting extends com.iamport.sdk.presentation.viewmodel.MainViewModel.Status {
            @org.jetbrains.annotations.NotNull()
            public static final com.iamport.sdk.presentation.viewmodel.MainViewModel.Status.Waiting INSTANCE = null;
            
            private Waiting() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/iamport/sdk/presentation/viewmodel/MainViewModel$Status$None;", "Lcom/iamport/sdk/presentation/viewmodel/MainViewModel$Status;", "()V", "sdk_debug"})
        public static final class None extends com.iamport.sdk.presentation.viewmodel.MainViewModel.Status {
            @org.jetbrains.annotations.NotNull()
            public static final com.iamport.sdk.presentation.viewmodel.MainViewModel.Status.None INSTANCE = null;
            
            private None() {
                super();
            }
        }
    }
}