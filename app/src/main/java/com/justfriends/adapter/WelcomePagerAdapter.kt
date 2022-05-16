package com.justfriends.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class WelcomePagerAdapter(fragment: Fragment, private val boardingScreens:ArrayList<Fragment>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return boardingScreens.size

    }

    override fun createFragment(position: Int): Fragment {
       return boardingScreens[position]
    }


}