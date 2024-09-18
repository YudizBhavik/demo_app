package com.example.yudizapplication.start_activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R

class UpdateProfile : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update_profile)

            nameEditText = findViewById(R.id.edit_text_name)
            emailEditText = findViewById(R.id.edit_text_email)
            phoneEditText = findViewById(R.id.edit_text_phone)

            nameEditText.setText(intent.getStringExtra("name"))
            emailEditText.setText(intent.getStringExtra("email"))
            phoneEditText.setText(intent.getStringExtra("phone"))

            findViewById<Button>(R.id.btn_save).setOnClickListener {
                val resultIntent = Intent()
                resultIntent.putExtra("updatedName", nameEditText.text.toString())
                resultIntent.putExtra("updatedEmail", emailEditText.text.toString())
                resultIntent.putExtra("updatedPhone", phoneEditText.text.toString())
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
    }
}