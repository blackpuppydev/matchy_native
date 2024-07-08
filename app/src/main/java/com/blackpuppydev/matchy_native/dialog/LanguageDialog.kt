package com.blackpuppydev.matchy_native.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.recyclerview.widget.GridLayoutManager
import com.blackpuppydev.matchy_native.adapter.LanguageAdapter
import com.blackpuppydev.matchy_native.databinding.DialogLanguageBinding

abstract class LanguageDialog(context: Context): Dialog(context) {

    var binding:DialogLanguageBinding

    init {

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding = DialogLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCancelable(false)

        binding.listLanguage.apply {
            layoutManager = GridLayoutManager(context,1)
            adapter = object : LanguageAdapter(){
                override fun onSelectLanguage(languageCode: String) {
                    onSelectLanguages(languageCode)
                }
            }
        }
    }

    abstract fun onSelectLanguages(languageCode:String)


}