package com.example.yudizapplication.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.R

class FirstScreen : AppCompatActivity() {

    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var submitButton: Button

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)

        Log.d("FirstScreen", "FirstScreen onCreate called")

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val text1 = editText1.text.toString()
            val text2 = editText2.text.toString()

            Log.d("FirstScreen", "Submit button clicked")

            intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("TEXT1", text1)
                intent.putExtra("TEXT2", text2)
                startActivity(intent)
                Log.d("FirstScreen", "$text1")
                Log.d("FirstScreen", "$text2")
            }

        }

    override fun onResume() {
        super.onResume()
        Log.d("FirstScreen", "FirstScreen onResume called")
        editText1.text.clear()
        editText2.text.clear()
    }

    override fun onStart() {
        super.onStart()
        Log.d("FirstScreen", "FirstScreen onStart called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("FirstScreen", "FirstScreen onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("FirstScreen", "FirstScreen onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FirstScreen", "FirstScreen onDestroy called")
    }
}
