package com.blackpuppydev.matchy_native.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.adapter.NotificationAdapter
import com.blackpuppydev.matchy_native.api.response.NotificationResponse
import com.blackpuppydev.matchy_native.databinding.ActivityNotificationBinding

class NotificationActivity : BaseActivity() {

    var binding:ActivityNotificationBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setAdapter()




    }


    private fun setAdapter(){
        binding?.apply {
            listNotification.apply {
                layoutManager = GridLayoutManager(context, 1)
                adapter = object : NotificationAdapter(getNotification()){
                    override fun onSelectItem(id: String) {
                    }

                }
            }
        }
    }

    //for mock
    fun getNotification():ArrayList<NotificationResponse>{

        val notification = arrayListOf<NotificationResponse>()

        val noti1 = NotificationResponse("1","","","")

        notification.add(noti1)


        return notification
    }



}