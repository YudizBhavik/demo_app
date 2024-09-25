package com.example.yudizapplication.roomdb

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.yudizapplication.R
import com.example.yudizapplication.roomdb.db.TodoDao
import com.example.yudizapplication.roomdb.db.TodoDatabase
import com.example.yudizapplication.roomdb.model.Todo

class TodoListScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo_list_screen)


        val db = Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java, "todo"
        ).build()
    }
}