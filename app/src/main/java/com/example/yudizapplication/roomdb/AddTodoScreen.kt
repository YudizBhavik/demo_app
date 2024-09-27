package com.example.yudizapplication.roomdb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.yudizapplication.R
import com.example.yudizapplication.roomdb.db.TodoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class AddTodoScreen : AppCompatActivity() {

    private lateinit var todoDb : TodoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_todo_screen)
       todoDb = Room.databaseBuilder(
           applicationContext,
           TodoDatabase::class.java,
           "todo_database"
       ).fallbackToDestructiveMigrationFrom().build()

        val add_todo_btn = findViewById<Button>(R.id.btn_add_todo)
        add_todo_btn.setOnClickListener {
            addTodo()
        }
    }

    private fun addTodo(){
//        todoDb = TodoDatabase.getDatabase(this)
        val et_todo = findViewById<EditText>(R.id.add_todo_et)
        val current_date = Calendar.getInstance().time

        if (et_todo != null) {
            val todo = TodoEntity(null, et_todo.text.toString(), current_date.toString())
            Thread{todoDb.TodoDao().insert_todo(todo)}.start()
            println(todo)
        }
        intent = Intent(this,TodoListScreen::class.java)
        startActivity(intent)
    }

}
