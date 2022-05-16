package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justfriends.R
import com.justfriends.databinding.AdapterPhotosBinding

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {
    private var mContext: Context? = null
    private val photos = ArrayList<String>()
    private var mCallback: PhotosClickInterface? = null

    inner class PhotosViewHolder(private var binding: AdapterPhotosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(image: String, position: Int) {
            binding.ivCancel.setOnClickListener {

            }
            Glide.with(mContext ?: return)
                .load(image)
                .placeholder(R.drawable.ic_empty_photo)
                .error(R.drawable.ic_empty_photo)
                .into(binding.ivCar)
            binding.ivCancel.setOnClickListener {
                removeItem(adapterPosition)
            }

        }

    }

    fun removeItem(position: Int) {
        try {
            photos.removeAt(position)
            notifyItemRemoved(position)
        }catch (e: java.lang.Exception){
            e.printStackTrace()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterPhotosBinding.inflate(inflater, parent, false)
        return PhotosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bindView(photos[position], position)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun onPhotosClickListener(callback: PhotosClickInterface) {
        this.mCallback = callback
    }

    fun setData(data: ArrayList<String>) {
        photos.clear()
        photos.addAll(data)
        notifyItemRangeChanged(0,data.size-1)

    }


    interface PhotosClickInterface {
        fun onPhotosClick(photoPath: String, position: Int)
        fun onDeletephoto(position: Int)
    }
}