package com.example.yudizapplication.FCM

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.databinding.ActivityFcmexampleBinding
import com.google.firebase.messaging.FirebaseMessaging

class FCMExample : AppCompatActivity() {
    var TAG = "FCMActivity"
    var binding: ActivityFcmexampleBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFcmexampleBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding?.getToken?.setOnClickListener {
            v ->
            FirebaseMessaging.getInstance().token
                .addOnCompleteListener { task ->
                    // this fail
                    if (!task.isSuccessful) {
                        Log.d(
                            TAG,
                            "Fetching FCM registration token failed",
                            task.exception
                        )
                        return@addOnCompleteListener
                    }

                    val token = task.result
                    //to showing
                    binding!!.token.setText(token)
                    Toast.makeText(this@FCMExample, "get a token", Toast.LENGTH_SHORT).show()
                }
        }
//
    }
}