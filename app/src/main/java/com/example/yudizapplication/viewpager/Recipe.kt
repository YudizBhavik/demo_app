package com.example.recipeviewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.yudizapplication.R

class Recipe : Fragment() {

    private var recipes: List<String> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView: ListView = view.findViewById(R.id.listViewRecipes)

        recipes = when (arguments?.getInt("CATEGORY_POSITION")) {
            0 -> listOf("Pava", "Aloo Paratha", "Tea")
            1 -> listOf("Mix veg", "Roti", "Dal-Bhat")
            else -> listOf("Panjabi sabji", "Roti/Paratha", "Dalfry-Jira rice","Butter-Milk")
        }

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, recipes)
        listView.adapter = adapter
    }

    companion object {
        fun newInstance(categoryPosition: Int) =
            Recipe().apply {
                arguments = Bundle().apply {
                    putInt("CATEGORY_POSITION", categoryPosition)
                }
            }
    }
}