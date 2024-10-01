package com.example.yudizapplication.Multithreading

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R

class Example1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_example1)

        val edit_text_1 = findViewById<EditText>(R.id.edit_first_number)
        val edit_text_2 = findViewById<EditText>(R.id.edit_second_number)
        val result = findViewById<TextView>(R.id.txt_add_result)
        val btn_addition = findViewById<Button>(R.id.btn_addition)

        btn_addition.setOnClickListener {
            Thread{
               val result_add = edit_text_1.text.toString().toInt() + edit_text_2.text.toString().toInt()
                Handler(Looper.getMainLooper()).post{
                    result.setText("${result_add}")
                }
            }.start()
        }
    }
}