package com.example.yudizapplication.glide

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.yudizapplication.R
import com.example.yudizapplication.databinding.ActivityGlideExampleBinding
import com.example.yudizapplication.databinding.ActivityMainBinding

class GlideExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_glide_example)

        val btn_image_load = findViewById<Button>(R.id.btn_loadimage_glide)
        val btn_gif_load = findViewById<Button>(R.id.btn_gif_load)
        val imageView_image_load = findViewById<ImageView>(R.id.imageview_glide)
        val imageView_gif_load = findViewById<ImageView>(R.id.gif_glide)

        btn_gif_load.setOnClickListener {
            val url = "https://user-images.githubusercontent.com/14011726/94132137-7d4fc100-fe7c-11ea-8512-69f90cb65e48.gif"
            Glide.with(this)
                .load(url)
                .into(imageView_gif_load)
        }


       btn_image_load.setOnClickListener {
           val url = "https://picsum.photos/200/300"


           Glide.with(this)
               .load(url)
               .skipMemoryCache(true)
               .diskCacheStrategy(DiskCacheStrategy.NONE)
               .placeholder(R.drawable.placeholder)
               .into(imageView_image_load)
       }
    }
}