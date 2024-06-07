package com.blackpuppydev.matchy_native.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackpuppydev.matchy_native.databinding.CategoryAdapterBinding
import com.blackpuppydev.matchy_native.model.CategoryModel
import com.bumptech.glide.Glide

abstract class CategoryAdapter(var listCategory:ArrayList<CategoryModel>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){


    inner class CategoryViewHolder (var binding: CategoryAdapterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setItem(category:CategoryModel){

            binding.apply {
                Glide.with(itemView.context).load(category.image).into(imageCategory)
                titleCategory.text = category.title
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoryAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.setItem(listCategory[position])

        holder.binding.imageCategory.setOnClickListener {
            onSelectCategory(listCategory[position].title)
        }

    }

    override fun getItemCount(): Int = listCategory.size


    abstract fun onSelectCategory(categorySelect:String)

}