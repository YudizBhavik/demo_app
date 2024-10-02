package com.example.yudizapplication.Retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R
import com.example.yudizapplication.Retrofit.model.Data_User

class UserAdapter(
    private var users: MutableList<Data_User>,
    private val editClickListener: (Data_User) -> Unit,
    private val deleteClickListener: (Data_User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.tv_user_name)
        val userAge: TextView = itemView.findViewById(R.id.tv_user_age)
        val userCompany: TextView = itemView.findViewById(R.id.tv_user_company)
        val userId: TextView = itemView.findViewById(R.id.tv_user_id)
        val editButton: ImageButton = itemView.findViewById(R.id.edit_icon_user)
        val deleteButton: ImageButton = itemView.findViewById(R.id.delete_icon_user)

        fun bind(
            user: Data_User,
            editClickListener: (Data_User) -> Unit,
            deleteClickListener: (Data_User) -> Unit
        ) {
            userName.text = user.name
            userAge.text = user.age.toString()
            userCompany.text = user.company
            userId.text = user.id

            editButton.setOnClickListener {
                editClickListener(user)
            }

            deleteButton.setOnClickListener {
                deleteClickListener(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_api, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user, editClickListener, deleteClickListener)
    }

    override fun getItemCount(): Int {
        return users.size
    }
}
