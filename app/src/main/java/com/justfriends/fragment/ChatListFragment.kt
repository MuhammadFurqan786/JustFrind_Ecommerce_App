package com.justfriends.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.justfriends.adapter.ChannelListAdapter
import com.justfriends.databinding.FragmentListChatBinding
import com.sendbird.android.GroupChannel


class ChatListFragment : Fragment(), ChannelListAdapter.OnChannelClickedListener {
    var binding: FragmentListChatBinding? = null
    private val EXTRA_CHANNEL_URL = "EXTRA_CHANNEL_URL"
    lateinit var adapter: ChannelListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListChatBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sendBirdUikit()
        setUpAdapter()
        setUpListener()
        addChannels()
    }

    private fun addChannels() {
        val channelList = GroupChannel.createMyGroupChannelListQuery()
        channelList.limit = 100
        channelList.next { list, e ->
            if (e != null) {
                Log.e("TAG", e.message.toString())
            }
            adapter.addChannels(list)
        }
    }

    private fun sendBirdUikit() {

    }

    private fun setUpListener() {

    }

    private fun setUpAdapter() {
        adapter = ChannelListAdapter(this)
        binding?.rvChat?.adapter = adapter
        binding?.rvChat?.layoutManager = LinearLayoutManager(context)

    }

    override fun onItemClicked(channel: GroupChannel) {
        val directions =
            ChatListFragmentDirections.actionNavChatFragmentToChatFragment(channel.url)
        findNavController().navigate(directions)

    }


}