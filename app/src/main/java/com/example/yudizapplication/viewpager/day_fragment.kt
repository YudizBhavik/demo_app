package com.example.weatherapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import android.widget.TextView
import com.example.yudizapplication.R

class DayFragment : Fragment() {


        companion object {
            private const val days = "day"
            private const val images = "imageResId"

            fun newInstance(day: String, imageResId: Int): DayFragment {
                val fragment = DayFragment()
                val bundle = Bundle().apply {
                    putString(days, day)
                    putInt(images, imageResId)
                }
                fragment.arguments = bundle
                return fragment
            }
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_day_fragment, container, false)

            // Retrieve day and image resource ID from arguments
            val day = arguments?.getString(days)
            val imageResId = arguments?.getInt(images)

            // Set day name in TextView
            val forecastTextView: TextView = view.findViewById(R.id.weatherInfoTextView)
            forecastTextView.text = "$day"

            // Set image as background
            val imageView: ImageView = view.findViewById(R.id.sunny_img_frag)
            imageResId?.let {
                imageView.setImageResource(it)
            }

            return view
        }
}