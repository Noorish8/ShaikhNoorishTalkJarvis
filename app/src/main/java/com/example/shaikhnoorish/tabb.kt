package com.example.shaikhnoorish

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.myapplication.ui.main.SectionsPagerAdapter
import com.example.shaikhnoorish.databinding.ActivityTabbBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class tabb : AppCompatActivity() {


    private lateinit var binding: ActivityTabbBinding
    lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityTabbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomNavigationView=findViewById(R.id.bottomNavigationView)
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

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)


//        val sharedPreferences: SharedPreferences =
//            this.getSharedPreferences("user", Context.MODE_PRIVATE)
//        val sharevalue=sharedPreferences.getString("name","")
//        if (sharevalue.equals("")){
//            Log.e("name",sharevalue+"")
//        }else{
//            textView.setText(sharevalue)
//        }


    }
}