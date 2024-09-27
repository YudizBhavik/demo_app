package com.example.yudizapplication.roomdb

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.yudizapplication.R
import com.example.yudizapplication.roomdb.adapter.TodoListAdapter
import com.example.yudizapplication.roomdb.db.TodoDao
import com.example.yudizapplication.roomdb.db.TodoDatabase
import com.example.yudizapplication.roomdb.model.Todo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CountDownLatch

class TodoListScreen : AppCompatActivity() {

    lateinit var myAdapter : TodoListAdapter
    lateinit var todolist : TodoDao
    lateinit var databasetodo : TodoDatabase
    lateinit var list_todo : MutableList<TodoEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_todo_list_screen)

        databasetodo =
            Room.databaseBuilder(applicationContext, TodoDatabase::class.java, "todo_database")
                .build()


        val add_todo_fab = findViewById<FloatingActionButton>(R.id.add_fab_todo)
        val recycler_todo = findViewById<RecyclerView>(R.id.recycler_todo)

        val todo_count = CountDownLatch(1)
        recycler_todo.adapter
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                Log.d("db_data", databasetodo.TodoDao().getAll().toString())
                list_todo = databasetodo.TodoDao().getAll()
                todo_count.countDown()
                Log.d("todolist",list_todo.toString())
            }
        }
        todo_count.await()
        recycler_todo.layoutManager = LinearLayoutManager(this)
        myAdapter = TodoListAdapter(list_todo)
        recycler_todo.adapter = myAdapter
        add_todo_fab.setOnClickListener {
            intent = Intent(this, AddTodoScreen::class.java)
            startActivity(intent)
        }


    }

    private fun deleteTodo(position: Int, toDo: TodoEntity) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                databasetodo.TodoDao().delete_todo(toDo)
                list_todo.removeAt(position)
            }
            myAdapter.notifyItemRemoved(position)
        }
    }
}