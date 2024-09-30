package com.example.yudizapplication.Retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R
import com.example.yudizapplication.Retrofit.Data_User

class UserAdapter(private val users: List<Data_User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.tv_user_name)
        val userAge: TextView = itemView.findViewById(R.id.tv_user_age)
        val userCompany: TextView = itemView.findViewById(R.id.tv_user_company)
        val userId: TextView = itemView.findViewById(R.id.tv_user_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_api, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.userName.text = user.name
        holder.userAge.text = user.age.toString()
        holder.userCompany.text = user.company
        holder.userId.text = user.id
    }

    override fun getItemCount(): Int {
        return users.size
    }
}
