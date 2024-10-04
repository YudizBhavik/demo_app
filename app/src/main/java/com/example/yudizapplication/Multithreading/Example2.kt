package com.example.yudizapplication.Multithreading

import android.os.*
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R


class Example2 : AppCompatActivity() {

    private var number = 10
    private lateinit var tempTxt: TextView
    private lateinit var resultTxt: TextView

    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                1 -> {
                    val operation1Result = msg.arg1
                    tempTxt.text = "Result after 1st thread: $operation1Result"

                }
                2 -> {
                    val finalResult = msg.arg1
                    resultTxt.text = "Final result after 2nd thread: $finalResult"
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_task2)

        tempTxt = findViewById(R.id.temp_result_txt)
        resultTxt = findViewById(R.id.result_txt)

        val thread1 = Thread {
            val operation1Result = number * 2
            val message = handler.obtainMessage(1, operation1Result, 0)
            handler.sendMessage(message)
        }
        thread1.start()


         val thread2 = Thread {
//         val operation2Result = operation1Result + 10
//         val message = handler.obtainMessage(2, operation2Result, 0)

//            handler.sendMessage(message)
        }
        thread2.start()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

