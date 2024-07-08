package com.blackpuppydev.matchy_native.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.databinding.LanguageAdapterBinding

abstract class LanguageAdapter: RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>()  {

    inner class LanguageViewHolder(var binding: LanguageAdapterBinding) : RecyclerView.ViewHolder(binding.root){

        fun setItem(language:String){

            binding.apply {
                nameLanguage.text = language
                flag.apply {
                    when(language){
                        "English" -> setImageResource(R.drawable.us_flag)
                        "Thai" -> setImageResource(R.drawable.th_flag)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val binding = LanguageAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LanguageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.setItem(getListLanguage()[position])

        holder.binding.btnLanguage.setOnClickListener {
            onSelectLanguage(getListLanguage()[position])
        }
    }

    override fun getItemCount(): Int = getListLanguage().size


    private fun getListLanguage():ArrayList<String>{
        return arrayListOf("Thai","English")
    }


    abstract fun onSelectLanguage(languageCode:String)
}