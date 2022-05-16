package com.justfriends.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.justfriends.NavGraphDirections
import com.justfriends.adapter.WelcomePagerAdapter
import com.justfriends.databinding.FragmentWelcomeBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.preference.PreferenceHelper


class WelcomeFragment : Fragment() {
    lateinit var binding: FragmentWelcomeBinding
    private var mWelcomePagerAdapter: WelcomePagerAdapter? = null
    var mCurrentPage: Int = 0
    private lateinit var helper: PreferenceHelper
    var mIMainActivity: IMainActivity? = null

    private val boardingScreens = arrayListOf(
        Welcome1Fragment.newInstance(),
        Welcome2Fragment.newInstance(),
        Welcome3Fragment.newInstance()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (mIMainActivity?.getPreference()?.isUserLogin() == true) {
            val directions = NavGraphDirections.actionGlobalNavHomeFragment()
            findNavController().navigate(directions)

        }else{
            initViewPager()
        }


        setupListener()

    }

    private fun setupListener() {
        binding.fabNext.setOnClickListener {
            setupCurrentPage()
        }
    }

    private fun setupCurrentPage() {
        if(mCurrentPage < 2){
            mCurrentPage++
            binding.pagerWelcome.setCurrentItem(mCurrentPage,true)
        }else{
            val directions =
                NavGraphDirections.actionGlobalNavLoginFragment()
            findNavController().navigate(directions)
        }
    }

    private fun initViewPager() {
        mWelcomePagerAdapter = WelcomePagerAdapter(this, boardingScreens)
        binding.pagerWelcome.adapter = mWelcomePagerAdapter
        TabLayoutMediator(
            binding.tabLayout,
            binding.pagerWelcome
        ) { tab, position ->

        }.attach()


        binding.pagerWelcome.currentItem = mCurrentPage

        /*binding.pagerWelcome.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                selectedIndex = position
            }
        })*/





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