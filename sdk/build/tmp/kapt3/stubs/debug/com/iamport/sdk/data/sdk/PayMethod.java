package com.iamport.sdk.data.sdk;

import java.lang.System;

/**
 * https://docs.iamport.kr/tech/imp?lang=ko#param
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0087\u0001\u0018\u0000 \'2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\'B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u00d6\u0001J\u0006\u0010\n\u001a\u00020\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&\u00a8\u0006("}, d2 = {"Lcom/iamport/sdk/data/sdk/PayMethod;", "", "Landroid/os/Parcelable;", "korName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKorName", "()Ljava/lang/String;", "describeContents", "", "getPayMethodName", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "card", "trans", "vbank", "phone", "samsung", "kpay", "kakaopay", "payco", "lpay", "ssgpay", "tosspay", "cultureland", "smartculture", "happymoney", "booknlife", "point", "unionpay", "alipay", "tenpay", "wechat", "molpay", "paysbuy", "naverpay", "Companion", "sdk_debug"})
public enum PayMethod implements android.os.Parcelable {
    /*public static final*/ card /* = new card(null) */,
    /*public static final*/ trans /* = new trans(null) */,
    /*public static final*/ vbank /* = new vbank(null) */,
    /*public static final*/ phone /* = new phone(null) */,
    /*public static final*/ samsung /* = new samsung(null) */,
    /*public static final*/ kpay /* = new kpay(null) */,
    /*public static final*/ kakaopay /* = new kakaopay(null) */,
    /*public static final*/ payco /* = new payco(null) */,
    /*public static final*/ lpay /* = new lpay(null) */,
    /*public static final*/ ssgpay /* = new ssgpay(null) */,
    /*public static final*/ tosspay /* = new tosspay(null) */,
    /*public static final*/ cultureland /* = new cultureland(null) */,
    /*public static final*/ smartculture /* = new smartculture(null) */,
    /*public static final*/ happymoney /* = new happymoney(null) */,
    /*public static final*/ booknlife /* = new booknlife(null) */,
    /*public static final*/ point /* = new point(null) */,
    /*public static final*/ unionpay /* = new unionpay(null) */,
    /*public static final*/ alipay /* = new alipay(null) */,
    /*public static final*/ tenpay /* = new tenpay(null) */,
    /*public static final*/ wechat /* = new wechat(null) */,
    /*public static final*/ molpay /* = new molpay(null) */,
    /*public static final*/ paysbuy /* = new paysbuy(null) */,
    /*public static final*/ naverpay /* = new naverpay(null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String korName = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.data.sdk.PayMethod.Companion Companion = null;
    public static final android.os.Parcelable.Creator<com.iamport.sdk.data.sdk.PayMethod> CREATOR = null;
    
    PayMethod(java.lang.String korName) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKorName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPayMethodName() {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.iamport.sdk.data.sdk.PayMethod> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.iamport.sdk.data.sdk.PayMethod createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.iamport.sdk.data.sdk.PayMethod[] newArray(int size) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/iamport/sdk/data/sdk/PayMethod$Companion;", "", "()V", "from", "Lcom/iamport/sdk/data/sdk/PayMethod;", "payMethodString", "", "sdk_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.iamport.sdk.data.sdk.PayMethod from(@org.jetbrains.annotations.NotNull()
        java.lang.String payMethodString) {
            return null;
        }
    }
}