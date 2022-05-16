package com.justfriends.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.justfriends.adapter.ChatAdapter
import com.justfriends.databinding.FragmentChatBinding


class ChatFragment : Fragment() {
    var binding : FragmentChatBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentChatBinding.inflate(inflater,container,false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sendBirdUikit()
        setUpAdapter()
        setUpListener()
    }

    private fun sendBirdUikit() {

    }

    private fun setUpListener() {

    }

    private fun setUpAdapter() {
        binding!!.rvChat.adapter = ChatAdapter()
    }


}