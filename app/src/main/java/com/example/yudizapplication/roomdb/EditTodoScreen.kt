package com.example.yudizapplication.roomdb

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.yudizapplication.R
import com.example.yudizapplication.roomdb.db.TodoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditTodoScreen : AppCompatActivity() {

    private lateinit var todoEditText: EditText
    private lateinit var updateButton: Button
    private lateinit var database: TodoDatabase
    private var todoId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_todo_screen)

        todoEditText = findViewById(R.id.edit_todo_text)
        updateButton = findViewById(R.id.update_button)

        val todoTitle = intent.getStringExtra("todo_title")
        todoId = intent.getIntExtra("todo_id", -1)

        todoEditText.setText(todoTitle)

        database = Room.databaseBuilder(applicationContext, TodoDatabase::class.java, "todo_database")
            .build()

        updateButton.setOnClickListener {
            val updatedTitle = todoEditText.text.toString()

            if (todoId != -1) {
                lifecycleScope.launch {
                    withContext(Dispatchers.IO) {
                        val todoEntity = database.TodoDao().getTodoById(todoId)

                        todoEntity.title = updatedTitle

                        database.TodoDao().update_todo(todoEntity)
                    }
                    finish()
                }
            }
        }
    }
}
