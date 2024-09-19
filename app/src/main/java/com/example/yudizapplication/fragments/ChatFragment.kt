package com.example.yudizapplication.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R
import com.example.yudizapplication.adapters.ChatAdapter
import com.example.yudizapplication.fragments.model.Chat

class ChatFragment : Fragment(R.layout.fragment_chat) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chatList = listOf(
            Chat("Bhavik", "Hello, how are you?"),
            Chat("Harsh", "I'm good! How about you?"),
            Chat("Kushal", "Doing well, thanks for asking."),
        )
        val recyclerView: RecyclerView = view.findViewById(R.id.ChatList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ChatAdapter(chatList)

    }
}