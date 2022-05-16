package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justfriends.R
import com.justfriends.databinding.AdapterHomeItemsBinding
import com.justfriends.model.Post
import com.justfriends.utils.Global
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    private lateinit var mContext: Context
    private val posts = ArrayList<Post>()
    private var mCallback:IPost?=null


    inner class PostViewHolder(
        private var binding: AdapterHomeItemsBinding,
        ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(post: Post) {
            
            Glide.with(mContext)
                .load(Global.getImageUrl(post.img))
                .placeholder(R.drawable.ic_empty_photo)
                .into(binding.ivPost)
            binding.tvName.text = post.name
            val productPrice = "${post.price} won"
            binding.tvProductPrice.text = productPrice
            binding.tvProductPrice.text = String.format("%,d", post.price)

            if (post.isCharity > 0) {
                binding.tvSupportFoundationName.visibility = View.VISIBLE
                binding.tvDonationPercent.visibility = View.VISIBLE
                binding.tvSupportFoundationName.text =
                    mContext?.getString(R.string.supportFoundationName, post.foundationName)
                val donationPercent =
                    "${Global.calculatePercentage(post.charityAmt, post.price)}% Donation"
                binding.tvDonationPercent.text = donationPercent
            } else {
                binding.tvSupportFoundationName.visibility = View.GONE
                binding.tvDonationPercent.visibility = View.GONE
            }



            binding.ivFav.setImageResource(
                if (post.isFav == 1)
                    R.drawable.ic_like
                else R.drawable.ic_like_normal
            )

            binding.ivFav.setOnClickListener {
                mCallback?.onFavClick(post.id, post.isFav, adapterPosition)
            }
            binding.ivPost.setOnClickListener {
                mCallback?.onItemClick(post)
            }
            binding.tvTime.text = mContext.getString(
                R.string.time, Global.getTimeDifference(
                    post.createdDtm,
                    SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
                )
            )

        }
    }


    fun notifyItem(isFav: Int, position: Int) {
        try {
            posts[position].isFav = isFav
            notifyItemChanged(position)

        } catch (e: IndexOutOfBoundsException) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterHomeItemsBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindView(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setData(data:List<Post>){
        if(posts.isNotEmpty()){
            posts.clear()
        }
        for (post in data){
            posts.add(post)
        }
        notifyDataSetChanged()
    }

    fun setOnPostClickListener(callback: IPost){
        mCallback = callback
    }

    interface IPost {
        fun onItemClick(post: Post)
        fun onFavClick(postId: Long, isFav: Int, position: Int)
    }
}