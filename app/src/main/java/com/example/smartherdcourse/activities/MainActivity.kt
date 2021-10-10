package com.example.smartherdcourse.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.smartherdcourse.Constants
import com.example.smartherdcourse.R
import com.example.smartherdcourse.showToast
import kotlinx.android.synthetic.main.activity_main.*






class MainActivity : AppCompatActivity() {
    companion object{
        val TAG:String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnShowToast.setOnClickListener {
            Log.i(TAG, "Button was clicked")
            showToast("Button was clicked !")
        }
        btnSendMessageToNextActivity.setOnClickListener {
            val message:String = etUserMessage.text.toString()
            val intent  = Intent(this, SecondActivity::class.java)

            intent.putExtra(Constants.USER_MSG_KEY, message)

            startActivity(intent)
        }
        btnShareToOtherApps.setOnClickListener {
            val message:String = etUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to: "))
        }

        btnRecyclerViewDemo.setOnClickListener {
            intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }



    }
}