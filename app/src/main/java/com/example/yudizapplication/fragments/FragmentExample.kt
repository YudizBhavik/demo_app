package com.example.yudizapplication.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.R

class FragmentExample : AppCompatActivity(R.layout.activity_fragment_example) {

    lateinit var fragment_btn_1: Button
    lateinit var fragment_btn_2: Button
    lateinit var fragment_btn_3: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragment_btn_1 = findViewById(R.id.btn_fragment_1)
        fragment_btn_2 = findViewById(R.id.btn_fragment_2)
        fragment_btn_3 = findViewById(R.id.btn_fragment_3)
        onload()

        fragment_btn_1.setOnClickListener{
                val transition = supportFragmentManager.beginTransaction()
                transition.replace(R.id.ChatFragment, ChatFragment())
                transition.commit()
        }
        fragment_btn_2.setOnClickListener{
            val transition = supportFragmentManager.beginTransaction()
            transition.replace(R.id.ChatFragment, CallFragment())
            transition.commit()
        }
        fragment_btn_3.setOnClickListener{
            val transition = supportFragmentManager.beginTransaction()
            transition.replace(R.id.ChatFragment, ChatDetailsFragment())
            transition.commit()
        }
    }
    fun onload(){
        val transition = supportFragmentManager.beginTransaction()
        transition.add(R.id.ChatFragment, ChatFragment())
        transition.commit()
    }
}
