package com.justfriends.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.justfriends.NavGraphDirections
import com.justfriends.R
import com.justfriends.databinding.FragmentOtpVerificationBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.viewModel.AuthViewModel
import kotlinx.android.synthetic.main.fragment_otp_verification.*
import java.util.concurrent.TimeUnit


class OtpVerificationFragment : Fragment() {
    private lateinit var binding: FragmentOtpVerificationBinding
    private val authViewModel: AuthViewModel by viewModels()
    private val navArgs: OtpVerificationFragmentArgs by navArgs()
    private var mIMainActivity: IMainActivity? = null
    var otp: String? = null
    var code: String? = null
    lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOtpVerificationBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mobileNumber = navArgs.countryCode + navArgs.mobile
        binding.tvMobileNumber.text = mobileNumber
        setupListener()
        setUpObserver()

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(navArgs.countryCode + "" + navArgs.mobile) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(requireActivity()) // Activity (for callback binding)
            .setCallbacks(mCallBack) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)

    }

    private fun setUpObserver() {
        authViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        authViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        authViewModel.getSignUpObserver.observe(viewLifecycleOwner) {
            val direction =
                NavGraphDirections.actionGlobalNavLoginFragment()
            findNavController().navigate(direction)
        }
    }

    private fun setupListener() {

        binding.btConfirmation.setOnClickListener {

            verifyCode(binding.otpView.text.toString())
        }
        binding.toolbar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }

    }

    val mCallBack = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            code = p0.smsCode
            if (code != null) {
                binding.otpView.setText(code)
                verifyCode(code!!)
            }
        }


        override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
            super.onCodeSent(p0, p1)
            otp = p0


            Toast.makeText(
                context,
                "Otp send to $navArgs.countryCode$navArgs.mobile",
                Toast.LENGTH_SHORT
            ).show()
        }

        override fun onVerificationFailed(p0: FirebaseException) {
            Toast.makeText(activity, "" + p0.message, Toast.LENGTH_SHORT).show()
        }

    }

    private fun verifyCode(code1: String) {
        val credential = otp?.let { PhoneAuthProvider.getCredential(it, code1) }
        signInWithCredential(credential)
    }

    private fun signInWithCredential(credential: PhoneAuthCredential?) {
        if (credential != null) {
            auth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        authViewModel.signUp(
                            navArgs.email,
                            navArgs.password,
                            navArgs.name,
                            navArgs.countryCode,
                            navArgs.mobile,
                            "",
                            "",
                            "",
                            "",
                            navArgs.uniqueId,
                            "",
                            "",
                            "",
                            "",
                            0
                        )
                    } else {
                        mIMainActivity?.showMessage(getString(R.string.message_invalid_otp))
                    }
                }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mIMainActivity = context as IMainActivity
    }

    override fun onDetach() {
        super.onDetach()
        mIMainActivity = null
    }

}