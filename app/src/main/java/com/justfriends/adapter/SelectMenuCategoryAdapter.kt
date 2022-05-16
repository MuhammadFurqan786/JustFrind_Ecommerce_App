package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.justfriends.databinding.AdapterSelectMenuCategoryBinding
import com.justfriends.model.Category

class SelectMenuCategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<SelectMenuCategoryAdapter.SelectMenuCategoryViewHolder>() {

    private var mContext: Context? = null
    private var mCallback: ICategoryClick? = null

    inner class SelectMenuCategoryViewHolder(private var binding: AdapterSelectMenuCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(category: Category) {
            binding.tvCategoryTitle.text = category.name
            binding.clCategory.setOnClickListener {
                mCallback?.onCategoryClick(category)
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectMenuCategoryViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterSelectMenuCategoryBinding.inflate(inflater, parent, false)
        return SelectMenuCategoryViewHolder(binding)

    }

    override fun onBindViewHolder(holder: SelectMenuCategoryViewHolder, position: Int) {
        holder.bindView(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun setOnCategoryClickListener(callback: ICategoryClick) {
        mCallback = callback
    }


    interface ICategoryClick {
        fun onCategoryClick(categoryId: Category)
    }
}