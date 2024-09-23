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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shared_preferences_example)
        val edit_firstname = findViewById<EditText>(R.id.edit_fname)
        val edit_lastname = findViewById<EditText>(R.id.edit_lname)
        val edit_email = findViewById<EditText>(R.id.edit_email)
        val edit_dob = findViewById<EditText>(R.id.edit_dob)
        val edit_phone = findViewById<EditText>(R.id.edit_phone)
        val edit_address = findViewById<EditText>(R.id.edit_address)
        val btn_submit = findViewById<Button>(R.id.btn_submit)
        val btn_view = findViewById<Button>(R.id.btn_view)
        val btn_clear = findViewById<Button>(R.id.btn_clear)

        val txt_show_fname = findViewById<TextView>(R.id.textShowFName)
        val txt_show_lname = findViewById<TextView>(R.id.textShowLName)
        val txt_show_email = findViewById<TextView>(R.id.textShowEmail)
        val txt_show_dob = findViewById<TextView>(R.id.textShowDOB)
        val txt_show_phone = findViewById<TextView>(R.id.textShowPhone)
        val txt_show_address = findViewById<TextView>(R.id.textShowAddress)

        val sharedPreferences = getSharedPreferences("Yudiz_sharedPreferences", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()


        btn_submit.setOnClickListener(
            View.OnClickListener {
                val phone:String = edit_phone.text.toString()
                myEdit.putString("edit_firstname", edit_firstname.text.toString())
                myEdit.putString("edit_lastname", edit_lastname.text.toString())
                myEdit.putString("edit_email", edit_email.text.toString())
                myEdit.putString("edit_dob", edit_dob.text.toString())
                myEdit.putString("edit_phone", edit_phone.text.toString())
                myEdit.putString("edit_address", edit_address.text.toString())
                myEdit.apply()
                myEdit.commit()
            }
        )

        btn_view.setOnClickListener {
            val sh = getSharedPreferences("Yudiz_sharedPreferences", MODE_PRIVATE)
                val shfirstname = sh.getString("edit_firstname", "")
                val shlastname = sh.getString("edit_lastname", "")
                val shemail = sh.getString("edit_email", "")
                val shdob = sh.getString("edit_dob", "")
                val shphone = sh.getString("edit_phone", "")
                val shaddress = sh.getString("edit_address", "")

            if (shfirstname.equals("") && shlastname.equals("") && shemail.equals("") && shdob.equals("") && shphone.equals("") && shaddress.equals("")){
                txt_show_fname.setText("FirstName").toString()
                txt_show_lname.setText("LastName").toString()
                txt_show_lname.setText("Email").toString()
                txt_show_lname.setText("DOB").toString()
                txt_show_lname.setText("Phone").toString()
                txt_show_lname.setText("Address").toString()
            }else{
                txt_show_fname.setText(shfirstname).toString()
                txt_show_lname.setText(shlastname).toString()
                txt_show_email.setText(shemail).toString()
                txt_show_dob.setText(shdob).toString()
                txt_show_phone.setText(shphone).toString()
                txt_show_address.setText(shaddress).toString()
            }
        }
        btn_clear.setOnClickListener(View.OnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            edit_firstname.setText("").toString()
            edit_lastname.setText("").toString()
            edit_email.setText("").toString()
            edit_dob.setText("").toString()
            edit_phone.setText("").toString()
            edit_address.setText("").toString()
        })
    }
}