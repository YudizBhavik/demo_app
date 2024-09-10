package com.example.yudizapplication.recyclerview.model

import PersonAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R

class PersonInformation : AppCompatActivity() {
    private val personList = listOf(
        Person("Bhavik Makvana", "7990089373", "Jamnagar", 21),
        Person("Harsh Goswami", "0987654321", "Jamnagar", 21),
        Person("Kushal Asodia", "9876543210", "Rajkot", 22),
        Person("Dhrumit Boricha", "8264631075", "Jamnagar", 21)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_information)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        // Set adapter
        val adapter = PersonAdapter(personList) { person ->
            // Handle click and open the next screen
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("name", person.name)
            intent.putExtra("contact", person.contactNumber)
            intent.putExtra("city", person.city)
            intent.putExtra("age", person.age)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}