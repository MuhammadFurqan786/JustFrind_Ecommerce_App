package com.justfriends.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.justfriends.adapter.MessageAdapter
import com.justfriends.databinding.FragmentChatBinding
import com.sendbird.android.*
import kotlinx.android.synthetic.main.fragment_chat.*

class SingleChatFragment : Fragment() {
    var binding: FragmentChatBinding? = null
    private val CHANNEL_HANDLER_ID = "CHANNEL_HANDLER_GROUP_CHANNEL_CHAT"


    private lateinit var adapter: MessageAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var groupChannel: GroupChannel
    private lateinit var channelUrl: String
    private val navArgs: SingleChatFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        channelUrl = navArgs.channelUrl

        GroupChannel.getChannel(channelUrl,
            GroupChannel.GroupChannelGetHandler { groupChannels, e ->
                if (e != null) {
                    // Error!
                    e.printStackTrace()
                    return@GroupChannelGetHandler
                }
                groupChannel = groupChannels
                getMessages(groupChannel)
            }
        )
        setUpRecyclerView()
        setButtonListeners()
    }


    /**
     * Function handles setting handlers for back/send button
     */
    private fun setButtonListeners() {
        val back = button_gchat_back
//        val directions =
//            SingleChatFragmentArgs.actionChatFragmentToNavChatFragment()
//        findNavController().navigate(directions)

        val send = button_gchat_send
        send.setOnClickListener {
            if (::groupChannel.isInitialized)
            sendMessage(groupChannel)
        }
    }

    /**
     * Sends the message from the edit text, and clears text field.
     */
    private fun sendMessage(groupChannel: GroupChannel) {
        val params = UserMessageParams()
            .setMessage(edit_gchat_message.text.toString())
        groupChannel.sendUserMessage(params,
            BaseChannel.SendUserMessageHandler { userMessage, e ->
                if (e != null) {    // Error.
                    return@SendUserMessageHandler
                }
                adapter.addFirst(userMessage)
                edit_gchat_message.text.clear()
            })
    }


    /**
     * Function to get previous messages in channel
     */
    private fun getMessages(groupChannel: GroupChannel) {

        val previousMessageListQuery = groupChannel.createPreviousMessageListQuery()

        previousMessageListQuery.load(
            100,
            true
        ) { messages, e ->
            if (e != null) {
                e.message?.let { Log.e("Error", it) }
            }
            adapter.loadMessages(messages!!)
        }

    }

    /**
     * Set up the  recyclerview and set the adapter
     */
    private fun setUpRecyclerView() {
        adapter = context?.let { MessageAdapter(it) }!!
        recyclerView = recycler_gchat
        recyclerView.adapter = adapter
        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
        layoutManager.reverseLayout = true
        recyclerView.layoutManager = layoutManager
        recyclerView.scrollToPosition(0)

    }


    override fun onResume() {
        super.onResume()
        channelUrl = navArgs.channelUrl

        GroupChannel.getChannel(channelUrl,
            GroupChannel.GroupChannelGetHandler { groupChannels, e ->
                if (e != null) {
                    // Error!
                    e.printStackTrace()
                    return@GroupChannelGetHandler
                }
                groupChannel = groupChannels
                getMessages(groupChannel)
            })

        SendBird.addChannelHandler(
            CHANNEL_HANDLER_ID,
            object : SendBird.ChannelHandler() {
                override fun onMessageReceived(
                    baseChannel: BaseChannel,
                    baseMessage: BaseMessage
                ) {
                    if (baseChannel.url == channelUrl) {
                        // Add new message to view
                        adapter.addFirst(baseMessage)
                        groupChannel.markAsRead()
                    }
                }
            })
    }

    override fun onPause() {
        super.onPause()
        SendBird.removeChannelHandler(CHANNEL_HANDLER_ID)
    }
}