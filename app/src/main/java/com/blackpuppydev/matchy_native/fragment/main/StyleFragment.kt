package com.blackpuppydev.matchy_native.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.adapter.StyleAdapter
import com.blackpuppydev.matchy_native.databinding.FragmentProfileBinding
import com.blackpuppydev.matchy_native.databinding.FragmentStyleBinding
import com.blackpuppydev.matchy_native.model.StyleModel


class StyleFragment : Fragment() {

    private lateinit var binding:FragmentStyleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentStyleBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            listStyle.apply {
                layoutManager = GridLayoutManager(context, 1)
                adapter = object : StyleAdapter(getStyle()){
                    override fun onStyleClick(result: String) {

                    }

                }


            }

        }


    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StyleFragment().apply {
                arguments = Bundle().apply {}
            }
    }



    //test
    fun getStyle():ArrayList<StyleModel>{

        val style = arrayListOf<StyleModel>()

        val peopleTest = arrayListOf("https://s3-alpha-sig.figma.com/img/0482/f6d5/14ec4122c9ac9116c73ea352120ec85d?Expires=1719187200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4" +
                "&Signature=KFr~CoVFtn01-oaYhp8xwIqzRzHeVacBD0OOJZKBJkhoGGJQTIv4e6Ycc-y~tIMLLyC-LY950u~rayM5yEKRSb1FPrEDK7ASk3lmurkJKSD33GJBs9S" +
                "wAriKp6bedWlBGRgBR9zZ3RPS8SvTpi7qEgy9ErIIMsMqZy2q6Egh4TU1HJDSmtMycZway8z6~GrYz8QAjFV-YcYN-GhbJO1ApO7IoW6PVRq4L0b5-a74KK6ME13U8Wbizf" +
                "PAfjcRPpU3LSZLT-QIqQglF27KCAK1t0WFoXw~e8EPoPk~R~HEmVtV2TckIZoCyt~K4l9ofg~PjleR7QJcL9HSsa~NJJNFbw__","https://s3-alpha-sig.figma.com/img" +
                "/0482/f6d5/14ec4122c9ac9116c73ea352120ec85d?Expires=1719187200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=KFr~CoVFtn01-oaYhp8xwIqzRzHeVacBD0OOJZKBJkhoGG" +
                "JQTIv4e6Ycc-y~tIMLLyC-LY950u~rayM5yEKRSb1FPrEDK7ASk3lmurkJKSD33GJBs9SwAriKp6bedWlBGRgBR9zZ3RPS8SvTpi7qEgy9ErIIMsMqZy2q6Egh4TU1HJDSmtMycZway8z6~GrYz8QAjFV-" +
                "YcYN-GhbJO1ApO7IoW6PVRq4L0b5-a74KK6ME13U8WbizfPAfjcRPpU3LSZLT-QIqQglF27KCAK1t0WFoXw~e8EPoPk~R~HEmVtV2TckIZoCyt~K4l9ofg~PjleR7QJcL9HSsa~NJJNFbw__")

        val style1 = StyleModel("Shop","3 minute ago","https://s3-alpha-sig.figma.com/img/0482/f6d5/14ec4122c9ac9" +
                "116c73ea352120ec85d?Expires=1719187200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=KFr~CoVFtn01-oaYhp8xwIqzRzHeVacBD0OOJZKBJ" +
                "khoGGJQTIv4e6Ycc-y~tIMLLyC-LY950u~rayM5yEKRSb1FPrEDK7ASk3lmurkJKSD33GJBs9SwAriKp6bedWlBGRgBR9zZ3RPS8SvTpi7qEgy9ErIIMsMqZy2q6" +
                "Egh4TU1HJDSmtMycZway8z6~GrYz8QAjFV-YcYN-GhbJO1ApO7IoW6PVRq4L0b5-a74KK6ME13U8WbizfPAfjcRPpU3LSZLT-QIqQglF27KCAK1t0WFoXw~e8EPoPk" +
                "~R~HEmVtV2TckIZoCyt~K4l9ofg~PjleR7QJcL9HSsa~NJJNFbw__", peopleTest)


        val style2 = StyleModel("Nattawut","5 minute ago","https://s3-alpha-sig.figma.com/img/2391/f0f5/7528731391cc5" +
                "937bc89335cceb229f3?Expires=1719187200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=PKxsdd-3CvsRd1nKuhN0bMviBv2RXVj4znrXhkWmw-0a" +
                "T9fa6GEph58jbQRFMqDvPq0MpYimvFrg0DHEBFAEciMbdR~ObeItr3uGowm4WhhybYjsWEO8hk3D72lqJyWeDT1dx3nvUasT8W2wNTqXqgulO9BeK2rWMpl6PW3N" +
                "XEZRgFI06O6yVdgZbGwx7gsLrSRLhsNgUcob5xnIvzkofgaSFViSu9c7IShsWT2fulb1tKKfp84npQnjlccw1neCRiKDfOShcRDnWquvixEzenxR-JjfexgTtohx" +
                "QbEKc1U2Bta7z7zmIZBBqwF~~BMk1BStP5q2B-56agxBngi-Pw__",peopleTest)


        val style3 = StyleModel("A","11 minute ago","https://s3-alpha-sig.figma.com/img/7e23/1629/35ef414647345861a8e17" +
                "2e06931fb66?Expires=1719187200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=GQ6VUYYPMnWFvoIvOiqm-0qNnS1uCj4arZ76dTnvqhG3~gldPwWlzT6Ij" +
                "-5Z8IaUMa6AtMmToWUC1zZ-AYoFEsbw0RaUBossnIXIA4PqYj0HrIKcMyA2tviU5x90T2bIu~Tsd8T275u0tclvG8fBDFCyuAZLThf4DgsksYr0lg51vf1GUYylGH1rR3l9m8v" +
                "-f5Jg7s3ZSIppuuc6pB3SCuqN8u1djD~la9G4IhraZPM0PkoQsrH~Ep2iyKcSK-fumGBaf3OfEqK1g~FftX7yBeUR3gkiSBM3inah35J4TPHOa1YlCsIbvcGYDtKoEU3Jie" +
                "C8-h7mhoadzmiM9TohEg__",peopleTest)


        val style4 = StyleModel("B","24 minute ago","https://s3-alpha-sig.figma.com/img/8e93/6a04/395db262bf99d95325bc095e8c40" +
                "5278?Expires=1719187200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=caiLHAj6EYpj2ULT1JtCYsTZ9737Tbfs113ABV7gdW5D8gEunvL7dQ1LznBp6DeFNvmpds" +
                "F~lHkxcqLacBjW~xGaH~mXd7LWTORBRzTvju0oYTcZMJX5BTZySwMSdob9G8LsqjPjEeuV8EX0r1xvfDhCKPR8GyNE6Bv47aqxOfEAEeKC9-LeGFQurN5P94oQOBFPsXAla2Q5kefYb" +
                "Gt9n53-GwF~nomDAJ-HtuMYKqr-lMy34HqitfrhE~tcV1otNcNNzyfYsKv-ETqG56a~hl2DQYbmgYAwlJ3jmdL-b50P3HZc8iAjVhgP0Nu5n~4C711OJ-u11h8G1QeLf51NZg__",peopleTest)


        val style5 = StyleModel("C","30 minute ago","https://s3-alpha-sig.figma.com/img/3846/fd7a/261fae0468920e85a5c18c6c7" +
                "5ef09bd?Expires=1719187200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=f1J3qF1O7-m613C3HGbc1g1bk-R3IT8kCImACUUSdPlHXCq36uuCbd-D7BumCaOG5" +
                "81u0yhCRW9WDJK44Ik1wEpGCZlYEqcsfdbd2PeDqVlZ7dS1aRsEx264lpDxmYvczFBSyfiAjJ-jpPpQE4W02KqPlTmXb~Q~cRsEtSLrV2GpYE8BoPUVsh8C~nJdpjNetwdMgt7XFB" +
                "JBs3R-8cE~mDKm8Hu6P9hwQi6vofgMcADv-xEVB~nx1fRtdAm3DJaZjh5PueaXSEC9o1abubURCnYShGDRmb6XAROTB8H58gBj3hjo~MWvrMFXEzhak~lwOvQGcj6NJLjgHMRggFT8Hg__",peopleTest)


        val style6 = StyleModel("D","40 minute ago","https://s3-alpha-sig.figma.com/img/b77b/bcb5/f980eeac48110ce5a21aa148" +
                "67995f04?Expires=1719187200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=MOCWlpDUtIKq7igVcShYC6TV85w9xTHUASBq-OYKm2shqVl-fyDcUPcyc45Ez24J" +
                "VWbYXCiOkx7GyuF6sue7W9vjWL7HM7m4fn7dPzEzfmDDLXA4qh8p1Z53EUmz9rYLW5drI~P5ogL4NCT3rQltx5lQ8Z8IZrkgygx8LKeuvwwY9ZAdo4wnhd39lpPVCAMgNf-7nBLt" +
                "A3ZL7NzYVwIJNIITkXmZeBAhN75zDCZhg2TeqlCmhNt0yLp9CX8eVxvxAVvjOKUl8BstCxWAXPPkXVd8KPWk~X7ZLBFygjlG6usgokR4ks1RaZopPa-SoejRxj5CNv~KJWdOV5sLieBaIA__",peopleTest)


        val style7 = StyleModel("F","50 minute ago","https://s3-alpha-sig.figma.com/img/001c/ee8f/a1eaf7632c3c16b85e22af6e3" +
                "f4c0d24?Expires=1719187200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=MHq2JWlnPoUXr7IXpv1T~Di-32bgqVRxHjscU6Tf1VNOS4dIQNfzjvv1j1tvy" +
                "6keedVdpmi5l12SDSL53pZHjR3X6MnW38OQGSmEmHPe5fR3ynF2iQ8j0~cpC2t3DZLYIfLIlrD-CeZDDFKeZQIf~i61yVqRgmEOmMm0zBKWFVPzsFEsjzrMsiHsfVP3sPED4I1Iqgodx" +
                "QzDVq4xQ-xxijQw0dOa0-fMT39YPD1bbdgf6X-lhDKtY33Sv5u-8qhu7rM2WEboXpAtb1PJ-y59YBSW-E-icq0dzNsxT9NlfMPWN7T-pCnI6chQMtOaZkXR9I25gmQWBcQY3muXQLI51w__",peopleTest)


        val style8 = StyleModel("E","1 hour ago","https://s3-alpha-sig.figma.com/img/f0a3/3761/69c4da5e78338d8bb6dc30ecc0564f18?Expires=" +
                "1719187200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=IMDutpUdu4S6cNG1e-z~EeAn6L4kAnD13tnuWFlectD9K7QCnzLxoBE~KsFa4hnRlwIflf3pNKL70QzylwOdz84-mNoQDxz0H~" +
                "CcYGMOb3xwITV5KpN8MQG3euqQ-h~tTmOC9XFbbwZS3Ip-9c3A01XfgBiat1oBBecAymugztBNHazXIbsamAJPFLvo1FIhJkwavpEkYVwNhIe5dub-K5hIPGWaWMANN0ZH-Wxxdk~7KO2p-TpUOlL" +
                "wP8yUKb7kFE2oDz~jg9mpNGNhN4b6QCTGZJLcz1aIMfsY8sCSV~yHU29gJec7OLDbRiCAw-a1-gfP01FTtRAJz2nkQJmdeg__",peopleTest)


        style.apply {
            add(style1)
            add(style2)
            add(style3)
            add(style4)
            add(style5)
            add(style6)
            add(style7)
            add(style8)
        }



        return style
    }
}