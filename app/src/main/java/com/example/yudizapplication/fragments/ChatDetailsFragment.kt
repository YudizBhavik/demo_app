package com.example.yudizapplication.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import com.example.yudizapplication.R

class ChatDetailsFragment : Fragment(R.layout.fragment_chat_details) {

    lateinit var frag_btn_1: Button
    lateinit var frag_btn_2: Button


    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0){
                    childFragmentManager.popBackStack()
                    return
                }
                parentFragmentManager.popBackStack()
                requireActivity().finish()
            }

        }
        requireActivity().onBackPressedDispatcher.addCallback(this,callback)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        frag_btn_1 = view.findViewById(R.id.start_1)
        frag_btn_2 = view.findViewById(R.id.start_2)


        frag_btn_1.setOnClickListener{
            val transition = childFragmentManager.beginTransaction()
            transition.replace(R.id.hold_frag, fragment_child_1())
            transition.addToBackStack("f1")
            transition.commit()
        }
        frag_btn_2.setOnClickListener{
            val transition = childFragmentManager.beginTransaction()
            transition.replace(R.id.hold_frag, fragment_child_2())
            transition.addToBackStack("f2")
            transition.commit()
        }

    }
}