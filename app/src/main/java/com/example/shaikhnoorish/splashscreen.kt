package com.example.shaikhnoorish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        val imageView:ImageView=findViewById(R.id.img)

        Handler().postDelayed({
            val intent=Intent(this,tabb::class.java)
            startActivity(intent)
            finish()
        },400L)
    }
}