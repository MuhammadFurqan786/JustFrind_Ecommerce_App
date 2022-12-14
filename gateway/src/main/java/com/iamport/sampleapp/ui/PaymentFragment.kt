package com.iamport.sampleapp.ui

import android.app.AlertDialog.Builder
import android.content.Context
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import com.google.gson.GsonBuilder
import com.iamport.sampleapp.MerchantReceiver
import com.iamport.sampleapp.PaymentResultData.result
import com.iamport.sampleapp.R
import com.iamport.sampleapp.ViewModel
import com.iamport.sampleapp.databinding.PaymentFragmentBinding
import com.iamport.sdk.data.sdk.IamPortApprove
import com.iamport.sdk.data.sdk.IamPortCertification
import com.iamport.sdk.data.sdk.IamPortResponse
import com.iamport.sdk.data.sdk.PG
import com.iamport.sdk.domain.core.ICallbackPaymentResult
import com.iamport.sdk.domain.core.Iamport
import com.iamport.sdk.domain.utils.CONST
import com.iamport.sdk.domain.utils.Event
import com.iamport.sdk.domain.utils.EventObserver
import com.iamport.sdk.domain.utils.Util
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class PaymentFragment : BaseFragment<PaymentFragmentBinding>() {

    override val layoutResourceId: Int = R.layout.payment_fragment
    private val receiver = MerchantReceiver()
    val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        Iamport.init(this) // fragment
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("SAMPLE", "onAttach")
        registForegroundServiceReceiver(context)
        requireActivity().onBackPressedDispatcher.addCallback(this, backPressCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        backPressCallback.remove()
        this.context?.unregisterReceiver(receiver)
    }

    // ?????? ???????????? ??????????????? ????????? ??????
    // (* ??????????????? ????????? ?????? ??????????????? enableService = false ??? ????????????,
    // Iamport.isPolling()?.observe ?????? true ?????? ?????? ?????????, ?????? ??????????????? ????????? ????????? ???????????? ?????????.)
    private fun registForegroundServiceReceiver(context: Context) {

        // enableService = true ???, ????????? ??????????????? ???????????? ???????????????.
        // enableFailStopButton = true ???, ??????????????? ??????????????? ?????? ?????? ???????????????.
        Iamport.enableChaiPollingForegroundService(enableService = true, enableFailStopButton = true)

        // ??????????????? ????????? ??? ??????????????? ????????? ?????? ?????? ????????? ???????????? broadcast ?????????
        context.registerReceiver(receiver, IntentFilter().apply {
            addAction(CONST.BROADCAST_FOREGROUND_SERVICE)
            addAction(CONST.BROADCAST_FOREGROUND_SERVICE_STOP)
        })

    }

    override fun initStart() {

        viewDataBinding.paymentButton.setOnClickListener {
            onClickPayment()
        }

        viewDataBinding.webviewModeButton.setOnClickListener {
            onClickWebViewModePayment()
        }

        viewDataBinding.mobilewebModeButton.setOnClickListener {
            onClickMobileWebModePayment()
        }

        viewDataBinding.certificationButton.setOnClickListener {
            onClickCertification()
        }

        viewDataBinding.backButton.setOnClickListener {
            backPressCallback.handleOnBackPressed()
        }

        val userCodeAdapter = ArrayAdapter(
            requireContext(), R.layout.support_simple_spinner_dropdown_item,
            Util.getUserCodeList()
        )

        val pgAdapter = ArrayAdapter(
            requireContext(), R.layout.support_simple_spinner_dropdown_item,
            PG.getPGNames()
        )

        viewDataBinding.userCode.adapter = userCodeAdapter
        viewDataBinding.userCode.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewModel.userCode = Util.getUserCode(viewDataBinding.userCode.selectedItemPosition)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        viewDataBinding.pg.adapter = pgAdapter
        viewDataBinding.pg.onItemSelectedListener = pgSelectListener

        viewDataBinding.name.doAfterTextChanged {
            viewModel.paymentName = it.toString()
        }
        viewDataBinding.name.setText("???????????? Android SDK ?????? ?????????")
        viewDataBinding.amount.doAfterTextChanged {
            viewModel.amount = it.toString()
        }
        viewDataBinding.amount.setText("1000")

        viewDataBinding.cardDirectCode.doAfterTextChanged {
            viewModel.cardDirectCode = it.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        viewDataBinding.merchantUid.doAfterTextChanged {
            viewModel.merchantUid = it.toString()
        }
        viewDataBinding.merchantUid.setText(getRandomMerchantUid())
//        onPolling()
    }


    private fun onPolling() {
        // ?????? ?????? ???????????? ?????? ????????? ???????????? ??? ????????????.
        Iamport.isPolling()?.observe(this, EventObserver {
            Log.i("SAMPLE", "?????? ??????? :: $it")
        })

        // ??????, ?????? ????????? ?????? ?????? ??? ??????????????? ??????
        Log.i("SAMPLE", "isPolling? ${Iamport.isPollingValue()}")
    }

    fun onClickCertification() {
        val userCode = "iamport"
        val certification = IamPortCertification(
            merchant_uid = getRandomMerchantUid(),
            company = "????????????",
        )

        Iamport.certification(userCode, iamPortCertification = certification) { callBackListener.result(it) }
    }

    private fun onClickMobileWebModePayment() {
        Iamport.close()
        (activity as MainActivity).replaceFragment(MobileWebViewModeFragment())
    }

    // ???????????? ?????? ?????? ??????
    private fun onClickWebViewModePayment() {
        val userCode = viewModel.userCode
        val request = viewModel.createIamPortRequest()
        Log.i("SAMPLE", "userCode :: $userCode")
        Log.i("SAMPLE", GsonBuilder().setPrettyPrinting().create().toJson(request))

        Iamport.close()
        (activity as MainActivity).replaceFragment(WebViewModeFragment())
    }

    // ?????? ?????? ??????
    private fun onClickPayment() {
        val userCode = viewModel.userCode
        val request = viewModel.createIamPortRequest()
        Log.i("SAMPLE", "userCode :: $userCode")
        Log.i("SAMPLE", GsonBuilder().setPrettyPrinting().create().toJson(request))

        /**
         * ???????????? Type#1 ICallbackPaymentResult ????????? ?????? ???????????? callback
         */
//        Iamport.payment(userCode, request, approveCallback = { approveCallback(it) }, paymentResultCallback = callBackListener)
//        Iamport.payment(userCode, request, paymentResultCallback = callBackListener)

        /**
         * ???????????? Type#2 ?????? ????????? ?????? ???????????? callbck
         */
//        Iamport.payment(userCode, request,
//            approveCallback = { approveCallback(it) },
//            paymentResultCallback = { callBackListener.result(it) })

//        Iamport.payment(userCode, iamPortRequest = request, approveCallback = { approveCallback(it) }) { callBackListener.result(it) }

//        Iamport.webViewCacheMode = WebSettings.LOAD_DEFAULT // ????????? ?????? default WebSettings.LOAD_NO_CACHE (ex: PG ???????????? ?????????, ???????????? ??? LOAD_DEFAULT ??????)
        Iamport.payment(userCode, iamPortRequest = request) { callBackListener.result(it) }
    }

    /**
     *  TODO: CHAI ????????? ???????????? ??? ??????????????? ?????? ????????? ????????????
     *  CONST.CHAI_FINAL_PAYMENT_TIME_OUT_SEC ?????? ???????????? ??? ?????? ????????????
     *  ????????? ?????? ????????? ???????????? ?????? ?????? Iamport.chaiPayment ????????? ?????????????????? ?????????.
     */
    private fun approveCallback(iamPortApprove: IamPortApprove) {
        val secUnit = 1000L
        val sec = 2
        GlobalScope.launch {
            Log.i("SAMPLE", "???????????? ?????????~~")
            delay(sec * secUnit) // sec ?????? ???????????? ??????????????? ???????????????
            Iamport.approvePayment(iamPortApprove) // TODO: ?????? ?????? ??? SDK ??? ???????????? ??????
        }
    }

    private val callBackListener = object : ICallbackPaymentResult {
        override fun result(iamPortResponse: IamPortResponse?) {
            val resJson = GsonBuilder().setPrettyPrinting().create().toJson(iamPortResponse)
            Log.i("SAMPLE", "?????? ?????? ??????\n$resJson")
            result = iamPortResponse
            if (iamPortResponse != null) {
//                (activity as MainActivity).replaceFragment(PaymentResultFragment())
                viewModel.resultCallback.postValue(Event(iamPortResponse))
            }
        }
    }

    private val pgSelectListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            viewModel.pg = PG.values()[position]
            viewDataBinding.pgMethod.adapter = ArrayAdapter(
                requireContext(), R.layout.support_simple_spinner_dropdown_item,
                Util.convertPayMethodNames(PG.values()[position])
            )

            viewDataBinding.pgMethod.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    viewModel.payMethod = Util.getMappingPayMethod(viewModel.pg).elementAt(viewDataBinding.pgMethod.selectedItemPosition)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
    }


    private val backPressCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {

            Builder(view?.context)
                .setTitle("????????? ?????????????????????????") // ?????? ?????????
                .setMessage("????????? ??? ??????") // ?????? ?????????
                // ???????????? ???????????? ??????
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    Iamport.close() // ???????????? SDK ??????
                    requireActivity().finish()
                }
                // ???????????? ???????????? ??????
                .setNegativeButton(android.R.string.cancel) { _, _ ->
                    Log.i("SAMPLE", "??????")
                }
                .create()
                .show()
        }
    }

    private fun getRandomMerchantUid(): String {
        return "muid_aos_${Date().time}"
    }

}
