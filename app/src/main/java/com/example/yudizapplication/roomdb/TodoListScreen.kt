package com.example.yudizapplication.roomdb

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.yudizapplication.R
import com.example.yudizapplication.roomdb.adapter.TodoListAdapter
import com.example.yudizapplication.roomdb.db.TodoDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoListScreen : AppCompatActivity() {

    lateinit var myAdapter: TodoListAdapter
    lateinit var databasetodo: TodoDatabase
    lateinit var list_todo: MutableList<TodoEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list_screen)
        databasetodo = Room.databaseBuilder(applicationContext, TodoDatabase::class.java, "todo_database")
            .allowMainThreadQueries().build()

        val add_todo_fab = findViewById<FloatingActionButton>(R.id.add_fab_todo)
        val recycler_todo = findViewById<RecyclerView>(R.id.recycler_todo)

        recycler_todo.layoutManager = LinearLayoutManager(this)
        myAdapter = TodoListAdapter(mutableListOf(), databasetodo.TodoDao()) // Initially empty list
        recycler_todo.adapter = myAdapter

        add_todo_fab.setOnClickListener {
            val intent = Intent(this, AddTodoScreen::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        loadTodos()
    }

    private fun loadTodos() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                list_todo = databasetodo.TodoDao().getAll()
            }
            myAdapter.updateTodoList(list_todo)
        }
    }
}
