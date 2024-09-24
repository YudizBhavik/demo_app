package com.example.yudizapplication.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R
import com.example.yudizapplication.user_permission.ShowContact

class SharedPreferencesExample : AppCompatActivity() {

    lateinit var edit_firstname : EditText
    lateinit var edit_lastname : EditText
    lateinit var edit_email : EditText
    lateinit var edit_dob : EditText
    lateinit var edit_phone : EditText
    lateinit var edit_address : EditText
    lateinit var btn_submit   : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shared_preferences_example)
         edit_firstname = findViewById(R.id.edit_fname)
         edit_lastname = findViewById(R.id.edit_lname)
         edit_email = findViewById(R.id.edit_email)
         edit_dob = findViewById(R.id.edit_dob)
         edit_phone = findViewById(R.id.edit_phone)
         edit_address = findViewById(R.id.edit_address)
         btn_submit = findViewById(R.id.btn_submit)


        val sharedPreferences = getSharedPreferences("Yudiz_sharedPreferences", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        val btn_next = findViewById<Button>(R.id.btn_next)

        btn_next.setOnClickListener{

                val intent = Intent(this,SecuredSharedPreference::class.java)
                startActivity(intent)
            }

        btn_submit.setOnClickListener(
            View.OnClickListener {
                myEdit.putString("edit_firstname", edit_firstname.text.toString())
                myEdit.putString("edit_lastname", edit_lastname.text.toString())
                myEdit.putString("edit_email", edit_email.text.toString())
                myEdit.putString("edit_dob", edit_dob.text.toString())
                myEdit.putString("edit_phone", edit_phone.text.toString())
                myEdit.putString("edit_address", edit_address.text.toString())
                myEdit.apply()
                myEdit.commit()
                intent = Intent(this,ViewSharedPrefe::class.java)
                startActivity(intent)
            }
        )



    }

    override fun onResume() {
        super.onResume()

        val sh = getSharedPreferences("Yudiz_sharedPreferences", MODE_PRIVATE)
        if (sh.contains("edit_firstname") && sh.contains("edit_lastname") && sh.contains("edit_email") && sh.contains("edit_dob") && sh.contains("edit_phone") && sh.contains("edit_address")){
            intent = Intent(this,ViewSharedPrefe::class.java)
            startActivity(intent)
        }
    }
}