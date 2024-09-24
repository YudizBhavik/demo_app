package com.example.yudizapplication.sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R

class ViewSharedPrefe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_shared_prefe)

        val sharedPreferences = getSharedPreferences("Yudiz_sharedPreferences", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        val txt_show_fname = findViewById<TextView>(R.id.textShowFName)
        val txt_show_lname = findViewById<TextView>(R.id.textShowLName)
        val txt_show_email = findViewById<TextView>(R.id.textShowEmail)
        val txt_show_dob = findViewById<TextView>(R.id.textShowDOB)
        val txt_show_phone = findViewById<TextView>(R.id.textShowPhone)
        val txt_show_address = findViewById<TextView>(R.id.textShowAddress)

        val btn_clear = findViewById<Button>(R.id.btn_clear)

        val sh = getSharedPreferences("Yudiz_sharedPreferences", MODE_PRIVATE)
        val shfirstname = sh.getString("edit_firstname", "")
        val shlastname = sh.getString("edit_lastname", "")
        val shemail = sh.getString("edit_email", "")
        val shdob = sh.getString("edit_dob", "")
        val shphone = sh.getString("edit_phone", "")
        val shaddress = sh.getString("edit_address", "")


        txt_show_fname.setText(shfirstname).toString()
        txt_show_lname.setText(shlastname).toString()
        txt_show_email.setText(shemail).toString()
        txt_show_dob.setText(shdob).toString()
        txt_show_phone.setText(shphone).toString()
        txt_show_address.setText(shaddress).toString()


        btn_clear.setOnClickListener(View.OnClickListener {

            myEdit.remove("edit_firstname")
            myEdit.remove("edit_lastname")
            myEdit.remove("edit_email")
            myEdit.remove("edit_dob")
            myEdit.remove("edit_phone")
            myEdit.remove("edit_address")
            myEdit.clear()
            myEdit.apply()
            intent = Intent(this,SharedPreferencesExample::class.java)
            startActivity(intent)
        })


    }
}