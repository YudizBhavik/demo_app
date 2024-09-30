package com.example.yudizapplication.roomdb.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R
import com.example.yudizapplication.roomdb.EditTodoScreen
import com.example.yudizapplication.roomdb.TodoEntity
import com.example.yudizapplication.roomdb.db.TodoDao

class TodoListAdapter(
    private var todoList: MutableList<TodoEntity>,
    private val todoDao: TodoDao
) : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {

    class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txt_todo_title: TextView = view.findViewById(R.id.txt_todo_title)
        val txt_todo_date: TextView = view.findViewById(R.id.txt_todo_date)
        val icon_edit: ImageButton = view.findViewById(R.id.edit_icon)
        val icon_delete: ImageButton = view.findViewById(R.id.icon_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.txt_todo_title.text = todo.title
        holder.txt_todo_date.text = todo.createdAt
        holder.icon_edit.setOnClickListener {
            val intent = Intent(holder.itemView.context, EditTodoScreen::class.java)
            intent.putExtra("todo_id", todo.id)
            intent.putExtra("todo_title", todo.title)
            holder.itemView.context.startActivity(intent)
        }
        holder.icon_delete.setOnClickListener {
            todoDao.delete_todo(todo)
            todoList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount() = todoList.size
    fun updateTodoList(newTodoList: MutableList<TodoEntity>) {
        todoList = newTodoList
        notifyDataSetChanged()
    }
}
