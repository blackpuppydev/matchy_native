package com.blackpuppydev.matchy_native.adapter

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blackpuppydev.matchy_native.databinding.StyleAdapterBinding
import com.blackpuppydev.matchy_native.model.StyleModel
import com.bumptech.glide.Glide


abstract class StyleAdapter (var list_style:ArrayList<StyleModel>) : RecyclerView.Adapter<StyleAdapter.StyleAdapterViewHolder>() {

    inner class StyleAdapterViewHolder (var binding: StyleAdapterBinding) : RecyclerView.ViewHolder(binding.root){

        fun setItem(item:StyleModel){

            binding.apply {
                listPeople.apply {
                    addItemDecoration(OverlapProfile())
                    val layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
                    layoutManager.reverseLayout = true
                    layoutManager.stackFromEnd = true
                    setLayoutManager(layoutManager)
                    adapter = ImagePeopleAdapter(item.listImg)

                }


                nameProfile.text = item.name
                timeContent.text = item.currentTime

                Glide.with(itemView.context).load(item.profileImage).into(imageProfile)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StyleAdapterViewHolder {
        val binding = StyleAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StyleAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StyleAdapterViewHolder, position: Int) {
        holder.setItem(list_style[position])

        holder.binding.btnStyling.setOnClickListener {
            onStyleClick(list_style[position].name)
        }

    }

    override fun getItemCount(): Int = list_style.size

    abstract fun onStyleClick(result:String)

    inner class OverlapProfile : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.set(0, 0, -50, 0)
        }
    }


}