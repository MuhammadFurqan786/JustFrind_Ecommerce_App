package com.justfriends.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justfriends.R
import com.justfriends.databinding.AdapterIvZoomableBinding
import com.justfriends.utils.Global

class ImageSlidesShowAdapter(val images: Array<String>, val zoomable: Boolean = false) :
    RecyclerView.Adapter<ImageSlidesShowAdapter.ImageSlideShowViewHolder>() {

    private var mCallback: IImageClick? = null

    inner class ImageSlideShowViewHolder(private val binding: AdapterIvZoomableBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(image: String) {
            Glide.with(binding.root.context)
                .load(Global.getImageUrl(image))
                .placeholder(R.drawable.ic_empty_photo)
                .into(binding.ivProduct)
            binding.ivProduct.isZoomable= zoomable

            if (!zoomable){
                 binding.ivProduct.setOnClickListener {
               mCallback?.onImageClick(adapterPosition, images)
           }

            }

        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSlideShowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterIvZoomableBinding.inflate(inflater, parent, false)

        return ImageSlideShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageSlideShowViewHolder, position: Int) {
        holder.bindView(images?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return images?.size!!
    }

    fun setOnImageClickListener(callback: IImageClick) {
        mCallback = callback
    }

    interface IImageClick {
        fun onImageClick(position: Int, images: Array<String>)
    }
}