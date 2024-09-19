package com.example.yudizapplication.recyclerview.model

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.R

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val name = intent.getStringExtra("name")
        val contact = intent.getStringExtra("contact")
        val city = intent.getStringExtra("city")
        val age = intent.getIntExtra("age",0)

        if (name != null && city != null && contact != null) {
            val nameTextView = findViewById<TextView>(R.id.nameTextView)
            val contactTextView = findViewById<TextView>(R.id.contactTextView)
            val cityTextView = findViewById<TextView>(R.id.cityTextView)
            val ageTextView = findViewById<TextView>(R.id.ageTextView)

            nameTextView.text = "Name: $name"
            contactTextView.text = "Contact: $contact"
            cityTextView.text = "City: $city"
            ageTextView.text = "Age: $age"
        }
    }
}