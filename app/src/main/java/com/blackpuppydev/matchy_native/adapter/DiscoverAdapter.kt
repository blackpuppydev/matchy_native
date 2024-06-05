package com.blackpuppydev.matchy_native.adapter

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.api.response.DiscoverResponse
import com.blackpuppydev.matchy_native.databinding.DiscoverAdapterBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

abstract class DiscoverAdapter(var list_discover: ArrayList<DiscoverResponse>?) : RecyclerView.Adapter<DiscoverAdapter.DiscoverViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): DiscoverAdapter.DiscoverViewHolder {
        val binding = DiscoverAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiscoverViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DiscoverAdapter.DiscoverViewHolder, position: Int) {
        holder.setView(list_discover!![position])

        holder.binding.btnDiscover.apply {
            setOnClickListener {
                onResult(list_discover!![position])
            }
        }
    }

    abstract fun onResult(result:DiscoverResponse)

    override fun getItemCount(): Int = list_discover!!.size

    inner class DiscoverViewHolder (var binding: DiscoverAdapterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setView(discover:DiscoverResponse){
            binding.apply {
                name.text = discover.name
                percent.text = discover.pairing.toString()
                imageProfile.setImageURI(null)
//                imageProfile.setImageURI(Uri.parse(discover.imgProfile))

                Glide.with(itemView.context).load(discover.imgProfile)
                    .into(imageProfile)


//                Glide.with(this).load(item.hrefImage)
//                    .into(findViewById(R.id.item_image) as ImageView?)
            }

            Log.d("DiscoverViewHolder : " , discover.imgProfile)
        }

    }
}