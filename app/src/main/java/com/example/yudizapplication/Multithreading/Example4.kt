package com.example.yudizapplication.Multithreading

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Example4 : AppCompatActivity() {
    lateinit var result_txt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_example4)

        result_txt = findViewById(R.id.resultTextView)

        performOperation()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun performOperation() {
        GlobalScope.launch (Dispatchers.Main){
            val result = withContext(Dispatchers.Default)
            {
                complexCalculation()
            }
            result_txt.text = "Result is $result"
        }
    }

    private fun complexCalculation() : Int {
        var sum = 0
        for(i in 1..1000){
            sum += i
        }
        return sum
    }
}