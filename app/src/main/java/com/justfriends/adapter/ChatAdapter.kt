package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.justfriends.databinding.AdapterChatBinding

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    private var mContext: Context? = null
    inner class ChatViewHolder(private var binding: AdapterChatBinding) : RecyclerView.ViewHolder(
        binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterChatBinding.inflate(inflater,parent,false)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return 6
    }
}