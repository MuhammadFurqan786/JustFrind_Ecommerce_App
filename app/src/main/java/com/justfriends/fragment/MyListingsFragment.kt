package com.justfriends.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.justfriends.R
import com.justfriends.adapter.MyListingsAdapter
import com.justfriends.databinding.FragmentMyListingsBinding


class MyListingsFragment : Fragment(), SellingFragment.ISettingItem {
    private lateinit var binding: FragmentMyListingsBinding
    private var mListingsAdapter: MyListingsAdapter? = null
    private var pages = arrayOf(


        SoldFragment.newInstance(),
        FavoritesFragment.newInstance(),
        SellingFragment.newInstance(this)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMyListingsBinding.inflate(inflater, container, false)
        mListingsAdapter = MyListingsAdapter(pages, this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewPager()
        setUpListener()
    }

    private fun setUpListener() {
        binding.topAppBar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
    }

    private fun setUpViewPager() {
        binding.homeViewPager.adapter = mListingsAdapter
        TabLayoutMediator(binding.homeTabView, binding.homeViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.sold)
                1 -> tab.text = getString(R.string.favorites)
                else -> tab.text = getString(R.string.selling)
            }

        }.attach()
    }

    override fun onItemSold(pageIndex: Int) {
        binding.homeViewPager.setCurrentItem(pageIndex, true)
    }


}