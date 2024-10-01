package com.blackpuppydev.matchy_native.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blackpuppydev.matchy_native.api.repository.UserRepository
import com.blackpuppydev.matchy_native.api.response.ClosetResponse
import com.blackpuppydev.matchy_native.api.response.DiscoverResponse

class ClosetViewModel : ViewModel() {

    var itemCloset = MutableLiveData<ArrayList<ClosetResponse>>()
    var listTestCloset:ArrayList<ClosetResponse>? = null


    fun getCloset(username:String?){
//        Log.d("ClosetViewModel : " , username)

        if (username != null) {
//            UserRepository.newInstance().getUserCloset(username){
//                if (it?.size != 0){
//                    listTestCloset = it as ArrayList<ClosetResponse>?
//                    itemCloset.postValue(listTestCloset)
//                }
//            }
            itemCloset.postValue(getTestCloset())
        }
//        if (username.isNullOrEmpty()){
//            itemCloset?.postValue(null)
//        } else {
//            itemCloset?.postValue(listTestCloset)
//        }

    }



    //for mock
    private fun getTestCloset() : ArrayList<ClosetResponse>{

        val itemCloset:ArrayList<ClosetResponse> = arrayListOf()


        val closet1 = ClosetResponse("https://s3-alpha-sig.figma.com/img/9605/4901/9c4bc" +
                "9855881cd15b453b4d1f966e6ba?Expires=1719792000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&" +
                "Signature=nPkloCYb1l25LBgG1Gj0YsJegRMT6aDSw8EMMt6Kc32ScbAjS-FxVPYpUu60CsBP11ByY3b6" +
                "OIOrh9aNlvcqQM5sP8iSCRfDV9V2eTsHQjiW1LDqAxcAa4eMTWhTOMJa8vujDKwl0WTXFb8~T8YuEs6UJ2O" +
                "GrVvXnweARweYpySxaZJOK3GPScGIUCvG-1Bc5KDC50KQP7og2KgVtYj7otWEtP145-ZdmQC0ZibnrnsfBbi" +
                "OigmmA8h6Yl~vyBFFUIWO2yUsnR5-eVxT4NleKFd0dDH36pFc3se46y-j-ptG3bZi5SHFve3IdD~qAmL8uy" +
                "BhyePVqtb91a-drZrTVg__","pink pants","trousers",false)

        val closet2 = ClosetResponse("https://s3-alpha-sig.figma.com/img/9f9c/df73/bf04264827b" +
                "9723d5bbc85b8f6a9a235?Expires=1719792000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=" +
                "Q6alfxx1o-D3Na8m~q0ADtBxB8cRsuNQe0AWdFAZNFtrIByfNx~fyYiyeDWGjJtZ48P5G0KEHckX1Xm8615lx" +
                "IUqZaFQ1okFSKZh6M0yS43UqEhIWkeirrMxgDG9aaATfbDntxgpmNL5ZZddhZ6MdGNCXev4CPkWCVqKMuSsbeu" +
                "5qfa7ZZRRShcJQa2rfa2aIRUTPV4i~xa8djmsWolZybRtt5wW0Wne-l-HcwiRnqJJvhxHuv8OQyQVG9OqwHJTu" +
                "--xo61DuLtqZUXigZTldZhUCAhGwjdCcCe5NyUfnKY4c7kKar4TRaA7X9f~gPo6U7bQujWJem-VsemdZb-Y-Q__",
            "black shirt","shirt",false)

        val closet3 = ClosetResponse("https://s3-alpha-sig.figma.com/img/b81a/d440/3cf64d6847c51c" +
                "2b99feae921c332fa5?Expires=1719792000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=jAdYwc8" +
                "Py2wGHieDleUvtoMF21ZWV-YwERt6zUV~pveuVD2D9~8goKTLqBF50cYxnfhYGeu2Dk3~xXAtGTc4pcVhwz9jhacj" +
                "7YV4mIsvSiUlXIWCNnXsscue-ftseuPszOezG94ve4Bces~VQTumf~MYXnKvtDFbjgdlhbuTe5ND-KzMei6QTuSBb" +
                "WX6ZdPthUft1anzGwrn~39v-TiQUq4ap9YwqQ6T81ytGuSTAW5AtXVYyLWX9nhrodnUhzazkeiTArcvoDV3qTqBG~l" +
                "Vh60eSCe0uQ1SE19~a--8V7lTHe99nLgiEF5I8q09GjKHBaYYiIKjl4~-Pjmp1CJZ1g__","Cream shirt","shirt",false)

        val closet4 = ClosetResponse("https://s3-alpha-sig.figma.com/img/979c/1ee7/5d2ddca76374ba47fe" +
                "03c084d079993c?Expires=1719792000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=H8m4kHKS-SpIx7Y" +
                "nXgrk74fyjdHNawhDBbTdk-bEgsLakKlbPvMD3u9yUU~PdS1Ij98HXFrzKBIIbozxgfTi~CX8xi2OsuVelb42o1CsRqp" +
                "JXCVvAybeSXDAl7ROqVF-0amrPBf~rQflJRmphrXD6RC8hBHHOxUhKoxmQPAKfum8DahH6DKhJVQ7CpQZBot2bo7PVre" +
                "ywylqG0AuHmDndOAsDc22rCtX7W7TAiWcdKDg70insEUO-WTbfE3pxw6VFa9KQUI2EIdCFlkXSMU0lcTD0mwtuj31LTdYH6" +
                "3SFP5jXNcna-xfpT-JTUN1lTk9DosPhRQtcCeDfUimtEsB6Q__https://s3-alpha-sig.figma.com/img/979c/1ee7/" +
                "5d2ddca76374ba47fe03c084d079993c?Expires=1719792000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=" +
                "H8m4kHKS-SpIx7YnXgrk74fyjdHNawhDBbTdk-bEgsLakKlbPvMD3u9yUU~PdS1Ij98HXFrzKBIIbozxgfTi~CX8xi2OsuVe" +
                "lb42o1CsRqpJXCVvAybeSXDAl7ROqVF-0amrPBf~rQflJRmphrXD6RC8hBHHOxUhKoxmQPAKfum8DahH6DKhJVQ7CpQZBot2bo" +
                "7PVreywylqG0AuHmDndOAsDc22rCtX7W7TAiWcdKDg70insEUO-WTbfE3pxw6VFa9KQUI2EIdCFlkXSMU0lcTD0mwtuj31LTdY" +
                "H63SFP5jXNcna-xfpT-JTUN1lTk9DosPhRQtcCeDfUimtEsB6Q__","blue shoes","shoes",false)

        val closet5 = ClosetResponse("https://s3-alpha-sig.figma.com/img/f1c8/187f/5de17f4586499f62c3a89ae9fb05327c?Expires=" +
                "1719792000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=CnXXulMprfEen4moSweJMfTRTRs1Y4U6Dx4WF6~O~ylvg8NpgPTa4y5m8e0K" +
                "QnFQYiFTTkDGx89eCuGNkf~IJEMCvF~qabXeSYIvNRUvNRyd0uf3nnj8dVTCai0wC1QcW4JgrK3OrxrBbqdj8dphzLCBGXl9xiYJKAlvJSt4aJE8JM0LRXOXX83LWJqb7-niuGzoYv-arSxsvDCZzFn4JelyeSUyxRYDf5Xe0RMk--gz~MpgoGDH4nku5TDWetlfwFawTig3nbcOnrA9xM~qvQbzr~Y9-yoRf5lODXTlGUKQfl-MCnUE1jH6dhl08zOl~iOKaiG~BfUv3GJcJZhAGg__","white shirt","shirt",false)


        itemCloset.apply {
            add(closet1)
            add(closet2)
            add(closet3)
            add(closet4)
            add(closet5)
        }

        return itemCloset
    }






}