package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justfriends.databinding.AdapterSellingBinding
import com.justfriends.model.Post
import com.justfriends.network.ApiFactory

class SellingAdapter(private val post: List<Post>, var callback: SellingAdapterClickListener) :
    RecyclerView.Adapter<SellingAdapter.SellingViewHolder>() {
    private var mContext: Context? = null

    inner class SellingViewHolder(private var binding: AdapterSellingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(post: Post) {
            binding.tvProductName.text = post.name
            binding.tvDeviceInfo.text = post.productDesc
            Glide.with(mContext ?: return)
                .load(ApiFactory.IMAGE_BASE_URL + post.img)
                .into(binding.ivPost)

            binding.ivOption.setOnClickListener {
                callback.onOptionClick(post)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellingViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterSellingBinding.inflate(inflater, parent, false)
        return SellingViewHolder(binding)

    }

    override fun onBindViewHolder(holder: SellingViewHolder, position: Int) {
        holder.bindView(post[position])
    }

    override fun getItemCount(): Int {
        return post.size
    }

    interface SellingAdapterClickListener {
        fun onItemClick(post: Post)
        fun onFavClick(postId: Long, isFav: Int, position: Int)
        fun onOptionClick(post: Post)
    }
}