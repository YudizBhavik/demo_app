package com.example.weatherapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView
import com.example.yudizapplication.R

class DayFragment : Fragment() {

    companion object {
        private const val ARG_WEATHER_INFO = "weather_info"

        fun newInstance(weatherInfo: String): DayFragment {
            val fragment = DayFragment()
            val args = Bundle()
            args.putString(ARG_WEATHER_INFO, weatherInfo)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_monday_fragment, container, false)
        val weatherInfoTextView: TextView = view.findViewById(R.id.weatherInfoTextView)

        val weatherInfo = arguments?.getString(ARG_WEATHER_INFO)
        weatherInfoTextView.text = weatherInfo

        return view
    }
}
