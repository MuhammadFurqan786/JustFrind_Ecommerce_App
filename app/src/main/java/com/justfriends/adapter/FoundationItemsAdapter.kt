package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.justfriends.databinding.AdapterFoundationItemsBinding
import com.justfriends.model.FoundationItem

class FoundationItemsAdapter(private val foundationItems: List<FoundationItem>) :
    RecyclerView.Adapter<FoundationItemsAdapter.FoundationItemViewHolder>() {
    private var mContext: Context? = null
    private var mCallback: itemClick? = null

    inner class FoundationItemViewHolder(private var binding: AdapterFoundationItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: FoundationItem) {
            binding.tvFoundationItem.text = item.name
            binding.tvFoundationItem.setOnClickListener {
                mCallback?.onItemClick(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoundationItemViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterFoundationItemsBinding.inflate(inflater, parent, false)
        return FoundationItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: FoundationItemViewHolder, position: Int) {
        holder.bindView(foundationItems[position])
    }

    override fun getItemCount(): Int {
        return foundationItems.size

    }

    fun setOnFoundationClickListener(callback: itemClick) {
        mCallback = callback
    }


    interface itemClick {
        fun onItemClick(foundation: FoundationItem)
    }
}