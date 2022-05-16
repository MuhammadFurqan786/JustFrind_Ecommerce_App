package com.justfriends.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.justfriends.adapter.NotificationAdapter
import com.justfriends.databinding.FragmentNotificationBinding


class NotificationFragment : Fragment() {
    lateinit var binding: FragmentNotificationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListener()
        setUpAdapter()
    }

    private fun setUpListener() {
        binding.topAppBar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
    }

    private fun setUpAdapter() {
        binding.rvNotification.adapter = NotificationAdapter()
    }

}