package com.blackpuppydev.matchy_native.fragment.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.adapter.CategoryAdapter
import com.blackpuppydev.matchy_native.adapter.HotTopicAdapter
import com.blackpuppydev.matchy_native.databinding.FragmentCommunityBinding
import com.blackpuppydev.matchy_native.dialog.LoadingDialog
import com.blackpuppydev.matchy_native.model.CategoryModel
import com.blackpuppydev.matchy_native.model.HotTopicModel
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel


class CommunityFragment : Fragment() {

    private lateinit var binding:FragmentCommunityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCommunityBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {

            val picSlide = arrayListOf<SlideModel>()
            picSlide.add(SlideModel("https://s3-alpha-sig.figma.com/img/9541/5db5/28ed8cc1b4491d846fe56e9ced086387?Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=AfEXuyoyO7ruG4pRiB164A8h4Xccs0CJa62wC4qKSpXQzl0XzlRHe7wanWM-" +
                    "etn4kFaxdY5T4KVF6UDb4DVihn5UG4Bc6PsuU7Xr7f7UHMYQxXifLXI7qx4RYIeKxr7zB3dqxMVj5aQUp93U6W8jB6Af2aIURkzKYMdfhbzG9EH6Kk9edFp44yFNAlCHI2cPFnWNJEu0cKWQIFD-W~BwZV50JS0yW4dZF6BItmWssLJbfqtIFTohVqcqjs3gVnXHLiyG-NTU0tj6jLcS8nlnUyxzkiI940eqwobk" +
                    "K5IF3q~ETB~aKrebbmbkXijBBSL1ywF9dD-Qx3lBZa-TEKvo-A__", ScaleTypes.FIT))

            picSlide.add(SlideModel("https://s3-alpha-sig.figma.com/img/c6a8/62d0/b9661a86283c131b6abd2eef34926913?Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=fGs-2lXqgaN47wXVmfLZ34nUOceAiTAuU~ACCAExL9Joqr2kF1FfMbmAuSiFa7jLM6inLy~3" +
                    "-QMZdAzFCI2PiIrrGkkcuA1~0HE1WvtEv2Y7YEsZT-EdmDzeaqpiWi1c5YYu7dlZy5N5x6eSVwWvXp3lnKJ4N5b8r-~EVVrEmDmYgmBkmaJGOeAxAqKgUQxg7mLGLlc3zvdslENoKfA6r2S3cjxSV~vcCtKslxbbEI32eCRWdfZUMMEvkOL1qKME~HyESYDUqjN3rHSd7TQVO-laU-hnWGYLD-kQI-a3EwxglLQdNP4Foe4" +
                    "QnHBZ3HzK6oiQoWDdYIo-5hfV5TYqJg__", ScaleTypes.FIT))


            slider.setImageList(picSlide,ScaleTypes.FIT)



            listCategory.apply {
                layoutManager = GridLayoutManager(context, 3)
                adapter = object : CategoryAdapter(getCategoryItem()){
                    override fun onSelectCategory(categorySelect: String) {
                        //do something
                        Log.d("onSelectCategory",categorySelect)
                    }

                }
            }

            listHotTopic.apply{
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                adapter = object : HotTopicAdapter(getHotTopic()){
                    override fun onSelectHotTopic(hotTopicSelect: String) {
                        //do something
                        Log.d("onSelectHotTopic",hotTopicSelect)
                    }
                }
            }



        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CommunityFragment().apply {
                arguments = Bundle().apply {}
            }
    }



    //mock
    fun getCategoryItem():ArrayList<CategoryModel>{

        val categoryModel = arrayListOf<CategoryModel>()

        val cat1 = CategoryModel("https://s3-alpha-sig.figma.com/img/4ba3/4fa3/c0b59cc5c013e64b63b37c45443a4b88?" +
                "Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=pzJSZgJAUe0EdImHCWzfyVfkQFCtUKDtNflYy4-C5WmfZuY" +
                "~JAvsO5LIB6MGnhUKlwKr6s1U4Ba0YQlRe5q66yeXRzAKOfHgUCA~KzsMBxnwyuyWXZnmZrDwX-psOOaR3t1mx7ghGwSmx3yJGk7J6XatMPfi0" +
                "pimPtk92d9nmm5USqerbk2iJOBb5fmmziiENdkizgHPSwqVrYzb-Mmzn5D3TUoSRPCvYAwiv0pR-KDt1XCZlzhimJSNdpAY1ZQvuyJhoGNwytOgGr" +
                "Yrt2HB4AiYgsjF7LdX531JWdNoKTbGR6VCRZ-GYS9U4axvXDf-zANbxljdfyFjJ-Hym7vOHQ__","SHARE YOUR STYLE")

        val cat2 = CategoryModel("https://s3-alpha-sig.figma.com/img/65e1/eb59/729a4cdeb7c4bb0ceed17c3c3257b55a?" +
                "Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=CqiNkuth4NMllxPLiTvETRzX41xT-JlzYFtzqhJ~PxHdC~" +
                "tGErx6jy99RpoVCwx01UoTMCO3q4cZlTsvyBFbuNGLsGAAGvCa6D-THjpyHbOiykYqhC2mXmy9SgLpYbgT-1HbrqQJSgnA9znJ1Er-7hPUN7o3v" +
                "cAqL3OzYcvm0S5FWi8XlzqSkcfhP5ShkSW2xWNlQJeREIXMROiqjxrfhX24e6N5owIHUFeFmKizUalJ3ZID7cz4DxAoV03fYnKVh~pJK9tHwC8Ujy" +
                "9RR1Xxwk2GoO4v3sZTxrtULBd2y7i1nqxBc1KxCYJQN~I878sBvdt1NjORfaTp0~OnHOfGeg__","MARKET PLACE")

        val cat3 = CategoryModel("https://s3-alpha-sig.figma.com/img/ae3d/5f42/e1e369660b37af3302b20dcf096a1437?" +
                "Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=bfr9VP5MRYnYBN1Tr-AwU6SVDFME8~kthtUCJxJY-f0OT7GXmZTUhe3b-" +
                "X~LRNxBsUO2eF5uKlef1E80QmMYIb53VPEJ36wbY3k4lN9jTKXQX1qCD-gKE-q8C88fGSibSsjcbD9QkRRzQTzH-BEOMr7~iqOChWUK-2unuE9QdHxuHAmz3O" +
                "97MFW-VdhRHCLGEmpCV6qLB2HGqZp6PhYZvBu9Nf~p6JJeF1p41yKbTmI0ck7Cb~FPh3cVXPZEvyuLKlXPvAGlIylhPQEL-cIh2T6ZRplN-9a8PXdC-AUO9UlF" +
                "lci-haJV4UGxPAuS5R~EDslx8mGjdoszbI6il4N-Tw__","ECO FRIENDLY BRANDS")

        val cat4 = CategoryModel("https://s3-alpha-sig.figma.com/img/26e1/f53d/13a05831edd9ff6651e4f21d602d61d2?" +
                "Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=IW20SlsdxmMqkTQptLaVh3sAsa8M1PFCP482BJGZygGdZh" +
                "6l9DH66xgDNUle9X65Kpc0v4CuIwhEebeqkDNE6ufqwXskFSbSAAu75QDzlRTcXHeA9JoFJZveaH4NwnHCjfn5in2zzZk9INuBYMTlKQXfngftwa" +
                "17nCAf-FaBFHlGktMrVRdhAalIjGXRuhuEmWE77JvyAX3tsqK2PBwdYI53xVHMzBaM3srPs9jDiGjbvxLhTKhl1jxVBiIs8Izy6CrkqigRixGDKlp" +
                "OhzuJ6s1hQWzZxXhCb7cPlwZh1gwijwhnjpZH0nFpi5jLTjTInNmVoUalPL39sLAmX024BQ__","DRESSING TRIPS")

        val cat5 = CategoryModel("https://s3-alpha-sig.figma.com/img/ba0f/d1a3/4b41c832ab5f13bf76c2568b636bf67c?" +
                "Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Far8fru4sy3lsPcP2bHMOHyiVk5-R~Awh~mjyiKPG69K2Ay" +
                "KHXFQhdwSNNi~9gr0Gn-aUjdUka0kFewR7z~nNyKgk-cYSXat9Wx0P4qlSMEtioWpkxPwartKlrovUI2-5BaOLB8~ZAXYoSi-CZE-qHkIPxcxI9" +
                "CqI8NU7yGwX9HDvOV584Fbx8DuP0YY5o~uD8lEGZ4~k4kk-x4Z9NVpIySbQ9~P1IL5mLh7CafgkL3dtplP2lUn4badV5-QbOq~R9sjmTnLbTsjeD" +
                "uMraBL3MEbwqF0QL66UdutbHOwRnpNhoTujaYIisawEQzAEt68o9Puu8AeJ1PoA9~6QTsRfg__","EMPOWER")

        val cat6 = CategoryModel("https://s3-alpha-sig.figma.com/img/5f80/5de4/882f381842da1a1561c3bd78d0d20434?" +
                "Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=o0SE0xe6OPUHj3-xEYkFWkrHLWOgxFOwjePtG4hU9j" +
                "7wUzWuRbIkD4Y6ULfM~REMDDxW6ASjvQ2KzYbYNFvzA-JTYdt0v-erZEFj9~u4YjrHojz38eH1FrakEzghE8d3is14khwKIVu~i5HePFRLAW" +
                "9TR20b2rpELMLWW09QRYkNT-DHg9ZUxsjbpFYghYGnv4VbAy4SsndvYU7FOVUbV0vLO38ztHs7ZhrGF3JLFozgBrCRLTrkCDEmV~XKaJuaEYxw" +
                "RjDoO315FufIJLJy1-PsGACKrTg16OLSwCK-Eq0vYLw-LJr5qXN8dpT~3OGqCQ968Hy0U2KI15N3wFLt0A__","SAVE AND SEW")


        categoryModel.apply {
            add(cat1)
            add(cat2)
            add(cat3)
            add(cat4)
            add(cat5)
            add(cat6)
        }

        return categoryModel

    }


    fun getHotTopic():ArrayList<HotTopicModel>{

        val hotTopicModel =  arrayListOf<HotTopicModel>()

        val hot1 = HotTopicModel("https://s3-alpha-sig.figma.com/img/0c55/5909/f147a0657b593cf7ac5cd0faa6f14c72?" +
                "Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Hb4JklxebdHMnoC8k1YWRMqWzjKDRBlSYsCSx5261RCZ" +
                "TvWFKlxxLoeROrn2XOHnse78NW0dyt7yk~IxLuBhEoYOnYKzYxk1I2iydI0E2xW3Q6ChCiX6G3AfQZsd~3QNiqZDOp8nq5-hxv7BkHTej1U" +
                "8kvUlNYP8rJBAFR3jvJxPdH0eM42f5-MahC34xwFUN253rzCeuBM6rD4CUHtEHfRUNnhSVn119wCuUiMz6yu3lHS36D~osTe-0YRMhUTqcI" +
                "GnzqUEh5Z7MwsaVQfNrHE5oQ2LuwzT4tfmkXWV3OCyxVxC5pKiSnBJDBd-e3aDeYMaCZZjCmqXRAfnlVKF~g__","5 Hot store...",
            "3 minute ago",30)

        val hot2 = HotTopicModel("https://s3-alpha-sig.figma.com/img/f3f1/3041/0e12f2d95cd05cb3d96b08b21dce58ce?" +
                "Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=TlmlLFSghjHJsEseuwvRZBMc3ZgGWz1M1eqw59Whlk2fJL" +
                "FnIoftbzm~yViAYB2iBMP29jHQhmtQTpuMbfNswJSinYi1hQ06kNkkaErH19kKCG6Ip37n3XiJw3FgHTlMhWHTRTk9nw5i3zVpPG3NZImtM9m6RQ" +
                "0PPAD~Jo25avHf4y13nY25CKcfF94eBF-E1b2-E-zqORIldEPzbu2KTUK~snrkliaiZIMvc5XI-xH4pta3h3UaGUhuLjneQrRGHa8HQsjS7TqNDH" +
                "AofMtdNNgOc55wmuOHpoVp7dZ3GSHSJpFtXtMAmfuqGr3hzLWLKNEJxi5FGEG0BoF9ZYIcgg__","5 Hot store...",
            "30 minute ago",24)

        val hot3 = HotTopicModel("https://s3-alpha-sig.figma.com/img/c6a8/62d0/b9661a86283c131b6abd2eef34926913?" +
                "Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=fGs-2lXqgaN47wXVmfLZ34nUOceAiTAuU~ACCAExL9Joqr" +
                "2kF1FfMbmAuSiFa7jLM6inLy~3-QMZdAzFCI2PiIrrGkkcuA1~0HE1WvtEv2Y7YEsZT-EdmDzeaqpiWi1c5YYu7dlZy5N5x6eSVwWvXp3lnKJ" +
                "4N5b8r-~EVVrEmDmYgmBkmaJGOeAxAqKgUQxg7mLGLlc3zvdslENoKfA6r2S3cjxSV~vcCtKslxbbEI32eCRWdfZUMMEvkOL1qKME~HyESYDUq" +
                "jN3rHSd7TQVO-laU-hnWGYLD-kQI-a3EwxglLQdNP4Foe4QnHBZ3HzK6oiQoWDdYIo-5hfV5TYqJg__","5 Hot store...",
            "45 minute ago",55)

        val hot4 = HotTopicModel("https://s3-alpha-sig.figma.com/img/0c55/5909/f147a0657b593cf7ac5cd0faa6f14c72?" +
                "Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Hb4JklxebdHMnoC8k1YWRMqWzjKDRBlSYsCSx5261RCZTv" +
                "WFKlxxLoeROrn2XOHnse78NW0dyt7yk~IxLuBhEoYOnYKzYxk1I2iydI0E2xW3Q6ChCiX6G3AfQZsd~3QNiqZDOp8nq5-hxv7BkHTej1U8kvUl" +
                "NYP8rJBAFR3jvJxPdH0eM42f5-MahC34xwFUN253rzCeuBM6rD4CUHtEHfRUNnhSVn119wCuUiMz6yu3lHS36D~osTe-0YRMhUTqcIGnzqUEh5Z7" +
                "MwsaVQfNrHE5oQ2LuwzT4tfmkXWV3OCyxVxC5pKiSnBJDBd-e3aDeYMaCZZjCmqXRAfnlVKF~g__","5 Hot store...",
            "5 hour ago",101)

        val hot5 = HotTopicModel("https://s3-alpha-sig.figma.com/img/f3f1/3041/0e12f2d95cd05cb3d96b08b21dce58ce?Expires=1718582" +
                "400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=TlmlLFSghjHJsEseuwvRZBMc3ZgGWz1M1eqw59Whlk2fJLFnIoftbzm~yViAYB2iBMP29jHQ" +
                "hmtQTpuMbfNswJSinYi1hQ06kNkkaErH19kKCG6Ip37n3XiJw3FgHTlMhWHTRTk9nw5i3zVpPG3NZImtM9m6RQ0PPAD~Jo25avHf4y13nY25CKcfF94eBF-E1b" +
                "2-E-zqORIldEPzbu2KTUK~snrkliaiZIMvc5XI-xH4pta3h3UaGUhuLjneQrRGHa8HQsjS7TqNDHAofMtdNNgOc55wmuOHpoVp7dZ3GSHSJpFtXtMAmfuqGr3hz" +
                "LWLKNEJxi5FGEG0BoF9ZYIcgg__","5 Hot store...","23 hour ago",5)


        hotTopicModel.apply {
            add(hot1)
            add(hot2)
            add(hot3)
            add(hot4)
            add(hot5)
        }


        return hotTopicModel
    }
}