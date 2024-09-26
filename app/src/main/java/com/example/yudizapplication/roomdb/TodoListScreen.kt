package com.example.yudizapplication.roomdb

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.yudizapplication.R
import com.example.yudizapplication.roomdb.adapter.TodoListAdapter
import com.example.yudizapplication.roomdb.db.TodoDao
import com.example.yudizapplication.roomdb.db.TodoDatabase
import com.example.yudizapplication.roomdb.model.Todo
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoListScreen : AppCompatActivity() {


    lateinit var myAdapter : TodoListAdapter
    lateinit var todolist : TodoDao
    lateinit var databasetodo : TodoDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo_list_screen)


        val add_todo_fab = findViewById<FloatingActionButton>(R.id.add_fab_todo)
        val recycler_todo = findViewById<RecyclerView>(R.id.recycler_todo)

        val todolist = todolist.getAll()
        val database = databasetodo.TodoDao().getAll()
       recycler_todo.adapter

        add_todo_fab.setOnClickListener{
            intent = Intent(this,AddTodoScreen::class.java)
            startActivity(intent)
        }

        recycler_todo.layoutManager = LinearLayoutManager(this)
    }
}