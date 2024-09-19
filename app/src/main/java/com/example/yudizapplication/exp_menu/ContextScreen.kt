package com.example.yudizapplication.exp_menu

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R

class ContextScreen : AppCompatActivity(), ItemAdapter.OnItemLongClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private val items = listOf("Item 1", "Item 2", "Item 3")
    private var selectedPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_screen)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ItemAdapter(items, this)
        recyclerView.adapter = adapter
        registerForContextMenu(recyclerView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = MenuInflater(this)
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_edit -> {
                if (selectedPosition >= 0) {
                    Toast.makeText(this, "Edit item at position $selectedPosition", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No item selected", Toast.LENGTH_SHORT).show()
                }
                true
            }
            R.id.action_delete -> {
                if (selectedPosition >= 0) {
                    Toast.makeText(this, "Delete item at position $selectedPosition", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No item selected", Toast.LENGTH_SHORT).show()
                }
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onItemLongClick(position: Int) {
        selectedPosition = position
        val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
        viewHolder?.itemView?.let {
            recyclerView.showContextMenuForChild(it)
        }
    }
}