package com.example.yudizapplication.roomdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R
import com.example.yudizapplication.roomdb.TodoEntity


class TodoListAdapter(
    private val todoList: List<TodoEntity>) : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {
    class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txt_todo_title: TextView = view.findViewById(R.id.txt_todo_title)
        val txt_todo_date: TextView = view.findViewById(R.id.txt_todo_date)
        val icon_edit:ImageView = view.findViewById(R.id.edit_icon)
        val icon_delete: ImageView = view.findViewById(R.id.icon_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.txt_todo_title.text = todo.title
        holder.txt_todo_date.text = todo.createdAt

    }

    override fun getItemCount() = todoList.size
}