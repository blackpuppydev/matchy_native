package com.blackpuppydev.matchy_native.fragment.first

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.constance.PageImage
import com.blackpuppydev.matchy_native.databinding.FragmentImageProfileBinding
import com.blackpuppydev.matchy_native.dialog.ImageDialog
import com.blackpuppydev.matchy_native.listener.FragmentEvent
import java.lang.ClassCastException


class ImageProfileFragment : Fragment() {

    private lateinit var binding:FragmentImageProfileBinding
    private lateinit var listener: FragmentEvent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentImageProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as FragmentEvent
        } catch (e: ClassCastException) { }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnAddPhoto.setOnClickListener {
                object : ImageDialog(requireContext()) {
                    override fun onPage(page: String) {
                        when (page) {
                            PageImage.CAMERA -> {
                                dismiss()
                                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                                startActivityForResult(intent, 1)
                            }
                            PageImage.ALBUM -> {
                                dismiss()
                                val intent = Intent(
                                    Intent.ACTION_PICK,
                                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                                )
                                startActivityForResult(intent, 2)
                            }
                        }
                    }
                }.show()
            }
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode){
            1 -> {
                if(resultCode == RESULT_OK && data != null){
                    val selectedImage = data.extras?.get("data")
                    binding.imageProfile.setImageBitmap(selectedImage as Bitmap?)
                }
            }
            2 -> {
                if(resultCode == RESULT_OK && data != null){
                    val selectedImage = data.data
                    binding.imageProfile.setImageURI(selectedImage)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ImageProfileFragment().apply {}
    }
}