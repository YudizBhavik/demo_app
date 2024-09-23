package com.example.yudizapplication.sharedpreferences

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secured_shared_preference)

         Fname = findViewById(R.id.edit_fname)
         Lname = findViewById(R.id.edit_lname)

    }

    override fun onResume() {
        super.onResume()

        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        val sharedPreferences = EncryptedSharedPreferences.create(
            "MySharePreferences",
            masterKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        val editText_Fname = sharedPreferences.getString("Fname","")
        val editText_Lname = sharedPreferences.getString("Lname","")

        Fname.setText(editText_Fname)
        Lname.setText(editText_Lname)
    }

    override fun onPause() {
        super.onPause()
        val masterKeysAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        val sharedPreferences = EncryptedSharedPreferences.create(
            "MySharePreferences",
            masterKeysAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        sharedPreferences.edit().putString("Fname",Fname.text.toString()).apply()
        sharedPreferences.edit().putString("Lname",Lname.text.toString()).apply()
    }

}