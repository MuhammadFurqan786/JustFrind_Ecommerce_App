package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.justfriends.databinding.AdapterSelectSubMenuCategoryBinding
import com.justfriends.model.SubCategoryItems

class SelectMenuSubCategoryAdapter(private val categories: List<SubCategoryItems>) :
    RecyclerView.Adapter<SelectMenuSubCategoryAdapter.SelectMenuSubCategoryViewHolder>() {

    private var mContext: Context? = null
    private var mCallback: ICategoryClick? = null

    inner class SelectMenuSubCategoryViewHolder(var binding: AdapterSelectSubMenuCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(category: SubCategoryItems) {
            binding.tvCategoryTitle.text = category.name
            binding.clCategory.setOnClickListener {
                mCallback?.onCategoryClick(category)
            }
        }

    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: SelectMenuSubCategoryViewHolder, position: Int) {
        holder.bindView(categories[position])
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectMenuSubCategoryViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterSelectSubMenuCategoryBinding.inflate(inflater, parent, false)
        return SelectMenuSubCategoryViewHolder(binding)
    }

    fun setOnCategoryClickListener(callback: ICategoryClick) {
        mCallback = callback
    }


    interface ICategoryClick {
        fun onCategoryClick(categoryName: SubCategoryItems)
    }
}