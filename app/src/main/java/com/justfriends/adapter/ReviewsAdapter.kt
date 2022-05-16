package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justfriends.R
import com.justfriends.databinding.AdapterUserReviewBinding
import com.justfriends.model.FullReviewDataItem
import com.justfriends.model.Review
import com.justfriends.utils.Global
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ReviewsAdapter : RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder>() {
    private var mContext: Context? = null
    private var reviews = ArrayList<Review>()
    private var mCallback: IReview? = null

    inner class ReviewsViewHolder(private var binding: AdapterUserReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(review: Review, position: Int) {
            Glide.with(mContext!!)
                .load(Global.getImageUrl(review.userImg))
                .placeholder(R.drawable.ic_empty_photo)
                .into(binding.ivUser)
            binding.tvUserName.text = review.userName
            binding.tvUserReview.text = review.review
            binding.ratingBarReview.rating = review.rating.toFloat()
            binding.tvTime.text = mContext?.getString(
                R.string.time, Global.getTimeDifference(
                    review.createdDtm,
                    SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
                )
            )

            binding.ivOption.setOnClickListener {
                mCallback?.onOptionClick(review, position, binding.ivOption)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterUserReviewBinding.inflate(inflater, parent, false)
        return ReviewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        holder.bindView(reviews[position], position)
    }

    override fun getItemCount(): Int {
        return reviews.size
    }

    fun removeItem(position: Int) {
        try {
            reviews.removeAt(position)
            notifyItemRemoved(position)
        } catch (e: IndexOutOfBoundsException) {

        }
    }

    fun setData(data: List<Review>) {
        if (reviews.isNotEmpty()) {
            reviews.clear()
        }
        for (review in data) {
            reviews.add(review)
        }
        notifyDataSetChanged()
    }

    fun setOnReviewClickListener(callback: IReview) {
        mCallback = callback
    }

    interface IReview {
        fun onOptionClick(review: Review, position: Int, view: View)
    }
}