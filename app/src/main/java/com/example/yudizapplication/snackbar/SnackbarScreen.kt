package com.example.yudizapplication.snackbar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class SnackbarScreen : AppCompatActivity() {

    private lateinit var mainFab: FloatingActionButton
    private lateinit var fab1: FloatingActionButton
    private lateinit var fab2: FloatingActionButton
    private var areFabsVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar_screen)
        mainFab = findViewById(R.id.fab)
        fab1 = findViewById(R.id.fab1)
        fab2 = findViewById(R.id.fab2)

        mainFab.setOnClickListener {
            toggleFabsVisibility()
        }
        fab1.setOnClickListener {
            showSnackbar("FAB 1 clicked")
        }

        fab2.setOnClickListener {
            showSnackbar("FAB 2 clicked")
        }
    }

    private fun toggleFabsVisibility() {
        if (areFabsVisible) {
            fab1.visibility = View.GONE
            fab2.visibility = View.GONE
        } else {
            fab1.visibility = View.VISIBLE
            fab2.visibility = View.VISIBLE
        }
        areFabsVisible = !areFabsVisible
    }

    private fun showSnackbar(message: String) {
        val snackbar = Snackbar.make(findViewById(R.id.fab), message, Snackbar.LENGTH_LONG)
        snackbar.setAction("Cancel") {
            snackbar.dismiss()
        }
        snackbar.show()
    }
}
