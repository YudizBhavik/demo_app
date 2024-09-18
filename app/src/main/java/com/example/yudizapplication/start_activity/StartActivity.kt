package com.example.yudizapplication.start_activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.R
import de.hdodenhof.circleimageview.CircleImageView

class StartActivity : AppCompatActivity() {
    private lateinit var nameTxtView: TextView
    private lateinit var emailTxtView: TextView
    private lateinit var phoneTxtView: TextView
    private lateinit var profileImgView: CircleImageView
    private lateinit var pickImageLauncher : ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start)

            nameTxtView = findViewById(R.id.text_view_name)
            emailTxtView = findViewById(R.id.text_view_email)
            phoneTxtView = findViewById(R.id.text_view_phone)
            profileImgView = findViewById(R.id.profile_image)

            findViewById<Button>(R.id.btn_update_profile).setOnClickListener {
                val intent = Intent(this, UpdateProfile::class.java)
                intent.putExtra("name", nameTxtView.text.toString())
                intent.putExtra("email", emailTxtView.text.toString())
                intent.putExtra("phone", phoneTxtView.text.toString())
                startActivityForResult(intent, 100)
            }

        pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()){
            uri : Uri? -> uri?.let {
                profileImgView.setImageURI(it)
        }
        }
        profileImgView.setOnClickListener{
            pickImageLauncher.launch("image/*")
    }
    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (resultCode == Activity.RESULT_OK) {
                when (requestCode) {
                    100 -> {
                        nameTxtView.text = data?.getStringExtra("updatedName")
                        emailTxtView.text = data?.getStringExtra("updatedEmail")
                        phoneTxtView.text = data?.getStringExtra("updatedPhone")
                    }
                }
            }
        }
    }