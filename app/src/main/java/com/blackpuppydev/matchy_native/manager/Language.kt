package com.blackpuppydev.matchy_native.manager

import android.content.Context
import java.util.*

class Language {

    companion object {

        fun setLanguageApp(languageCode:String,context: Context){
            var language:String? = null

            when(languageCode){
                "English" -> language = "en-US"
                "Thai" -> language = "th-TH"
            }
            val resource = context.resources
            val configuration = resource.configuration
            val locale = Locale(language)
            Locale.setDefault(locale)
            configuration.setLocale(locale)
            resource.updateConfiguration(configuration,resource.displayMetrics)

        }


        fun getLanguage():String{
            return Locale.getDefault().language
        }
    }


}