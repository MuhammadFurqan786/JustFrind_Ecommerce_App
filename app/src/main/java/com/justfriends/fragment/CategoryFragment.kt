package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.justfriends.adapter.SelectMenuCategoryAdapter
import com.justfriends.databinding.FragmentCategoryBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.model.Category
import com.justfriends.preference.PreferenceHelper
import com.justfriends.viewModel.CategoryViewModel
import com.justfriends.viewModel.PostViewModel


class CategoryFragment : Fragment(), SelectMenuCategoryAdapter.ICategoryClick {
    lateinit var binding: FragmentCategoryBinding
    private var selectMenuCategoryAdapter: SelectMenuCategoryAdapter? = null
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
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCategory.setHasFixedSize(true)
        categoryViewModel.getCategories()
        setupListener()
        setupObserver()
    }

    private fun setupObserver() {
        categoryViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        categoryViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        categoryViewModel.getCategoryObserver.observe(viewLifecycleOwner) {
            selectMenuCategoryAdapter = SelectMenuCategoryAdapter(it)
            selectMenuCategoryAdapter?.setOnCategoryClickListener(this)
            binding.rvCategory.adapter = selectMenuCategoryAdapter
        }
    }

    private fun setupListener() {
        binding.topAppBar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
    
    override fun onCategoryClick(categoryId: Category) {
        helper.saveStringValue("category_id", categoryId.id.toString())
        val direction = CategoryFragmentDirections.actionNavCategoryFragmentToSubCategoryFragment()
        findNavController().navigate(direction)
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