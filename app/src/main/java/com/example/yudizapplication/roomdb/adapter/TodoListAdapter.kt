package com.example.yudizapplication.roomdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R
import com.example.yudizapplication.roomdb.TodoEntity


class TodoListAdapter(
    private val todoList: List<TodoEntity>,
    private val clickListener: (TodoEntity) -> Unit) : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {
    class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txt_todo_title: TextView = view.findViewById(R.id.txt_todo_title)
        val txt_todo_date: TextView = view.findViewById(R.id.txt_todo_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.txt_todo_title.text = todo.title
        holder.txt_todo_date.text = todo.createdAt

        holder.itemView.setOnClickListener {
            clickListener(todo)
        }
    }

    override fun getItemCount() = todoList.size
}