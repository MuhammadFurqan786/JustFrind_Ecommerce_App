package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.justfriends.R
import com.justfriends.utils.DateUtil
import com.sendbird.android.BaseMessage
import com.sendbird.android.SendBird
import com.sendbird.android.UserMessage

class MessageAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val VIEW_TYPE_USER_MESSAGE_ME = 10
    private val VIEW_TYPE_USER_MESSAGE_OTHER = 11

    private var messages: MutableList<BaseMessage>
    private var context: Context

    init {
        messages = ArrayList()
        this.context = context
    }

    fun loadMessages(messages: MutableList<BaseMessage>) {
        this.messages = messages
        notifyDataSetChanged()
    }

    fun addFirst(message: BaseMessage) {
        messages.add(0, message)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_USER_MESSAGE_ME -> {
                MyUserHolder(layoutInflater.inflate(R.layout.item_chat_me, parent, false))
            }
            VIEW_TYPE_USER_MESSAGE_OTHER -> {
                OtherUserHolder(layoutInflater.inflate(R.layout.item_chat_others, parent, false))
            }
            else -> MyUserHolder(
                layoutInflater.inflate(
                    R.layout.item_chat_me,
                    parent,
                    false
                )
            ) //Generic return

        }
    }

    override fun getItemViewType(position: Int): Int {

        val message = messages[position]

        return when (message) {
            is UserMessage -> {
                if (message.sender.userId.equals(SendBird.getCurrentUser().userId)) VIEW_TYPE_USER_MESSAGE_ME
                else VIEW_TYPE_USER_MESSAGE_OTHER
            }
            //Handle other types of messages FILE/ADMIN ETC
            else -> -1
        }
    }

    override fun getItemCount() = messages.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder.itemViewType) {
            VIEW_TYPE_USER_MESSAGE_ME -> {
                holder as MyUserHolder
                holder.bindView(context, messages.get(position) as UserMessage)
            }
            VIEW_TYPE_USER_MESSAGE_OTHER -> {
                holder as OtherUserHolder
                holder.bindView(context, messages.get(position) as UserMessage)
            }
            //Handle other types of messages FILE/ADMIN ETC
        }

    }

    class MyUserHolder(view: View) : RecyclerView.ViewHolder(view) {

        val messageText = view.findViewById<TextView>(R.id.text_gchat_message_me)
        val date = view.findViewById<TextView>(R.id.text_gchat_date_me)
        val messageDate = view.findViewById<TextView>(R.id.text_gchat_timestamp_me)

        fun bindView(context: Context, message: UserMessage) {

            messageText.text = message.message
            messageDate.text = DateUtil.formatTime(message.createdAt)

            date.visibility = View.VISIBLE
            date.text = DateUtil.formatDate(message.createdAt)
        }
    }

    class OtherUserHolder(view: View) : RecyclerView.ViewHolder(view) {

        val messageText = view.findViewById<TextView>(R.id.text_gchat_message_other)!!
        val date = view.findViewById<TextView>(R.id.text_gchat_date_other)!!
        val timestamp = view.findViewById<TextView>(R.id.text_gchat_timestamp_other)!!
        val profileImage = view.findViewById<ImageView>(R.id.image_gchat_profile_other)!!
        val user = view.findViewById<TextView>(R.id.text_gchat_user_other)


        fun bindView(context: Context, message: UserMessage) {

            messageText.text = message.message

            timestamp.text = DateUtil.formatTime(message.createdAt)

            date.visibility = View.VISIBLE
            date.text = DateUtil.formatDate(message.createdAt)

            Glide.with(context).load(message.sender.profileUrl)
                .apply(RequestOptions().override(75, 75))
                .into(profileImage)
            user.text = message.sender.nickname

        }

    }
}