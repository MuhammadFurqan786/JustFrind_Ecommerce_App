package com.justfriends.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.justfriends.R
import com.justfriends.databinding.FragmentFilterDialogBinding
import com.justfriends.preference.PreferenceHelper
import com.justfriends.preference.PreferenceKeys
import com.justfriends.utils.Global


class FilterDialogFragment : BottomSheetDialogFragment() {
    lateinit var binding: FragmentFilterDialogBinding
    private var conditionsAdapter: ArrayAdapter<String>? = null
    private val conditions = arrayOf("Best", "Good", "Ok", "Poor")
    private var helper: PreferenceHelper? = null
    private var mCallback: ApplyFilterInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        helper = PreferenceHelper.getPref(requireContext())
        conditionsAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, conditions)
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFilterDialogBinding.inflate(inflater, container, false)
        with(binding) { btApplyFilter.setBackgroundColor(btApplyFilter.context.resources.getColor(R.color.color_primary)) }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        setupListener()
    }

    private fun initData() {
        val minPrice = helper?.getStringValue(PreferenceKeys.KEY_MIN_PRICE)
        val maxPrice = helper?.getStringValue(PreferenceKeys.KEY_MAX_PRICE)
        val condition = helper?.getStringValue(PreferenceKeys.KEY_CONDITION)
        val distance = helper?.getStringValue(PreferenceKeys.KEY_DISTANCE)
        binding.etMinimum.setText(minPrice)
        binding.etMaximum.setText(maxPrice)

        if (condition?.isNotEmpty() == true) {
            binding.autocompleteConditions.setText(condition)
        }

        if (distance?.isNotEmpty() == true) {
            binding.rangeSlider.value = distance.toFloat()
        }

    }

    private fun setupListener() {
        binding.inputLayoutConditions.setEndIconOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.conditions))
                .setItems(conditions) { dialog, which ->
                    binding.autocompleteConditions.setText(conditions[which])
                }.show()
        }
        binding.btApplyFilter.setOnClickListener {
            val minPrice = binding.etMinimum.text.toString().trim()
            val maxPrice = binding.etMaximum.text.toString().trim()
            val condition = binding.autocompleteConditions.text.toString().trim()
            val distance = binding.rangeSlider.value.toInt()
            Log.d(
                "TAG",
                "onApplyFiledClick: minPrice = $minPrice\nmaxPrice = $maxPrice\ncondition = $condition\ndistance = $distance\n"
            )
            if (minPrice.isNotEmpty() && maxPrice.isNotEmpty()) {
                if (minPrice.toInt() > maxPrice.toInt()) {
                    Global.showMessage(
                        binding.root,
                        getString(R.string.message_minimum_value)
                    )
                    return@setOnClickListener
                }
            }
            if (
                minPrice.isEmpty() &&
                maxPrice.isEmpty() &&
                condition.isEmpty() &&
                distance == 0
            ) {
                Global.showMessage(binding.root, getString(R.string.message_apply_filter))
                Toast.makeText(
                    requireContext(),
                    getString(R.string.message_apply_filter),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            var filterDistance = distance.toString()
            if (distance == 0) {
                filterDistance = ""
            }

            helper?.saveStringValue(PreferenceKeys.KEY_MIN_PRICE, minPrice)
            helper?.saveStringValue(PreferenceKeys.KEY_MAX_PRICE, maxPrice)
            helper?.saveStringValue(PreferenceKeys.KEY_CONDITION, condition)
            helper?.saveStringValue(PreferenceKeys.KEY_DISTANCE, filterDistance)
            mCallback?.onApplyFiledClick(minPrice, maxPrice, condition, filterDistance)
            dismiss()
        }
    }


    fun newInstance(): FilterDialogFragment {
        return FilterDialogFragment()
    }

    interface ApplyFilterInterface {
        fun onApplyFiledClick(
            minPrice: String,
            maxPrice: String,
            condition: String,
            distance: String,
        )
    }


}