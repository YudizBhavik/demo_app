package com.example.yudizapplication.dataBinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.yudizapplication.BR
import com.example.yudizapplication.R
import com.example.yudizapplication.databinding.ActivityDataBindingExampleBinding

class DataBindingExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityDataBindingExampleBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_data_binding_example)

        val user = User(
            "Bhavik",
            "bhavikmakvana8@gmail.com",
            25,
            "Jamnagar",
            "https://img.freepik.com/free-photo/abstract-autumn-beauty-multi-colored-leaf-vein-pattern-generated-by-ai_188544-9871.jpg?size=626&ext=jpg&ga=GA1.1.2008272138.1728432000&semt=ais_hybrid"
        )
        binding.setVariable(BR.user, user)
        binding.executePendingBindings()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
