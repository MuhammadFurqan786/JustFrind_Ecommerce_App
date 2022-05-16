package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justfriends.R
import com.justfriends.databinding.AdapterFavoritesBinding
import com.justfriends.model.FavouriteItem
import com.justfriends.utils.Global

class FavoritesAdapter(
    favourites: ArrayList<FavouriteItem>,
    val callback: FavItemClickInterFace,
) : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {
    private var mContext: Context? = null
    private var favouritePosts = ArrayList<FavouriteItem>()


    init {
        this.favouritePosts = favourites
    }


    inner class FavoritesViewHolder(
        private var binding: AdapterFavoritesBinding,
        callback: FavItemClickInterFace,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        private var mCallback: FavItemClickInterFace? = null

        init {
            this.mCallback = callback
        }

        fun bindView(post: FavouriteItem) {
            Glide.with(mContext!!)
                .load(Global.getImageUrl(post.img))
                .placeholder(R.drawable.ic_empty_photo)
                .into(binding.ivPost)

            binding.tvProductName.text = post.productName
            binding.tvProductDescription.text = post.productDescription
            if (post.isFavourite == 1) {
                binding.ivLike.setImageResource(R.drawable.ic_like)
            } else {
                binding.ivLike.setImageResource(R.drawable.ic_unlike)
            }

            binding.ivDustbin.setOnClickListener {
                mCallback?.onFavClick(post.productId, post.isFavourite, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterFavoritesBinding.inflate(inflater, parent, false)
        return FavoritesViewHolder(binding, callback)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bindView(favouritePosts[position])
    }

    override fun getItemCount(): Int {
        return favouritePosts.size
    }

    interface FavItemClickInterFace {
        fun onItemClick(post: FavouriteItem)
        fun onFavClick(postId: Long, isFav: Int, position: Int)
    }

    fun removeItem(position: Int) {

        try {
            favouritePosts.removeAt(position)
            notifyItemRemoved(position)
        } catch (e: IndexOutOfBoundsException) {

        }

    }

}