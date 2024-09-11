package com.example.yudizapplication.snackbar

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SnackbarScreen : AppCompatActivity() {

    private var isFabExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar_screen)


//
//        val fabMain: FloatingActionButton = findViewById(R.id.fabMain)
//        val fabOption1: FloatingActionButton = findViewById(R.id.fabOption1)
//        val fabOption2: FloatingActionButton = findViewById(R.id.fabOption2)
//        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
//
//        // Set initial visibility to GONE (hidden)
//        fabMain.setOnClickListener {
//            toggleFabMenu(fabOption1, fabOption2)
//        }
//
//
//
//        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.nav_left -> {
//                    // Handle Left button action
//                    true
//                }
//
//                R.id.nav_center -> {
//                    // Handle Home action
//                    true
//                }
//
//                else -> false
//            }
//        }
//    }
//
//    private fun toggleFabMenu(fabOption1: FloatingActionButton, fabOption2: FloatingActionButton) {
//        if (isFabExpanded) {
//            fabOption1.visibility = View.GONE
//            fabOption2.visibility = View.GONE
//        } else {
//            fabOption1.visibility = View.VISIBLE
//            fabOption2.visibility = View.VISIBLE
//        }
//        isFabExpanded = !isFabExpanded
    }
}
