package com.example.yudizapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R
import com.example.yudizapplication.fragments.Adapter.CallAdapter
import com.example.yudizapplication.fragments.model.Call

class CallFragment : Fragment(R.layout.fragment_call) {

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val callList = listOf(
            Call("Bhavik", "5 hours ago"),
            Call("Harsh", "1 day ago"),
            Call("Kushal", "5 days ago"),
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.CallList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CallAdapter(callList)

    }
}

//class ChatFragment : Fragment(R.layout.fragment_chat) {
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val chatList = listOf(
//            Chat("Bhavik", "Hello, how are you?"),
//            Chat("Harsh", "I'm good! How about you?"),
//            Chat("Kushal", "Doing well, thanks for asking."),
//        )
//
//        val recyclerView: RecyclerView = view.findViewById(R.id.ChatList)
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        recyclerView.adapter = ChatAdapter(chatList)
//    }
//}