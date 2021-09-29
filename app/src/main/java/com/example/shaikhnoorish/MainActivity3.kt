package com.example.shaikhnoorish

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_data.*
import kotlinx.android.synthetic.main.item_data.view.*

class MainActivity3 : AppCompatActivity() {
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        textView1 = findViewById(R.id.tv1)
        textView2 = findViewById(R.id.tv2)
        textView3 = findViewById(R.id.tv3)
        imageView = findViewById(R.id.image1)

        val screen = intent.getStringExtra("text1")
        val screen2 = intent.getStringExtra("text2")
        val screen3 = intent.getStringExtra("text3")
        val screen4 = intent.getStringExtra("urlToImage")
        Log.d(TAG,"screen>>>"+screen)
        Log.d(TAG,"screen>>>"+screen2)
        Log.d(TAG,"screen>>>"+screen3)
        Log.d(TAG,"screen>>>"+screen4)
        textView1.text=screen
        textView2.text=screen2
        textView3.text=screen3
        Glide.with(this).load(screen4).into(imageView)
       //imageView.

        

    }
}