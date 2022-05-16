package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.justfriends.R
import com.justfriends.databinding.FragmentSortDialogBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.utils.PrefKeys
import com.justfriends.utils.Sort


class SortDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentSortDialogBinding
    private var mIMainActivity: IMainActivity? = null
    private var openFirstTime: Boolean = true
    private var mListener: SortOptionClickListener? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSortDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rgSort.setOnCheckedChangeListener { group, checkedId ->
            Log.d("TAG", "onViewCreated: $checkedId")
            if (openFirstTime){
                openFirstTime = false
                return@setOnCheckedChangeListener
            }

            when (checkedId) {


                R.id.rb_newest -> {
                    mListener?.onSortOptionClick(Sort.NEWEST)
                    mIMainActivity?.getPreference()
                        ?.saveStringValue(PrefKeys.KEY_SORT_BY, Sort.NEWEST)
                }
                R.id.rb_nearest -> {
                    mListener?.onSortOptionClick(Sort.CLOSEST)
                    mIMainActivity?.getPreference()
                        ?.saveStringValue(PrefKeys.KEY_SORT_BY, Sort.CLOSEST)
                }
                R.id.rb_low_to_high -> {
                    mListener?.onSortOptionClick(Sort.LOW_TO_HIGH)
                    mIMainActivity?.getPreference()
                        ?.saveStringValue(PrefKeys.KEY_SORT_BY, Sort.LOW_TO_HIGH)
                }
                R.id.rb_high_to_low -> {
                    mListener?.onSortOptionClick(Sort.HIGH_TO_LOW)
                    mIMainActivity?.getPreference()
                        ?.saveStringValue(PrefKeys.KEY_SORT_BY, Sort.HIGH_TO_LOW)
                }
                // else -> Toast.makeText(requireContext(), "else part", Toast.LENGTH_SHORT).show()
            }
            dismiss()


        }

    }

    override fun onResume() {
        super.onResume()
        setCheck(
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_SORT_BY) ?: Sort.NEWEST
        )
    }

    fun setListener(mListener: SortOptionClickListener) {
        this.mListener = mListener
    }

    interface SortOptionClickListener {
        fun onSortOptionClick(sort: String)
    }

    fun newInstance(): SortDialogFragment {
        return SortDialogFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mIMainActivity = context as IMainActivity
    }

    override fun onDetach() {
        super.onDetach()
        mIMainActivity = null
    }

    private fun setCheck(value: String) {
        when (value) {
            Sort.NEWEST -> binding.rbNewest.isChecked = true
            Sort.CLOSEST -> binding.rbNearest.isChecked = true
            Sort.LOW_TO_HIGH -> binding.rbLowToHigh.isChecked = true
            Sort.HIGH_TO_LOW -> binding.rbHighToLow.isChecked = true
        }

    }


}