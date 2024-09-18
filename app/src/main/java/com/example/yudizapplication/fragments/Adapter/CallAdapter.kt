package com.example.yudizapplication.fragments.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R
import com.example.yudizapplication.fragments.model.Call
import com.example.yudizapplication.fragments.model.Chat


class CallAdapter(private val callList: List<Call>) : RecyclerView.Adapter<CallAdapter.CallViewHolder>() {

    inner class CallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTxt: TextView = itemView.findViewById(R.id.nameTextView)
        val timeTxt: TextView = itemView.findViewById(R.id.TimeTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_chatlist, parent, false)
        return CallViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        val currentChat = callList[position]
        holder.nameTxt.text = currentChat.call_name
        holder.timeTxt.text = currentChat.time
    }

    override fun getItemCount() = callList.size
}
