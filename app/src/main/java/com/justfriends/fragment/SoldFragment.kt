package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.justfriends.adapter.SoldAdapter
import com.justfriends.databinding.FragmentSoldBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.preference.PreferenceHelper
import com.justfriends.preference.PreferenceKeys
import com.justfriends.viewModel.PostViewModel


class SoldFragment : Fragment() {
    private lateinit var binding: FragmentSoldBinding
    private val postViewModel: PostViewModel by viewModels()
    private lateinit var helper: PreferenceHelper
    private var mIMainActivity: IMainActivity? = null
    private var adapterSold : SoldAdapter ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSoldBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postViewModel.getSoldProduct(helper.getStringValue(PreferenceKeys.KEY_USER_TOKEN) ?: "")
        setUpListener()
        setupObserver()
    }

    private fun setupObserver() {
        postViewModel.getProgressObserver.observe(viewLifecycleOwner){
            mIMainActivity?.showProgress(it)
        }
        postViewModel.getMessageObserver.observe(viewLifecycleOwner){
            mIMainActivity?.showMessage(it)
        }
        postViewModel.getSoldProductObserver.observe(viewLifecycleOwner){
            adapterSold = SoldAdapter(it)
            binding.rvSelling.adapter = adapterSold
        }
    }


    private fun setUpListener() {
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mIMainActivity = context as IMainActivity
    }

    override fun onDetach() {
        super.onDetach()
        mIMainActivity = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SoldFragment()
    }
}