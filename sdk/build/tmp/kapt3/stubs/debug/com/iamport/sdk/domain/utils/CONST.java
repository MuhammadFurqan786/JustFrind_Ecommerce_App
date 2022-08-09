package com.iamport.sdk.domain.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/iamport/sdk/domain/utils/CONST;", "", "()V", "ABOUT_BLANK_SCHEME", "", "APP_SCHME", "BROADCAST_FOREGROUND_SERVICE", "BROADCAST_FOREGROUND_SERVICE_STOP", "BUNDLE_PAYMENT", "CHAI_FINAL_PAYMENT_TIME_OUT_SEC", "", "CHAI_SERVICE_DEV_URL", "CHAI_SERVICE_STAGING_URL", "CHAI_SERVICE_URL", "CONTRACT_INPUT", "CONTRACT_OUTPUT", "EMPTY_STR", "ERR_PAYMENT_VALIDATOR_DANAL_VBANK", "ERR_PAYMENT_VALIDATOR_EXIMBAY", "ERR_PAYMENT_VALIDATOR_PHONE", "ERR_PAYMENT_VALIDATOR_VBANK", "HTTPS_SCHEME", "HTTP_SCHEME", "IAMPORT_DETECT_ADDRESS", "IAMPORT_DETECT_SCHEME", "IAMPORT_DETECT_URL", "IAMPORT_LOG", "IAMPORT_PROD_URL", "IAMPORT_TEST_URL", "IMP_CUSTOMER_UID", "IMP_UID", "IMP_USER_CODE", "KOIN_KEY", "NICE_PG_PROVIDER", "PASS_PAYMENT_VALIDATOR", "PAYMENT_FILE_URL", "PAYMENT_MOBILE_WEB_FILE_URL", "PAYMENT_PLAY_STORE_URL", "PAYMENT_WEBVIEW_JS_INTERFACE_NAME", "POLLING_DELAY", "PREFIX_ERR", "TIME_OUT", "TIME_OUT_MIN", "", "TRY_OUT_COUNT", "TRY_OUT_ONE_MIN", "USER_TYPE_CERTIFICATION", "USER_TYPE_PAYMENT", "sdk_debug"})
public final class CONST {
    @org.jetbrains.annotations.NotNull()
    public static final com.iamport.sdk.domain.utils.CONST INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KOIN_KEY = "iamport-koin-key";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String APP_SCHME = "iamport_android";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HTTP_SCHEME = "http";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HTTPS_SCHEME = "https";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ABOUT_BLANK_SCHEME = "about";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EMPTY_STR = "";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMP_USER_CODE = "impUserCode";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMP_UID = "impUid";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMP_CUSTOMER_UID = "impCustomerUid";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PAYMENT_WEBVIEW_JS_INTERFACE_NAME = "IAMPORT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NICE_PG_PROVIDER = "nice";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IAMPORT_DETECT_SCHEME = "http://";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IAMPORT_DETECT_ADDRESS = "detectchangingwebview/iamport/a";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IAMPORT_DETECT_URL = "http://detectchangingwebview/iamport/a";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IAMPORT_PROD_URL = "https://service.iamport.kr";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IAMPORT_TEST_URL = "http://1b8309246be2.ngrok.io";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHAI_SERVICE_URL = "https://api.chai.finance";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHAI_SERVICE_DEV_URL = "https://api-dev.chai.finance";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHAI_SERVICE_STAGING_URL = "https://api-staging.chai.finance";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PAYMENT_PLAY_STORE_URL = "market://details?id=";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PAYMENT_FILE_URL = "file:///android_asset/iamportcdn.html";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PAYMENT_MOBILE_WEB_FILE_URL = "file:///android_asset/mobileweb.html";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IAMPORT_LOG = "IAMPORT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CONTRACT_INPUT = "input";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CONTRACT_OUTPUT = "output";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_PAYMENT = "payment";
    public static final long POLLING_DELAY = 1000L;
    public static final int TIME_OUT_MIN = 5;
    public static final long TIME_OUT = 300000L;
    private static final long TRY_OUT_ONE_MIN = 60L;
    public static final long TRY_OUT_COUNT = 300L;
    public static final long CHAI_FINAL_PAYMENT_TIME_OUT_SEC = 6000L;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_FOREGROUND_SERVICE = "com.iamport.sdk.broadcast.fgservice";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_FOREGROUND_SERVICE_STOP = "com.iamport.sdk.broadcast.fgservice.stop";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String USER_TYPE_PAYMENT = "payment";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String USER_TYPE_CERTIFICATION = "certification";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PASS_PAYMENT_VALIDATOR = "\uc131\uacf5";
    private static final java.lang.String PREFIX_ERR = "[SDK ERR]";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERR_PAYMENT_VALIDATOR_VBANK = "[SDK ERR] \uac00\uc0c1\uacc4\uc88c \uacb0\uc81c\ub294 \ub9cc\ub8cc\uc77c\uc790(vbank_due) \ud56d\ubaa9 \ud544\uc218\uc785\ub2c8\ub2e4 (YYYYMMDDhhmm \ud615\uc2dd)";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERR_PAYMENT_VALIDATOR_PHONE = "[SDK ERR] \ud734\ub300\ud3f0 \uc18c\uc561\uacb0\uc81c\ub294 digital \ud56d\ubaa9 \ud544\uc218\uc785\ub2c8\ub2e4";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERR_PAYMENT_VALIDATOR_DANAL_VBANK = "[SDK ERR] \ub2e4\ub0a0 \uac00\uc0c1\uacc4\uc88c \uacb0\uc81c\ub294 \uc0ac\uc5c5\uc790 \ub4f1\ub85d\ubc88\ud638(biz_num) \ud56d\ubaa9 \ud544\uc218\uc785\ub2c8\ub2e4 (\uacc4\uc57d\ub41c \uc0ac\uc5c5\uc790\ub4f1\ub85d\ubc88\ud638 10\uc790\ub9ac)";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERR_PAYMENT_VALIDATOR_EXIMBAY = "[SDK ERR] eximbay \ub294 \ubaa8\ubc14\uc77c\uc571 \uacb0\uc81c\uc2dc IamPortRequest popup \ud30c\ub77c\ubbf8\ud130\ub97c false \ub85c \uc9c0\uc815\ud574\uc57c \uacb0\uc81c\ucc3d\uc774 \uc5f4\ub9bd\ub2c8\ub2e4.";
    
    private CONST() {
        super();
    }
}