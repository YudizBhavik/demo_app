package com.example.yudizapplication.Multithreading


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.R

class OnBoardingScreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding_screen2)

        val btn_ex1 = findViewById<Button>(R.id.example_1)
        val btn_ex2 = findViewById<Button>(R.id.example_2)
        val btn_ex3 = findViewById<Button>(R.id.example_3)
        val btn_ex4 = findViewById<Button>(R.id.example_4)

        btn_ex1.setOnClickListener {
            intent = Intent(this, Example1::class.java)
            startActivity(intent)
        }
            btn_ex2.setOnClickListener {
            intent = Intent(this, Example2::class.java)
            startActivity(intent)
        }
        btn_ex3.setOnClickListener {
            intent = Intent(this, Example3::class.java)
            startActivity(intent)
        }
        btn_ex4.setOnClickListener {
            intent = Intent(this, Example4::class.java)
            startActivity(intent)
        }
    }
}
