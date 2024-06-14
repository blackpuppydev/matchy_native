package com.blackpuppydev.matchy_native.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.api.response.DiscoverResponse
import com.blackpuppydev.matchy_native.constance.LandingPage
import com.blackpuppydev.matchy_native.databinding.DiscoverAdapterBinding
import com.bumptech.glide.Glide

abstract class DiscoverAdapter(private var list_discover: ArrayList<DiscoverResponse>,var type_page:String) : RecyclerView.Adapter<DiscoverAdapter.DiscoverViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): DiscoverAdapter.DiscoverViewHolder {
        val binding = DiscoverAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiscoverViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DiscoverAdapter.DiscoverViewHolder, position: Int) {
        holder.setView(list_discover[position])

        holder.binding.btnDiscover.apply {
            setOnClickListener {
                onResult(list_discover[position])
            }
        }
    }

    abstract fun onResult(result:DiscoverResponse)

    override fun getItemCount(): Int = list_discover.size

    inner class DiscoverViewHolder (var binding: DiscoverAdapterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setView(discover:DiscoverResponse){
            binding.apply {
                name.text = discover.name
                Glide.with(itemView.context).load(discover.imgProfile)
                    .into(imageProfile)

                when (type_page) {

                    LandingPage.DIS_PAIRING -> {
                        textDiscover.text = discover.pairing.toString()
                        iconDiscover.setBackgroundResource(R.drawable.ic_pairing)
                    }
                    LandingPage.DIS_POPULAR -> {
                        textDiscover.text = discover.follower.toString()
                        iconDiscover.setBackgroundResource(R.drawable.ic_follower)
                    }
                    LandingPage.DIS_NEED -> {
                        textDiscover.text = discover.activity
                        iconDiscover.setBackgroundResource(R.drawable.ic_live)
                    }
                }
            }

        }

    }
}