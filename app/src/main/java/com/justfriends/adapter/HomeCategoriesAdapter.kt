package com.justfriends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justfriends.databinding.AdapterHomeCategoriesBinding
import com.justfriends.model.Category
import com.justfriends.network.ApiFactory

class HomeCategoriesAdapter :
    RecyclerView.Adapter<HomeCategoriesAdapter.HomeCategoriesViewHolder>() {
    private var mContext: Context? = null
    private var mCallback: ICategoryClick? = null
    private val categories= ArrayList<Category>()

    inner class HomeCategoriesViewHolder(private var binding: AdapterHomeCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bindView(category: Category) {
            val categoryName = category.name.toString().split(" ")

            if (categoryName.size > 2) {
                val categoryNameBuilder = StringBuilder()

                for ((index, value) in categoryName.withIndex()) {
                    categoryNameBuilder.append(value)

                    if (index == 1) {
                        categoryNameBuilder.append("\n")
                    } else {
                        categoryNameBuilder.append(" ")
                    }

                }
                binding.tvHomeCategory.text = categoryNameBuilder.toString()

            } else {
                binding.tvHomeCategory.text = category.name
            }

            Glide.with(mContext ?: return)
                .load(ApiFactory.IMAGE_BASE_URL + category.img)
                .into(binding.ivCategory)
            binding.ivCategory.setOnClickListener {
                mCallback?.onCategoryClick(category.id)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoriesViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = AdapterHomeCategoriesBinding.inflate(inflater, parent, false)
        return HomeCategoriesViewHolder(binding)

    }

    override fun onBindViewHolder(holder: HomeCategoriesViewHolder, position: Int) {
        holder.bindView(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }


    fun setData(data:List<Category>){
        if(categories.isNotEmpty()){
            categories.clear()
        }
        for (category in data){
            categories.add(category)
        }
        notifyDataSetChanged()
    }


    fun setOnCategoryClickListener(callback: ICategoryClick) {
        mCallback = callback
    }


    interface ICategoryClick {
        fun onCategoryClick(categoryId: Long)
    }


}