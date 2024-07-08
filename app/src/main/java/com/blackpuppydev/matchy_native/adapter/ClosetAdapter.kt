package com.blackpuppydev.matchy_native.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackpuppydev.matchy_native.api.response.ClosetResponse
import com.blackpuppydev.matchy_native.databinding.ClosetAdapterBinding
import com.blackpuppydev.matchy_native.databinding.DiscoverAdapterBinding
import com.bumptech.glide.Glide

abstract class ClosetAdapter(var listCloset:ArrayList<ClosetResponse>): RecyclerView.Adapter<ClosetAdapter.ClosetViewHolder>() {


    inner class ClosetViewHolder(var binding: ClosetAdapterBinding) : RecyclerView.ViewHolder(binding.root){

        fun setView(closet:ClosetResponse){


            binding.apply {
                Glide.with(itemView.context).load(closet.image).into(imageCloset)

                btnCloset.setOnClickListener {

                }

                btnPick.setOnClickListener {

                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClosetViewHolder {
        val binding = ClosetAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClosetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClosetViewHolder, position: Int) {
        holder.setView(listCloset[position])

        holder.binding.btnCloset.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = listCloset.size

    abstract fun onSelectItem(closet:ClosetResponse)


}