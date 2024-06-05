package com.blackpuppydev.matchy_native.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.blackpuppydev.matchy_native.constance.PageImage.ALBUM
import com.blackpuppydev.matchy_native.constance.PageImage.CAMERA
import com.blackpuppydev.matchy_native.databinding.DialogImageBinding

abstract class ImageDialog(context: Context) : Dialog(context) {

    private var binding:DialogImageBinding

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding = DialogImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCancelable(false)

        binding.camera.setOnClickListener {
            onPage(CAMERA)
        }

        binding.album.setOnClickListener {
            onPage(ALBUM)
        }

        binding.btnExit.setOnClickListener {
            dismiss()
        }
    }

    abstract fun onPage(page:String)






}