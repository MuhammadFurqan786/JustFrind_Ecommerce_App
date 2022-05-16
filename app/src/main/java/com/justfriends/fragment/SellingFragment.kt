package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.justfriends.R
import com.justfriends.adapter.SellingAdapter
import com.justfriends.databinding.FragmentSellingBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.model.Post
import com.justfriends.preference.PreferenceHelper
import com.justfriends.preference.PreferenceKeys
import com.justfriends.viewModel.MyListingViewModel
import com.justfriends.viewModel.PostViewModel


class SellingFragment(var callback: ISettingItem) : Fragment(),
    SellingAdapter.SellingAdapterClickListener {
    lateinit var binding: FragmentSellingBinding
    private val myListingViewModel: MyListingViewModel by activityViewModels()
    private val postViewModel: PostViewModel by viewModels()
    private lateinit var helper: PreferenceHelper
    private var mIMainActivity: IMainActivity? = null
    private var sellingAdapter: SellingAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSellingBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myListingViewModel.getMyMarketPlacePosts(helper.getStringValue(PreferenceKeys.KEY_USER_TOKEN) ?: "")
        setUpObserver()
        setupMarkAsSoldObserver()
        setupPostDetailObservers()
    }


    private fun setUpObserver() {
        myListingViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        myListingViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        myListingViewModel.getMarketPlaceObserver.observe(viewLifecycleOwner) {
            sellingAdapter = SellingAdapter(it, this)
            binding.rvSelling.adapter = sellingAdapter
        }
    }

    private fun setupMarkAsSoldObserver() {
        myListingViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        myListingViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        myListingViewModel.getMarkAsSold.observe(viewLifecycleOwner) {
            if (it.success) {
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Success")
                    .setMessage("Your product is successfully marked as sold!")
                    .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                        dialog.dismiss()
                        callback.onItemSold(2)
                    }
                    .show()
                myListingViewModel.getMyMarketPlacePosts(helper.getStringValue(PreferenceKeys.KEY_USER_TOKEN) ?: "")

            }
        }
    }

    private fun setupPostDetailObservers() {
        postViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        postViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        postViewModel.getPostDetailObserver.observe(viewLifecycleOwner) {
            it?.let { post ->
               //    setPostData(post)
            }
        }
    }

    /*   private fun setPostData(post: List<PostDetailData>) {
           binding.rvSelling.adapter = SellingAdapter(post,this)
       }*/


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
        fun newInstance(callback: ISettingItem) =
            SellingFragment(callback)
    }


    private fun openOptionMenu(post: Post) {
        val items = arrayOf(
            getString(R.string.mark_as_sold),
            getString(R.string.cancel),
        )
        MaterialAlertDialogBuilder(requireContext())
            .setItems(items) { dialog, which ->
                when (which) {
                    0 -> {
                        myListingViewModel.markAsSold(
                            helper.getStringValue(PreferenceKeys.KEY_USER_TOKEN) ?: "",
                            post.id!!
                        )
                    }
                    1 -> {
                        dialog.dismiss()
                    }
                }
            }
            .show()
    }


    interface ISettingItem {
        fun onItemSold(pageIndex: Int)
    }

    override fun onItemClick(post: Post) {

    }

    override fun onFavClick(postId: Long, isFav: Int, position: Int) {

    }

    override fun onOptionClick(post: Post) {
        openOptionMenu(post)
    }
}