package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justfriends.databinding.AdapterSoldBinding
import com.justfriends.model.SoldProductData
import com.justfriends.network.ApiFactory

class SoldAdapter(private var soldProductData: List<SoldProductData>) :
    RecyclerView.Adapter<SoldAdapter.SoldViewHolder>() {
    private var mContext: Context? = null

    inner class SoldViewHolder(private var binding: AdapterSoldBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(post: SoldProductData) {
            binding.tvProductName.text = post.name
            binding.tvDeviceInfo.text = post.productDesc
            Glide.with(mContext ?: return)
                .load(ApiFactory.IMAGE_BASE_URL + post.img)
                .into(binding.ivPost)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoldViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterSoldBinding.inflate(inflater, parent, false)
        return SoldViewHolder(binding)


    }

    override fun onBindViewHolder(holder: SoldViewHolder, position: Int) {
        holder.bindView(soldProductData[position])
    }

    override fun getItemCount(): Int {
        return soldProductData.size
    }
}