package com.example.yudizapplication.IntentExample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.R

class IntentExample : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intent_example)

       val Send_Email = findViewById<Button>(R.id.btn_send)

        val recipitentET = findViewById<EditText>(R.id.edit_recipitent)
        val subject_mailET = findViewById<EditText>(R.id.edit_subject)
        val message_mailET = findViewById<EditText>(R.id.edit_message)

        val btn_next = findViewById<Button>(R.id.btn_next)

        btn_next.setOnClickListener {
            intent = Intent(applicationContext,SendText::class.java)
            startActivity(intent)
        }

        Send_Email.setOnClickListener{
             val sentTO = recipitentET.text.toString().trim()
             val subject = subject_mailET.text.toString().trim()
             val message = message_mailET.text.toString().trim()
             sendmail(sentTO,subject,message)
         }
    }

    private  fun sendmail (recipient: String, subject: String, message: String){
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT,message)


        try {
            startActivity(Intent.createChooser(mIntent,"Choose mail client..."))
        }catch (e: Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
        }
    }
}