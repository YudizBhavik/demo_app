    package com.example.yudizapplication.viewpager.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.yudizapplication.R


class DinnerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dinner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView: ListView = view.findViewById(R.id.List_Launch)
        val breakfast: List<String> = listOf("Mix veg", "Roti", "Dal-Bhat")

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, breakfast)
        listView.adapter = adapter
    }

    companion object {
        fun newInstance(): BreakfastFragment {
            return BreakfastFragment()
        }
    }
}