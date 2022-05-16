package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.justfriends.databinding.AdapterKakaoLocationBinding
import com.justfriends.model.DocumentsItem

class KakaoLocationAdapter(
    private var kakaoMapData: List<DocumentsItem?>?,
    private var callback: LocationClickListener
) :
    RecyclerView.Adapter<KakaoLocationAdapter.KakaoLocationViewHolder>() {
    private var mContext: Context? = null

    inner class KakaoLocationViewHolder(
        private var binding: AdapterKakaoLocationBinding,
        var callback: LocationClickListener
    ) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun bindView(mapData: DocumentsItem?) {
            binding.tvLocation.text = mapData?.addressName
            binding.tvLocation.setOnClickListener {
                callback.onLocationClick(mapData)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KakaoLocationViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterKakaoLocationBinding.inflate(inflater, parent, false)
        return KakaoLocationViewHolder(binding, callback)
    }

    override fun onBindViewHolder(holder: KakaoLocationViewHolder, position: Int) {
        holder.bindView(kakaoMapData!![position])

    }

    override fun getItemCount(): Int {
        return kakaoMapData?.size!!
    }

    interface LocationClickListener {
        fun onLocationClick(mapData: DocumentsItem?)
    }
}