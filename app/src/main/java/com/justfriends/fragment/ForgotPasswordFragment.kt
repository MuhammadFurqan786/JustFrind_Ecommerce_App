package com.justfriends.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.justfriends.R
import com.justfriends.databinding.FragmentForgotPasswordBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.viewModel.AuthViewModel


class ForgotPasswordFragment : Fragment() {
    lateinit var binding: FragmentForgotPasswordBinding
    private val authViewModel: AuthViewModel by viewModels()
    private var mIMainActivity: IMainActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListener()
        setUpObserver()
    }

    private fun setUpObserver() {
        authViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        authViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        authViewModel.getFogotPasswordObserver.observe(viewLifecycleOwner) {
            showAlert(it.message)
        }
    }

    private fun showAlert(message: String) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.success))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                findNavController().navigateUp()

            }
            .show()
    }


    private fun setUpListener() {
        binding.ivBack.setOnClickListener {
            it.findNavController().navigateUp()
        }
        binding.btSubmit.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            authViewModel.forgotPassword(email)

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