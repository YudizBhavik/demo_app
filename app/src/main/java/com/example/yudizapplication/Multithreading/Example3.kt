package com.example.yudizapplication.Multithreading

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R

class Example3 : AppCompatActivity() {
    private lateinit var textViewCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example3)

        textViewCounter = findViewById(R.id.counter_text)
        val btn_start = findViewById<Button>(R.id.btn_start)

        btn_start.setOnClickListener {
            CounterTask().execute()
        }
    }

    private inner class CounterTask : AsyncTask<Void, Int, Void>() {
        private var count = 0

        override fun doInBackground(vararg params: Void?): Void? {
            while (count < 10) {
                if (isCancelled) break
                count++
                publishProgress(count)
                Thread.sleep(1000)
            }
//
            if (count > 1){
                cancel(true)
            }
            return null
        }

        override fun onPreExecute() {
            Toast.makeText(this@Example3, "Async Task start", Toast.LENGTH_SHORT).show()
        }
        override fun onProgressUpdate(vararg values: Int?) {
            textViewCounter.text = values[0].toString()
        }

        override fun onPostExecute(result: Void?) {
            Toast.makeText(this@Example3, "Async Task completed", Toast.LENGTH_SHORT).show()
        }

        override fun onCancelled() {
            Toast.makeText(this@Example3, "Async Task completed", Toast.LENGTH_SHORT).show()
        }
    }
}