package com.example.shaikhnoorish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MainActivity4 : AppCompatActivity() {
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        textView1 = findViewById(R.id.tv11)
        textView2 = findViewById(R.id.tv12)
        textView3 = findViewById(R.id.tv13)
        imageView = findViewById(R.id.image1)
        val screen=intent.getStringExtra("text1")
        val screen2=intent.getStringExtra("text2")
        val screen3=intent.getStringExtra("text3")
        val screen4=intent.getStringExtra("urlToImage")
        textView1.text=screen
        textView2.text=screen2
        textView3.text=screen3
        Glide.with(this).load(screen4).into(imageView)


    }
}