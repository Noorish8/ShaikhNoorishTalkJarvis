package com.example.shaikhnoorish

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {
    lateinit var textViewName: TextView
    lateinit var textViewemail: TextView
    lateinit var button: Button
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        bottomNavigationView=findViewById(R.id.bottomNavigationView)
        textViewName=findViewById(R.id.prof1email)
        textViewemail=findViewById(R.id.prof2pass)
        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences("user", Context.MODE_PRIVATE)
        val sharevalue=sharedPreferences.getString("username","")
        if (sharevalue.equals("")){
            Log.e("name",sharevalue+"")
        }else{
            textViewName.setText(sharevalue)
        }

        button=findViewById(R.id.btn)
        button.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.home->{
                    val intent=Intent(this,tabb::class.java)
                    startActivity(intent)
                    true
                }
                R.id.date->{
                    true
                }
                R.id.assign->{
                    val intent=Intent(this,Profile::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

    }
}