package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.justfriends.adapter.FoundationItemsAdapter
import com.justfriends.databinding.FragmentFoundationDialogBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.model.FoundationItem
import com.justfriends.viewModel.PostViewModel


class FoundationDialogFragment : BottomSheetDialogFragment(), FoundationItemsAdapter.itemClick {
    lateinit var binding: FragmentFoundationDialogBinding
    var adapterFoundationItems: FoundationItemsAdapter? = null
    private var mCallback: IFoundation? = null
    private val postViewModel: PostViewModel by viewModels()
    private var mIMainActivity: IMainActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoundationDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postViewModel.getFoundationValues()
        setUpObservers()
    }


    private fun setUpObservers() {
        postViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        postViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        postViewModel.getFoundationValuesObserver.observe(viewLifecycleOwner) {
            adapterFoundationItems = FoundationItemsAdapter(it)
            adapterFoundationItems?.setOnFoundationClickListener(this)
            binding.rvFoundationItems.adapter = adapterFoundationItems
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

    override fun onItemClick(foundation: FoundationItem) {
        mCallback?.onItemClick(foundation)
        dismiss()
    }

    companion object {
        fun newInstance() = FoundationDialogFragment()
    }


    fun setFoundationOnClickListener(callback: IFoundation) {
        this.mCallback = callback
    }


    interface IFoundation {
        fun onItemClick(foundationItem: FoundationItem)
    }


}