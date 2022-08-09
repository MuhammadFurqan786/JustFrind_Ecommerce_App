package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.justfriends.R
import com.justfriends.databinding.FragmentEditNameBinding
import com.justfriends.databinding.FragmentMyAccountBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.preference.PreferenceHelper
import com.justfriends.preference.PreferenceKeys
import com.justfriends.utils.PrefKeys
import com.justfriends.viewModel.AuthViewModel


class EditNameFragment : Fragment() {
    private lateinit var binding: FragmentEditNameBinding
    private var helper: PreferenceHelper? = null
    private val authViewModel: AuthViewModel by viewModels()
    private var mIMainActivity: IMainActivity? = null
    private val navArgs: EditNameFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditNameBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etName.setText(navArgs.name)
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
        authViewModel.getUpdateNameObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it.message)
            val direction =
                EditNameFragmentDirections.actionNavEditNameFragmentToNavMyAccountFragment()
            findNavController().navigate(direction)
        }
    }

    private fun setupListener() {
        binding.topAppBar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.btSaveName.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            authViewModel.updateName(helper?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "", name)
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