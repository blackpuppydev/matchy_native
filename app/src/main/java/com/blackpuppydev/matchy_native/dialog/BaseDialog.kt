package com.blackpuppydev.matchy_native.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.blackpuppydev.matchy_native.api.repository.UserRepository
import com.blackpuppydev.matchy_native.databinding.DialogBaseBinding

abstract class BaseDialog(context: Context) : Dialog(context) {

    private var binding:DialogBaseBinding = DialogBaseBinding.inflate(layoutInflater)

    init{
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(binding.root)
        setCancelable(true)

        binding.btnCancel.setOnClickListener {
            onCancelClick()
        }
    }




    private fun setMessage(title: String?) {
        binding.title.text = title
    }

    fun show(title: String?){
        setMessage(title)
        setCancelable(false)
        show()
    }

    abstract fun onCancelClick()

}