package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.justfriends.NavGraphDirections
import com.justfriends.R
import com.justfriends.databinding.FragmentOtpVerificationBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.viewModel.AuthViewModel


class OtpVerificationFragment : Fragment() {
    private lateinit var binding: FragmentOtpVerificationBinding
    private val authViewModel: AuthViewModel by viewModels()
    private val navArgs: OtpVerificationFragmentArgs by navArgs()
    private var mIMainActivity: IMainActivity? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOtpVerificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mobileNumber = navArgs.countryCode + navArgs.mobile
        binding.tvMobileNumber.text = mobileNumber
        setupListener()
        setUpObserver()
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
            val otp = binding.otpView.text.toString().trim()
            if (otp == navArgs.otp) {
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
        binding.toolbar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
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