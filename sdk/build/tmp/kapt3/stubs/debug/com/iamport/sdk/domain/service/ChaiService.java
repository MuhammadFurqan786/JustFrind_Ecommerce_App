package com.iamport.sdk.domain.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/iamport/sdk/domain/service/ChaiService;", "Landroid/app/Service;", "()V", "channelId", "", "channelRegister", "", "onBind", "Landroid/os/IBinder;", "p0", "Landroid/content/Intent;", "onCreate", "onStartCommand", "", "intent", "flags", "startId", "startNotification", "Companion", "sdk_debug"})
public class ChaiService extends android.app.Service {
    private final java.lang.String channelId = "Iamport Pamyent SDK";
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.domain.service.ChaiService.Companion Companion = null;
    private static boolean enableForegroundService = true;
    private static boolean enableForegroundServiceStopButton = false;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String START_SERVICE = "start-chai-service";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STOP_SERVICE = "stop-chai-service";
    
    public ChaiService() {
        super();
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent p0) {
        return null;
    }
    
    private final void channelRegister() {
    }
    
    private final void startNotification() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/iamport/sdk/domain/service/ChaiService$Companion;", "", "()V", "START_SERVICE", "", "STOP_SERVICE", "enableForegroundService", "", "getEnableForegroundService", "()Z", "setEnableForegroundService", "(Z)V", "enableForegroundServiceStopButton", "getEnableForegroundServiceStopButton", "setEnableForegroundServiceStopButton", "sdk_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean getEnableForegroundService() {
            return false;
        }
        
        public final void setEnableForegroundService(boolean p0) {
        }
        
        public final boolean getEnableForegroundServiceStopButton() {
            return false;
        }
        
        public final void setEnableForegroundServiceStopButton(boolean p0) {
        }
    }
}