package com.example.yudizapplication.coil

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import coil.ImageLoader
import coil.decode.ImageDecoderDecoder
import coil.load
import coil.request.CachePolicy
import coil.transform.RoundedCornersTransformation
import com.example.yudizapplication.R

class CoilExample : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coil_example)

        val btn_image_load = findViewById<Button>(R.id.btn_coli_loadimg)
        val imageView_image_load = findViewById<ImageView>(R.id.imageview_coil)
        val btn_gif_load = findViewById<Button>(R.id.btn_coli_load_gif)
        val imageView_gif_load = findViewById<ImageView>(R.id.imageview_gif_coil)

        btn_image_load.setOnClickListener {
            val url = "https://picsum.photos/200/300"
           imageView_image_load.load(url)
           {
               diskCachePolicy(CachePolicy.DISABLED)
               memoryCachePolicy(CachePolicy.DISABLED)
           }
        }

        btn_gif_load.setOnClickListener {
            val url_gif =
                "https://user-images.githubusercontent.com/14011726/94132137-7d4fc100-fe7c-11ea-8512-69f90cb65e48.gif"

            val imageLoader = ImageLoader.Builder(this)
                .components {
                    if (SDK_INT >= 28) {
                        add(ImageDecoderDecoder.Factory())
                    } else {
                        add(coil.decode.GifDecoder.Factory())
                    }
                }
                .build()
            imageView_gif_load.load(url_gif, imageLoader = imageLoader)
        }

    }
}