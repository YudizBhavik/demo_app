package com.example.yudizapplication.activity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        Log.d("SecondActivity", "SecondActivity onCreate called")

        val  textView1: TextView = findViewById(R.id.textView1)
        val textView2: TextView = findViewById(R.id.textView2)
        
        val text1 = intent.getStringExtra("TEXT1")
        val text2 = intent.getStringExtra("TEXT2")


        textView1.text = ("First Value is: $text1")
        textView2.text = ("Second Value is: $text2")
        Log.d("SecondScreen", "SecondScreen $text1")
        Log.d("SecondScreen", "SecondScreen $text2")
    }

    override fun onStart() {
        super.onStart()
        Log.d("SecondActivity", "SecondActivity onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SecondActivity", "SecondActivity onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SecondActivity", "SecondActivity onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SecondActivity", "SecondActivity onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity", "SecondActivity onDestroy called")
        Log.d("SecondActivity", "FirstScreen Clear")
    }
}
