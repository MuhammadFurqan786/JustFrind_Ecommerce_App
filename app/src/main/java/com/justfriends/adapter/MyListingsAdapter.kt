package com.justfriends.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.justfriends.fragment.FavoritesFragment
import com.justfriends.fragment.SellingFragment
import com.justfriends.fragment.SoldFragment

class MyListingsAdapter(private val pages:Array<Fragment>,fragment: Fragment) : FragmentStateAdapter(fragment)
{
    override fun getItemCount(): Int {
        return pages.size
    }

    override fun createFragment(position: Int): Fragment {
        return pages[position]

    }


}