package com.iamport.sdk.domain.strategy.chai;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JG\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!JO\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J/\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\u00182\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*J/\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00182\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*J\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00182\u0006\u00100\u001a\u000201H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J#\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u000208H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00109J\b\u0010:\u001a\u000204H\u0014J)\u0010;\u001a\u0002042\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010?J\u0019\u0010@\u001a\u0002042\u0006\u0010<\u001a\u00020=H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010AJ!\u0010@\u001a\u0002042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010<\u001a\u00020=H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010BJ\b\u0010C\u001a\u000204H\u0016J\u0019\u0010D\u001a\u0002042\u0006\u0010D\u001a\u000208H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010EJ\u0010\u0010F\u001a\u0002082\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010F\u001a\u0002082\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u000208H\u0002J\u0010\u0010J\u001a\u0002082\u0006\u0010G\u001a\u00020HH\u0002J\u0011\u0010K\u001a\u000204H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010LJ\u0019\u0010M\u001a\u0002042\u0006\u0010G\u001a\u00020\u0019H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010NJ\u0019\u0010O\u001a\u0002042\u0006\u0010G\u001a\u00020HH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010PJ\u0019\u0010Q\u001a\u0002042\u0006\u0010G\u001a\u00020HH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010PJ\u0019\u0010R\u001a\u0002042\u0006\u0010S\u001a\u00020/H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010TJC\u0010U\u001a\u0002042\u0006\u0010V\u001a\u00020\u00062\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u00107\u001a\u0002082\u0006\u00105\u001a\u000206H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010WJ\u0019\u0010X\u001a\u0002042\u0006\u0010G\u001a\u00020HH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010PJ\u0019\u0010Y\u001a\u0002042\u0006\u0010G\u001a\u00020HH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010PJ\u001f\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\\J\u0012\u0010]\u001a\u0002042\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J#\u0010`\u001a\u0002042\u0006\u00105\u001a\u0002062\b\b\u0002\u0010a\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006c"}, d2 = {"Lcom/iamport/sdk/domain/strategy/chai/ChaiStrategy;", "Lcom/iamport/sdk/domain/strategy/base/BaseStrategy;", "()V", "chaiApi", "Lcom/iamport/sdk/data/remote/ChaiApi;", "chaiId", "", "iamportApi", "Lcom/iamport/sdk/data/remote/IamportApi;", "getIamportApi", "()Lcom/iamport/sdk/data/remote/IamportApi;", "iamportApi$delegate", "Lkotlin/Lazy;", "job", "Lkotlinx/coroutines/CompletableJob;", "pollingId", "Ljava/util/concurrent/atomic/AtomicInteger;", "prepareData", "Lcom/iamport/sdk/data/chai/response/PrepareData;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "timeOutTime", "", "apiApprovePayment", "Lcom/iamport/sdk/data/remote/ResultWrapper;", "Lcom/iamport/sdk/data/chai/response/Approve;", "impUserCode", "impUid", "paymentId", "idempotencyKey", "status", "Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;", "native", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apiApprovePaymentSubscription", "impCustomerUid", "subscriptionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apiGetChaiStatus", "Lcom/iamport/sdk/data/chai/response/ChaiPayment;", "publicApiKey", "chaiPaymentId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apiGetChaiStatusSubscription", "Lcom/iamport/sdk/data/chai/response/ChaiPaymentSubscription;", "chaiSubscriptionId", "apiPostPrepare", "Lcom/iamport/sdk/data/chai/response/Prepare;", "request", "Lcom/iamport/sdk/data/chai/request/PrepareRequest;", "(Lcom/iamport/sdk/data/chai/request/PrepareRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkRemoteChaiStatus", "", "currentId", "", "doPolling", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearData", "confirmMerchant", "payment", "Lcom/iamport/sdk/data/sdk/Payment;", "data", "(Lcom/iamport/sdk/data/sdk/Payment;Lcom/iamport/sdk/data/chai/response/PrepareData;Lcom/iamport/sdk/data/chai/response/ChaiPaymentStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWork", "(Lcom/iamport/sdk/data/sdk/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/iamport/sdk/data/sdk/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "init", "isPolling", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSubscription", "approve", "Lcom/iamport/sdk/data/sdk/IamPortApprove;", "isTimeOut", "matchApproveData", "onceCheckRemoteChaiStatus", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processApprove", "(Lcom/iamport/sdk/data/chai/response/Approve;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processApprovePayments", "(Lcom/iamport/sdk/data/sdk/IamPortApprove;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processApprovePaymentsSubscription", "processPrepare", "prepare", "(Lcom/iamport/sdk/data/chai/response/Prepare;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processStatus", "displayStatus", "(Ljava/lang/String;Lcom/iamport/sdk/data/sdk/Payment;Lcom/iamport/sdk/data/chai/response/PrepareData;Ljava/lang/String;ZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestApprovePayments", "requestApproveToIamport", "requestGetChaiStatus", "Lcom/iamport/sdk/data/chai/response/BaseChaiPayment;", "(Lcom/iamport/sdk/data/chai/response/PrepareData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdkFinish", "response", "Lcom/iamport/sdk/data/sdk/IamPortResponse;", "tryPolling", "pollingDelay", "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_debug"})
public class ChaiStrategy extends com.iamport.sdk.domain.strategy.base.BaseStrategy {
    private final kotlinx.coroutines.CompletableJob job = null;
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private final kotlin.Lazy iamportApi$delegate = null;
    private com.iamport.sdk.data.remote.ChaiApi chaiApi;
    private java.lang.String chaiId;
    private com.iamport.sdk.data.chai.response.PrepareData prepareData;
    private long timeOutTime = 0L;
    private final java.util.concurrent.atomic.AtomicInteger pollingId = null;
    
    public ChaiStrategy() {
        super();
    }
    
    private final com.iamport.sdk.data.remote.IamportApi getIamportApi() {
        return null;
    }
    
    /**
     * SDK init
     * => doWork 때 동작
     */
    @java.lang.Override()
    public void init() {
    }
    
    /**
     * SDK 종료시 처리
     */
    @java.lang.Override()
    public void sdkFinish(@org.jetbrains.annotations.Nullable()
    com.iamport.sdk.data.sdk.IamPortResponse response) {
    }
    
    /**
     * prepareData 데이터 초기화
     */
    protected void clearData() {
    }
    
    private final boolean isTimeOut() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    java.lang.String chaiId, @org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * 간략한 시퀀스 설명
     * 1. IMP 서버에 유저 정보 요청해서 chai id 얻음 -> 결제 시퀀스 전 체크하는 것으로 수정함
     * 2. IMP 서버에 결제시작 요청 (+ chai id)
     * 3. chai 앱 실행
     * 4. 백그라운드 chai 서버 폴링
     * 5. if(차이폴링 approve) IMP 최종승인 요청
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.Payment payment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object apiPostPrepare(com.iamport.sdk.data.chai.request.PrepareRequest request, kotlin.coroutines.Continuation<? super com.iamport.sdk.data.remote.ResultWrapper<com.iamport.sdk.data.chai.response.Prepare>> continuation) {
        return null;
    }
    
    private final java.lang.Object apiGetChaiStatus(java.lang.String idempotencyKey, java.lang.String publicApiKey, java.lang.String chaiPaymentId, kotlin.coroutines.Continuation<? super com.iamport.sdk.data.remote.ResultWrapper<com.iamport.sdk.data.chai.response.ChaiPayment>> continuation) {
        return null;
    }
    
    private final java.lang.Object apiGetChaiStatusSubscription(java.lang.String idempotencyKey, java.lang.String publicApiKey, java.lang.String chaiSubscriptionId, kotlin.coroutines.Continuation<? super com.iamport.sdk.data.remote.ResultWrapper<com.iamport.sdk.data.chai.response.ChaiPaymentSubscription>> continuation) {
        return null;
    }
    
    private final java.lang.Object apiApprovePayment(java.lang.String impUserCode, java.lang.String impUid, java.lang.String paymentId, java.lang.String idempotencyKey, com.iamport.sdk.data.chai.response.ChaiPaymentStatus status, java.lang.String p5_1621174283, kotlin.coroutines.Continuation<? super com.iamport.sdk.data.remote.ResultWrapper<com.iamport.sdk.data.chai.response.Approve>> continuation) {
        return null;
    }
    
    private final java.lang.Object apiApprovePaymentSubscription(java.lang.String impUserCode, java.lang.String impUid, java.lang.String impCustomerUid, java.lang.String subscriptionId, java.lang.String idempotencyKey, com.iamport.sdk.data.chai.response.ChaiPaymentStatus status, java.lang.String p6_1621174283, kotlin.coroutines.Continuation<? super com.iamport.sdk.data.remote.ResultWrapper<com.iamport.sdk.data.chai.response.Approve>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object onceCheckRemoteChaiStatus(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * 4.  chai 서버 결제 상태 체크
     */
    private final java.lang.Object checkRemoteChaiStatus(int currentId, boolean doPolling, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object requestGetChaiStatus(com.iamport.sdk.data.chai.response.PrepareData prepareData, kotlin.coroutines.Continuation<? super com.iamport.sdk.data.remote.ResultWrapper<? extends com.iamport.sdk.data.chai.response.BaseChaiPayment>> continuation) {
        return null;
    }
    
    private final java.lang.Object confirmMerchant(com.iamport.sdk.data.sdk.Payment payment, com.iamport.sdk.data.chai.response.PrepareData data, com.iamport.sdk.data.chai.response.ChaiPaymentStatus status, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * * 5. if(내앱 포그라운드 && 차이폴링 인증완료) IMP 최종승인 요청
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object requestApprovePayments(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.sdk.IamPortApprove approve, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object requestApproveToIamport(com.iamport.sdk.data.sdk.IamPortApprove approve, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * 현재 결제중인 데이터와 머천트앱으로부터 전달받은 데이터가 동일한가 비교
     */
    private final boolean matchApproveData(com.iamport.sdk.data.sdk.IamPortApprove approve) {
        return false;
    }
    
    private final java.lang.Object processApprovePayments(com.iamport.sdk.data.sdk.IamPortApprove approve, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object processApprovePaymentsSubscription(com.iamport.sdk.data.sdk.IamPortApprove approve, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object tryPolling(int currentId, long pollingDelay, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * 차이 서버에서 데이터 가져왔을 때 처리
     */
    private final java.lang.Object processStatus(java.lang.String displayStatus, com.iamport.sdk.data.sdk.Payment payment, com.iamport.sdk.data.chai.response.PrepareData prepareData, java.lang.String impUid, boolean doPolling, int currentId, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final boolean isSubscription(com.iamport.sdk.data.chai.response.PrepareData prepareData) {
        return false;
    }
    
    private final boolean isSubscription(com.iamport.sdk.data.sdk.IamPortApprove approve) {
        return false;
    }
    
    private final java.lang.Object processPrepare(com.iamport.sdk.data.chai.response.Prepare prepare, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * 최종 결제 처리
     */
    @org.jetbrains.annotations.Nullable()
    protected java.lang.Object processApprove(@org.jetbrains.annotations.NotNull()
    com.iamport.sdk.data.chai.response.Approve approve, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * 외부에 폴링여부 알리기 위해 사용
     */
    private final java.lang.Object isPolling(boolean isPolling, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}