package com.example.yudizapplication.Multithreading
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.R


class Example2 : AppCompatActivity() {
    private lateinit var temp_result_txt : TextView
    private lateinit var result_txt : TextView

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_task2)

        temp_result_txt = findViewById(R.id.temp_result_txt)
        result_txt = findViewById(R.id.result_txt)
        startMultithreadingProcess(5)
    }
    private fun startMultithreadingProcess(value: Int) {
        Thread {
            val tempResult = value + 10
            handler.post {
                temp_result_txt.text = "Temp Result: $tempResult"
            }
            Thread {
                val finalResult = tempResult * 2
                handler.post {
                    result_txt.text = "Final Result: $finalResult"
                }
            }.start()
        }.start()
    }
}

