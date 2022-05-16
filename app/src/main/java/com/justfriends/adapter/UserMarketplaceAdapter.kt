package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justfriends.R
import com.justfriends.databinding.AdapterGalleryBinding
import com.justfriends.model.Post
import com.justfriends.model.UserProductData
import com.justfriends.utils.Global

class UserMarketplaceAdapter(var posts: List<Post>, val callback: PostItemClickInterface) :
    RecyclerView.Adapter<UserMarketplaceAdapter.UserMarketplaceViewHolder>() {
    private var mContext: Context? = null


    inner class UserMarketplaceViewHolder(
        private var binding: AdapterGalleryBinding, var callback: PostItemClickInterface,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(post: Post) {
            Glide.with(mContext!!)
                .load(Global.getImageUrl(post.img))
                .placeholder(R.drawable.ic_empty_photo)
                .into(binding.ivProduct)
            binding.ivProduct.setOnClickListener {
                callback.onItemClick(post)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserMarketplaceViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterGalleryBinding.inflate(inflater, parent, false)
        return UserMarketplaceViewHolder(binding, callback)
    }

    override fun onBindViewHolder(holder: UserMarketplaceViewHolder, position: Int) {
        holder.bindView(posts[position])

    }

    override fun getItemCount(): Int {
        return posts.size
    }

    interface PostItemClickInterface {
        fun onItemClick(post: Post)
    }

}