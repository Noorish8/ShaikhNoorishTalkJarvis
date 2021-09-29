package com.example.shaikhnoorish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.gms.common.SignInButton

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var signInButton: SignInButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView=findViewById(R.id.img)
        signInButton=findViewById(R.id.google)
        signInButton.setOnClickListener {
            val intent=Intent(this,Logginpg::class.java)
            startActivity(intent)
        }

    }
}