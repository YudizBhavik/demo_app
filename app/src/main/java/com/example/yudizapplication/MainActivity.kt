package com.example.yudizapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toast = Toast.makeText(applicationContext, "onCreate Called", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        val toast = Toast.makeText(applicationContext, "onStart Called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        val toast = Toast.makeText(applicationContext, "onResume Called", Toast.LENGTH_SHORT).show()

    }

    override fun onPause() {
        super.onPause()
        val toast = Toast.makeText(applicationContext, "onPause Called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        val toast = Toast.makeText(applicationContext, "onStop Called", Toast.LENGTH_SHORT).show()

    }

    override fun onRestart() {
        super.onRestart()
        val toast = Toast.makeText(applicationContext, "onRestart Called", Toast.LENGTH_LONG).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        val toast = Toast.makeText(applicationContext, "onDestroy Called", Toast.LENGTH_SHORT).show()

    }
}
