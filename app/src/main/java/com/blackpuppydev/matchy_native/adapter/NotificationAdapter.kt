package com.blackpuppydev.matchy_native.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackpuppydev.matchy_native.api.response.NotificationResponse
import com.blackpuppydev.matchy_native.databinding.NotificationAdapterBinding

abstract class NotificationAdapter(var list_notification:ArrayList<NotificationResponse>): RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    inner class NotificationViewHolder(var binding: NotificationAdapterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setItem(notification:NotificationResponse){
            binding.apply {
                nameProfile.text = notification.name
                titleNotification.text = notification.title
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding:NotificationAdapterBinding = NotificationAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.setItem(list_notification[position])

        holder.binding.btnNotification.setOnClickListener {
            onSelectItem(list_notification[position].id.toString())
        }
    }

    override fun getItemCount(): Int = list_notification.size

    abstract fun onSelectItem(id:String)


}