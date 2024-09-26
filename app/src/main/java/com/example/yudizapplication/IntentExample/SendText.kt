package com.example.yudizapplication.IntentExample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R

class SendText : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_send_text)

        val edit_random_text = findViewById<EditText>(R.id.edit_randomtext)


            Intent.ACTION_SEND
            val text = intent.getStringExtra(Intent.EXTRA_TEXT)
            edit_random_text.setText(text)

    }
}