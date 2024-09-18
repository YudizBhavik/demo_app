package com.example.yudizapplication.exp_menu

import android.os.Bundle
import android.view.Gravity
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.R

class PopupScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_screen)

        val showPopupMenuButton: Button = findViewById(R.id.showPopupMenuButton)

        showPopupMenuButton.setOnClickListener { view ->
            // Create a PopupMenu
            val popupMenu = PopupMenu(this, view, Gravity.END)
            val inflater: MenuInflater = popupMenu.menuInflater
            inflater.inflate(R.menu.context_menu, popupMenu.menu)

            // Handle menu item clicks
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_edit -> {
                        Toast.makeText(this, "Edit selected", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_delete -> {
                        Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }

            // Show the PopupMenu
            popupMenu.show()
        }
    }
}