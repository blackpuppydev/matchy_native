package com.blackpuppydev.matchy_native.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackpuppydev.matchy_native.databinding.HotTopicAdapterBinding
import com.blackpuppydev.matchy_native.model.HotTopicModel
import com.bumptech.glide.Glide

abstract class HotTopicAdapter (var list_hotTopic:ArrayList<HotTopicModel>): RecyclerView.Adapter<HotTopicAdapter.HotTopicViewHolder>(){

    inner class HotTopicViewHolder (var binding: HotTopicAdapterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setItem(item:HotTopicModel){
            binding.apply {
                Glide.with(itemView.context).load(item.image).into(imageTopic)
                titleTopic.text = item.title
                timeAgo.text = item.time
                countView.text = item.currentView.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotTopicViewHolder {
        val binding = HotTopicAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotTopicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotTopicViewHolder, position: Int) {
        holder.setItem(list_hotTopic[position])

        holder.binding.btnTopic.setOnClickListener {
            onSelectHotTopic(list_hotTopic[position].title)
        }

    }

    override fun getItemCount(): Int = list_hotTopic.size


    abstract fun onSelectHotTopic(hotTopicSelect:String)


}