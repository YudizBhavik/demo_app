package com.example.yudizapplication.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.yudizapplication.R

class ViewSecuresShared : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_secures_shared)

        val btn_clear = findViewById<Button>(R.id.btn_clear_serure)
        val text_fname = findViewById<TextView>(R.id.text_show_fname)
        val text_lname = findViewById<TextView>(R.id.text_show_lname)
        val masterKeysAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)


        val sharedPreferences = EncryptedSharedPreferences.create(
            "MySharePreferences",
            masterKeysAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        val secure_editor = sharedPreferences.edit()
        val editText_Fname = sharedPreferences.getString("Fname","")
        val editText_Lname = sharedPreferences.getString("Lname","")

        text_fname.setText(editText_Fname)
        text_lname.setText(editText_Lname)


        btn_clear.setOnClickListener(View.OnClickListener {

            secure_editor.remove("Fname")
            secure_editor.remove("Lname")
            secure_editor.clear()
            secure_editor.apply()
            intent = Intent(this, SecuredSharedPreference::class.java)
            startActivity(intent)
        })
    }
}