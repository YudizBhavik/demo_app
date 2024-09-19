package com.example.yudizapplication.fragments.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R
import com.example.yudizapplication.fragments.model.Call


class CallAdapter(private val callList: List<Call>) : RecyclerView.Adapter<CallAdapter.CallViewHolder>() {

    inner class CallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTxt: TextView = itemView.findViewById(R.id.CallTextView)
        val timeTxt: TextView = itemView.findViewById(R.id.TimeTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_call, parent, false)
        return CallViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        val currentCall = callList[position]
        holder.nameTxt.text = currentCall.call_name
        holder.timeTxt.text = currentCall.time
    }

    override fun getItemCount() = callList.size
}
