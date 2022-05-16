package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.justfriends.adapter.SelectMenuSubCategoryAdapter
import com.justfriends.databinding.FragmentSubCategoryBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.model.SubCategoryItems
import com.justfriends.preference.PreferenceHelper
import com.justfriends.viewModel.CategoryViewModel
import com.justfriends.viewModel.PostViewModel


class SubCategoryFragment : Fragment(), SelectMenuSubCategoryAdapter.ICategoryClick {
    lateinit var binding: FragmentSubCategoryBinding
    private var selectSubCategoryAdapter: SelectMenuSubCategoryAdapter? = null
    private val categoryViewModel: CategoryViewModel by viewModels()
    private var mIMainActivity: IMainActivity? = null
    private lateinit var helper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubCategoryBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCategory.setHasFixedSize(true)
        categoryViewModel.getSubCategories()
        setupListener()
        setUpObserver()
    }

    private fun setUpObserver() {
        categoryViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        categoryViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        categoryViewModel.getSubCategoriesObserver.observe(viewLifecycleOwner) {
            selectSubCategoryAdapter = SelectMenuSubCategoryAdapter(it)
            selectSubCategoryAdapter?.setOnCategoryClickListener(this)
            binding.rvCategory.adapter = selectSubCategoryAdapter
        }
    }

    private fun setupListener() {
        binding.topAppBar.setNavigationOnClickListener {
          findNavController().navigateUp()
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

    override fun onCategoryClick(categoryName: SubCategoryItems) {
        helper.saveStringValue("sub_category", categoryName.id.toString())
        val direction =
            SubCategoryFragmentDirections.actionNavSubCategoryFragmentToNavPostAdFragment(
                categoryName.name.toString(),categoryName.categoryId.toString()
            )
        findNavController().navigate(direction)
    }
}