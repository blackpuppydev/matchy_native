package com.blackpuppydev.matchy_native.adapter

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackpuppydev.matchy_native.databinding.ImagePeopleAdapterBinding
import com.bumptech.glide.Glide

class ImagePeopleAdapter(var people:ArrayList<String>) : RecyclerView.Adapter<ImagePeopleAdapter.ImagePeopleViewHolder>() {

    inner class ImagePeopleViewHolder (var binding: ImagePeopleAdapterBinding) : RecyclerView.ViewHolder(binding.root){

        fun setImage(image:String){
            Glide.with(itemView.context).load(image).into(binding.profileImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagePeopleViewHolder {
        val binding = ImagePeopleAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImagePeopleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImagePeopleViewHolder, position: Int) {
        holder.setImage(people[position])
    }

    override fun getItemCount(): Int = people.size

}