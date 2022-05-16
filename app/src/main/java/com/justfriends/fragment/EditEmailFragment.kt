package com.justfriends.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.justfriends.R
import com.justfriends.databinding.FragmentEditEmailBinding
import com.justfriends.databinding.FragmentEditNameBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.preference.PreferenceHelper
import com.justfriends.viewModel.AuthViewModel


class EditEmailFragment : Fragment() {
    lateinit var binding: FragmentEditEmailBinding
    private var helper: PreferenceHelper? = null
    private val authViewModel: AuthViewModel by viewModels()
    private var mIMainActivity: IMainActivity? = null
    private val navArgs: EditEmailFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditEmailBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etEmail.setText(navArgs.email)
        setupListener()
        setupObserver()
    }

    private fun setupObserver() {
        authViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        authViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        authViewModel.getUpdateEmailObserver.observe(viewLifecycleOwner) {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.message))
                .setMessage(it.message)
                .setPositiveButton(getString(R.string.dismiss)) { dialog, _ ->
                    dialog.dismiss()
                    val directions =
                        EditEmailFragmentDirections.actionEditEmailFragmentToNavMyAccountFragment()
                    findNavController().navigate(directions)
                }
                .show()
        }
    }


    private fun setupListener() {
        binding.topAppBar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.btSave.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()

            if (email.isEmpty()) {
                mIMainActivity?.showMessage(getString(R.string.message_email_required))
            }

            authViewModel.updateEmail(
                helper?.getStringValue("token") ?: "",
                email
            )
        }
    }


}