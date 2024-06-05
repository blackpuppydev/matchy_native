package com.blackpuppydev.matchy_native.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.api.repository.UserRepository
import com.blackpuppydev.matchy_native.api.response.DiscoverResponse
import com.blackpuppydev.matchy_native.constance.LandingPage
import com.blackpuppydev.matchy_native.databinding.ActivityMainBinding
import com.blackpuppydev.matchy_native.fragment.main.*
import com.blackpuppydev.matchy_native.listener.MainFragmentEvent

class MainActivity : BaseActivity() , MainFragmentEvent{


    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.itemIconTintList = null

        //test
        replaceFragment(DiscoverFragment.newInstance(getTestDiscover()),true)
        binding.btnIcon.visibility = View.VISIBLE
        binding.mainCloset.visibility = View.GONE


        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.closet -> {
                    binding.btnIcon.visibility = View.GONE
                    binding.mainCloset.visibility = View.VISIBLE
                    binding.title.text = "Closet"
                    UserRepository.newInstance().getUserCloset("nattawut.c"){

                    }
                    replaceFragment(ClosetFragment.newInstance("",""))

                }

                R.id.discover -> {
                    showThreeButton()
                    binding.title.text = "Discover"
                    replaceFragment(DiscoverFragment.newInstance(getTestDiscover()))



                }

                R.id.style -> {
                    showThreeButton()
                    binding.title.text = "Style"
                    replaceFragment(StyleFragment.newInstance("",""))

                }

                R.id.commu -> {
                    showThreeButton()
                    binding.title.text = "Community"
                    replaceFragment(CommunityFragment.newInstance("",""))


                }

                R.id.profile -> {
                    showThreeButton()
                    binding.title.text = "Profile"
                    replaceFragment(ProfileFragment.newInstance("",""))



                }
            }

            true
        }

    }


    private fun replaceFragment(fragment: Fragment, isAppInit:Boolean = false){

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        if (isAppInit) fragmentTransaction.add(R.id.content,fragment)
        else fragmentTransaction.replace(R.id.content,fragment)

        fragmentTransaction.commit()
    }


    private fun showThreeButton(){
        binding.btnIcon.visibility = View.VISIBLE
        binding.mainCloset.visibility = View.GONE


    }

    override fun onSuccess() {

    }

    override fun onResult(result: String, landingPage: String) {

        when (landingPage){

            LandingPage.PAGE_DISCOVER -> {

            }
        }



    }


    // ----- for test ----- //

    private fun getTestDiscover():ArrayList<DiscoverResponse>{

        val discover1 = DiscoverResponse().apply {
            name = "Shop"
            lastName = "Sheep"
            pairing = 60
            follower = 1549
            activity = "dating"
            imgProfile = "https://s3-alpha-sig.figma.com/img/6267/26b2/be2595433c28eda2a913cea75a86a8c4?Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=CFR3Clo2tIHBIrVQyE8kwmSyIAbFMuC1DMYhLX~56rGmwe8DIXX3O77hk9XmkTyAAEjD3UdZsDJzfS7P0m8yFwySh3tJU1ShX-SrfVNrSUoBDdzVo6RZ~pzCHvK7WHzOYa7zzXO~g8FrkyiJQPZv9J3o1Tg3fnKVkM8~DMznM8mCsf9WNUh43to2P36eT5QxRquYtztQJ-3L7x~Zmtet1SFTHuF2ejl5-9jMvK0G6wYSdUxxtTsGS4Sxa9-lRI8U0UijZ8giatQruBsFSh~Hcvi5HC9KkPTyY~-S-YryENeLwdED1x2xRco0gmKvoWyAIvrgsHWYTINmWznptsJXmw__"
        }

        val discover2 = DiscoverResponse().apply {
            name = "Nattawut"
            lastName = "Sheep"
            pairing = 20
            follower = 4452
            activity = "working"
            imgProfile = "https://s3-alpha-sig.figma.com/img/cfbe/08d2/9c615a297c2e5cc509d608233a4a63d6?Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E8GRKkOk9pyVKZjFSRuAtZ8hsY5jEbwMyL6YLjRiVqkXyyAlL5jQ32xgvQrYOIAXSw0a8VhFr0-tU4-SsKfX3rzwXLu4wlmbG~2dtUkQahscMKIjgDj7VwXPTqI~lgxZmq~lt8PThiEQlnxd92pqyV9RmBeTyA-cuR70jReYbBVVD56CbEdaCxXj14kBF~X4PdnCWwh6q0TtyaMqWJe5tovrNifIemeZirrROK9IGyR3T0hPbU4f7PAb~ABs7gNAK3zpEQLPw5O8Y7F9uq8vFS526NufZSfNzHtVTjFAHDcXyXY4f6wukWg97HjzChui7wI1oZiUz5h4sEWQXjBq0A__"
        }

        val discover3 = DiscoverResponse().apply {
            name = "A"
            lastName = "Sheep"
            pairing = 30
            follower = 4333
            activity = "dating"
            imgProfile = "https://s3-alpha-sig.figma.com/img/909e/6573/2f8bacb818b3bb416ab6c071628745c7?Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=F5Qeb8i2KTTDdJf8EP1-NO3xxvzmTly4uNhzHOGnwfc4TgYFifJgoebnF82LSwcKbp3i4X6HTAuU9RqnFmVSs3oRcXnGD7~iz-61klwh4OiHfR4HuBTDSB-gC9pBMsVTpZ9pPgDxh6zKm9N7bqfqQtjtfD8Z5uV2AktabYqZZyZGAnRTSFlo4D2H28L3bQIWE9go-L5J4CFhAnRgLByq1cSHUi2dMVzhp53hUkZMS3YdbZKfhdw6C8f2ggRIc4cgCZwX21yvblw1YMvG7MkonfL3GTVgy69XTY-IN0TO96ibAgxkx-~EhvpkIj79DVgekEAGfXVE1ZADz~h1hYCdrQ__"
        }

        val discover4 = DiscoverResponse().apply {
            name = "B"
            lastName = "Sheep"
            pairing = 40
            follower = 4235
            activity = "dating"
            imgProfile = "https://s3-alpha-sig.figma.com/img/2a8c/f478/6856291d7734fadad6fd135f91d54a42?Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=OKgHzw2NOYIAev0q33e0M7aAreBrUIz-zv~UbfyX3W7fEuqwlwGOoCmyqysKkvvnQIKzaApqC924fOWdR3U42EsXlZzkoX7l8UZPjSIjyU7OctqNWheaDgaxX0CB4zOpb5QBY8RacJaXOXtIttFhbMh5Mf3Tz6EgMWxxRDaPjbm6rc2tMJNvPIUQ9FkUfZnFySJtus3dNx0UNraDBleI65fV5lsAq7eIxUWVqBaP4ylVYSBRxFuK-WXa75Xl2FEQaPaE5Ve5rBpnYub0GojUn3pyEHu5aTkB6hnlNBn8Mzzh309tmkBqReB9NroX8u4z7lxxbXhfLa5RvYCXrnRy1w__"
        }

        val discover5 = DiscoverResponse().apply {
            name = "C"
            lastName = "Sheep"
            pairing = 60
            follower = 1549
            activity = "dating"
            imgProfile = "https://s3-alpha-sig.figma.com/img/a27b/b91a/fb0ec304610b4834f08a60cec93a7a06?Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ns9QA4lqG-EkTaofdIJR51KxJcDbvbrAFT7bqMGOEmseHibZMYwzh5hsBpg~-idBIkOvs1aUSHANLw42ipP41DIOR3EKtxnTlSpeeRwYG700qI8z4yb3omAZMR5BeZEq70kc~I05CTcdzQ-R0xPR6QpJnf7VRAwoKDsacpM1OKM2IkmTnU-ZYGTWK-hKZEFY9Y9VjxaVkBFPPJLZyTObbglbsqgMVjKpmgX~E9PJUK~Y2yIHdAUNUcVUa9Ol05iAco0jhgiRWPUx36yI87pdxqpcvFlaQU4SU9iay9QQGz4Rb068gSIs17J~OqkEJ-XWPFMEkAFWlvW2pjfXryzZ-w__"
        }

        val discover6 = DiscoverResponse().apply {
            name = "D"
            lastName = "Sheep"
            pairing = 60
            follower = 1549
            activity = "dating"
            imgProfile = "https://s3-alpha-sig.figma.com/img/bae0/94e2/6f4b62c742d2991e037790f6ec92d884?Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=YeTkv49HZ4jhM-~EMaHVeBLWggbyhb3LpBbTcIwVZMMG1eEcYGbQoP-5MMe4TkoZXmI5hT0Y9f9DRjTPJ1CWS0~eLXMH1mmnnaxC4v24T6EfEqsTDFg-mfrPLxqbEwTmvn0V6ZjIcqIJ185b7WoqJKX~HooLYi3zYwf3~S2wTFINhbmFTgvDLWweob1auN5aGLWfkaxV4sdgoUOT~QGFNIKlgVxsy-~0mbiD0nBsbFtQ--5jMSDuRYfFsI0XJ797j4NT7yhUjk3~c~nVPrVxi6ZcS~mEKXXzumbVE8RX7SNHfFnEZtRpF2Qjd-Ld-D1wG5DHLtPJ86uwdEUoiN28Kw__"
        }

        val discover7 = DiscoverResponse().apply {
            name = "E"
            lastName = "Sheep"
            pairing = 60
            follower = 1549
            activity = "dating"
            imgProfile = "https://s3-alpha-sig.figma.com/img/6267/26b2/be2595433c28eda2a913cea75a86a8c4?Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=CFR3Clo2tIHBIrVQyE8kwmSyIAbFMuC1DMYhLX~56rGmwe8DIXX3O77hk9XmkTyAAEjD3UdZsDJzfS7P0m8yFwySh3tJU1ShX-SrfVNrSUoBDdzVo6RZ~pzCHvK7WHzOYa7zzXO~g8FrkyiJQPZv9J3o1Tg3fnKVkM8~DMznM8mCsf9WNUh43to2P36eT5QxRquYtztQJ-3L7x~Zmtet1SFTHuF2ejl5-9jMvK0G6wYSdUxxtTsGS4Sxa9-lRI8U0UijZ8giatQruBsFSh~Hcvi5HC9KkPTyY~-S-YryENeLwdED1x2xRco0gmKvoWyAIvrgsHWYTINmWznptsJXmw__"
        }

        val discover8 = DiscoverResponse().apply {
            name = "F"
            lastName = "Sheep"
            pairing = 60
            follower = 1549
            activity = "dating"
            imgProfile = "https://s3-alpha-sig.figma.com/img/6267/26b2/be2595433c28eda2a913cea75a86a8c4?Expires=1718582400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=CFR3Clo2tIHBIrVQyE8kwmSyIAbFMuC1DMYhLX~56rGmwe8DIXX3O77hk9XmkTyAAEjD3UdZsDJzfS7P0m8yFwySh3tJU1ShX-SrfVNrSUoBDdzVo6RZ~pzCHvK7WHzOYa7zzXO~g8FrkyiJQPZv9J3o1Tg3fnKVkM8~DMznM8mCsf9WNUh43to2P36eT5QxRquYtztQJ-3L7x~Zmtet1SFTHuF2ejl5-9jMvK0G6wYSdUxxtTsGS4Sxa9-lRI8U0UijZ8giatQruBsFSh~Hcvi5HC9KkPTyY~-S-YryENeLwdED1x2xRco0gmKvoWyAIvrgsHWYTINmWznptsJXmw__"
        }

        return arrayListOf(discover1,discover2,discover3,discover4,discover5,discover6,discover7,discover8)

    }







}