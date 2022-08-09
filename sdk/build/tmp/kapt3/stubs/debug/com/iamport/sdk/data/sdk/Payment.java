package com.iamport.sdk.data.sdk;

import java.lang.System;

@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \'2\u00020\u0001:\u0002\'(B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u00c6\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020\u0017H\u00d6\u0001J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0017H\u00d6\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006)"}, d2 = {"Lcom/iamport/sdk/data/sdk/Payment;", "Landroid/os/Parcelable;", "userCode", "", "tierCode", "iamPortRequest", "Lcom/iamport/sdk/data/sdk/IamPortRequest;", "iamPortCertification", "Lcom/iamport/sdk/data/sdk/IamPortCertification;", "(Ljava/lang/String;Ljava/lang/String;Lcom/iamport/sdk/data/sdk/IamPortRequest;Lcom/iamport/sdk/data/sdk/IamPortCertification;)V", "getIamPortCertification", "()Lcom/iamport/sdk/data/sdk/IamPortCertification;", "getIamPortRequest", "()Lcom/iamport/sdk/data/sdk/IamPortRequest;", "getTierCode", "()Ljava/lang/String;", "getUserCode", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "getCustomerUid", "getMerchantUid", "getStatus", "Lcom/iamport/sdk/data/sdk/Payment$STATUS;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "STATUS", "sdk_debug"})
public final class Payment implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userCode = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String tierCode = null;
    @org.jetbrains.annotations.Nullable()
    private final com.iamport.sdk.data.sdk.IamPortRequest iamPortRequest = null;
    @org.jetbrains.annotations.Nullable()
    private final com.iamport.sdk.data.sdk.IamPortCertification iamPortCertification = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.data.sdk.Payment.Companion Companion = null;
    public static final android.os.Parcelable.Creator<com.iamport.sdk.data.sdk.Payment> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.Payment copy(@org.jetbrains.annotations.NotNull()
    java.lang.String userCode, @org.jetbrains.annotations.Nullable()
    java.lang.String tierCode, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortRequest iamPortRequest, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortCertification iamPortCertification) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Payment(@org.jetbrains.annotations.NotNull()
    java.lang.String userCode, @org.jetbrains.annotations.Nullable()
    java.lang.String tierCode, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortRequest iamPortRequest, @org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortCertification iamPortCertification) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserCode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTierCode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.IamPortRequest component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.IamPortRequest getIamPortRequest() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.IamPortCertification component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.iamport.sdk.data.sdk.IamPortCertification getIamPortCertification() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iamport.sdk.data.sdk.Payment.STATUS getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMerchantUid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCustomerUid() {
        return null;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.iamport.sdk.data.sdk.Payment> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.iamport.sdk.data.sdk.Payment createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.iamport.sdk.data.sdk.Payment[] newArray(int size) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/iamport/sdk/data/sdk/Payment$STATUS;", "", "(Ljava/lang/String;I)V", "PAYMENT", "CERT", "ERROR", "sdk_debug"})
    public static enum STATUS {
        /*public static final*/ PAYMENT /* = new PAYMENT() */,
        /*public static final*/ CERT /* = new CERT() */,
        /*public static final*/ ERROR /* = new ERROR() */;
        
        STATUS() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/iamport/sdk/data/sdk/Payment$Companion;", "", "()V", "validator", "Lkotlin/Pair;", "", "", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "sdk_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.Pair<java.lang.Boolean, java.lang.String> validator(@org.jetbrains.annotations.NotNull()
        com.iamport.sdk.data.sdk.Payment payment) {
            return null;
        }
    }
}