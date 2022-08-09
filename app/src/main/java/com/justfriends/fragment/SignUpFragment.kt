package com.justfriends.fragment

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.justfriends.NavGraphDirections
import com.justfriends.R
import com.justfriends.R.string
import com.justfriends.databinding.FragmentSignUpBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.preference.PreferenceHelper
import com.justfriends.utils.Global
import com.justfriends.viewModel.AuthViewModel
import java.util.*
import java.util.concurrent.TimeUnit


class SignUpFragment : Fragment() {
    lateinit var binding: FragmentSignUpBinding
    var mIMainActivity: IMainActivity? = null
    private val authViewModel: AuthViewModel by viewModels()
    var uniqueID = UUID.randomUUID().toString()
    private var helper: PreferenceHelper? = null
    var name: String? = null
    var email: String? = null
    var mobile: String? = null
    var password: String? = null
    var countryCode: String? = null
    var confirmPassword: String? = null
    var show = true


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setSpannable()
        setUpListener()
    }

    private fun setupObservers() {
        authViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        authViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }

        authViewModel.getCheckEmailObserver.observe(viewLifecycleOwner) {
            binding.btSignIn.isEnabled = true
        }
        authViewModel.getCheckMobileObserver.observe(viewLifecycleOwner) {
            binding.btSignIn.isEnabled = true
        }
    }


    private fun setUpListener() {

        binding.toolbar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
        binding.ivEye.setOnClickListener {
            if (show) {
                Global.hidePassword(binding.etPassword, binding.ivEye)
                show = false
            } else {
                Global.showPassword(binding.etPassword, binding.ivEye)
                show = true
            }
        }
        binding.etEmail.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                authViewModel.checkEmail(binding.etEmail.text.toString().trim())
                binding.btSignIn.isEnabled = false
            }
        }
        binding.etPhone.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                countryCode = binding.ccp.selectedCountryCodeWithPlus
                mobile = binding.etPhone.text.toString().trim()
                authViewModel.checkMobile("$countryCode$mobile")
                binding.btSignIn.isEnabled = false
            }
        }


        binding.ivConfirmEye.setOnClickListener {
            if (show) {
                Global.hidePassword(binding.etConfirmPassword, binding.ivConfirmEye)
                show = false
            } else {
                Global.showPassword(binding.etConfirmPassword, binding.ivConfirmEye)
                show = true
            }
        }



        binding.btSignIn.setOnClickListener {
            name = binding.etName.text.toString().trim()
            email = binding.etEmail.text.toString().trim()
            mobile = binding.etPhone.text.toString().trim()
            password = binding.etConfirmPassword.text.toString().trim()
            confirmPassword = binding.etConfirmPassword.text.toString().trim()
            countryCode = binding.ccp.selectedCountryCodeWithPlus
            if (binding.cbTermsConditions.isChecked) {
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(
                        activity,
                        getString(R.string.message_enter_name),
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (!Global.isEmailValid(email)) {
                    Toast.makeText(
                        activity,
                        getString(R.string.message_valid_email),
                        Toast.LENGTH_SHORT
                    ).show()

                } else if (password != confirmPassword) {
                    Toast.makeText(
                        activity,
                        getString(R.string.message_password_same),
                        Toast.LENGTH_SHORT
                    ).show()

                } else if (TextUtils.isEmpty(email)) {
                    Toast.makeText(
                        activity,
                        getString(R.string.message_valid_email),
                        Toast.LENGTH_SHORT
                    ).show()

                } else if (TextUtils.isEmpty(mobile)) {
                    Toast.makeText(
                        activity,
                        getString(R.string.message_enter_phone),
                        Toast.LENGTH_SHORT
                    ).show()

                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(
                        activity,
                        getString(R.string.message_enter_password),
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (mobile!!.length < 10) {
                    Toast.makeText(
                        activity,
                        getString(R.string.message_valid_phone),
                        Toast.LENGTH_SHORT
                    ).show()

                } else if (password!!.length < 8) {
                    Toast.makeText(
                        activity,
                        getString(R.string.message_password_length),
                        Toast.LENGTH_SHORT
                    ).show()

                } else if (!Global.hasInternetConnectivity(requireActivity())) {
                    Toast.makeText(
                        activity,
                        getString(R.string.check_your_internet),
                        Toast.LENGTH_SHORT
                    ).show()

                } else {
                    sendVerificationCode(
                        email!!,
                        password!!,
                        name!!,
                        countryCode,
                        mobile!!,
                        confirmPassword!!
                    )
                }

            }


        }
    }

    private fun sendVerificationCode(
        email: String,
        password: String,
        name: String,
        countryCode: String?,
        mobile: String,
        confirmPassword: String
    ) {
        val directions =
            NavGraphDirections.actionGlobalNavOtpVerificationFragment(
                countryCode.toString(), mobile, name,
                email, password, uniqueID
            )
        findNavController().navigate(directions)
    }


    private fun setSpannable() {
        val ss = SpannableString(getString(string.messageAlreadyHaveAccount))
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                val direction = NavGraphDirections.actionGlobalNavLoginFragment()
                findNavController().navigate(direction)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }
        ss.setSpan(clickableSpan, 24, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(StyleSpan(Typeface.BOLD), 24, ss.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(
            ForegroundColorSpan(Color.WHITE),
            24,
            ss.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.tvAlreadyHaveAccount.text = ss
        binding.tvAlreadyHaveAccount.text = ss
        binding.tvAlreadyHaveAccount.movementMethod = LinkMovementMethod.getInstance()
        binding.tvAlreadyHaveAccount.highlightColor = Color.TRANSPARENT
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