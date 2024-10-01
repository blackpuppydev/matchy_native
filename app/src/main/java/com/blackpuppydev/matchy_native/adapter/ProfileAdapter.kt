package com.blackpuppydev.matchy_native.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackpuppydev.matchy_native.databinding.ProfileAdapterBinding

abstract class ProfileAdapter(var profile:ArrayList<String>) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    inner class ProfileViewHolder (var binding: ProfileAdapterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setProfile(item:String){
            binding.title.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding = ProfileAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.setProfile(profile[position])
        holder.binding.btnSetProfile.setOnClickListener {
            onSelected(profile[position])
        }
    }

    override fun getItemCount(): Int = profile.size

    abstract fun onSelected(title:String)
}