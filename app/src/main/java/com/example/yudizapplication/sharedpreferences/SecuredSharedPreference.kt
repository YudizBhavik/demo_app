package com.example.yudizapplication.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.yudizapplication.R

class SecuredSharedPreference : AppCompatActivity() {

    lateinit var Fname : EditText
    lateinit var Lname : EditText
    lateinit var btn_submit : Button

    lateinit var masterKeysAlias : String
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secured_shared_preference)


        masterKeysAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
         sharedPreferences = EncryptedSharedPreferences.create(
            "MySharePreferences",
            masterKeysAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        val editor = sharedPreferences.edit()

         Fname = findViewById(R.id.edit_fname_secure)
         Lname = findViewById(R.id.edit_lname_secure)
         btn_submit = findViewById(R.id.btn_secure_submit)


        btn_submit.setOnClickListener {
            editor.putString("Fname",Fname.text.toString()).apply()
            editor.putString("Lname",Lname.text.toString()).apply()
            intent = Intent(applicationContext,ViewSecuresShared::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        if (sharedPreferences.contains("Fname") && sharedPreferences.contains("Lname")){
            intent = Intent(applicationContext,ViewSecuresShared::class.java)
            startActivity(intent)
        }
    }
}