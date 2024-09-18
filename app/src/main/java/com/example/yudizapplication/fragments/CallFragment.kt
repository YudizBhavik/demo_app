package com.example.yudizapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R
import com.example.yudizapplication.adapters.ChatAdapter
import com.example.yudizapplication.fragments.Adapter.CallAdapter
import com.example.yudizapplication.fragments.model.Call
import com.example.yudizapplication.fragments.model.Chat

class CallFragment : Fragment(R.layout.fragment_call) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callList = listOf(
            Call("Bhavik", "5 hours ago"),
            Call("Harsh", "1 day ago"),
            Call("Kushal", "5 days ago"),
        )

        val recyclerView: RecyclerView? = view?.findViewById(R.id.CallList)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = CallAdapter(callList)

    }
}