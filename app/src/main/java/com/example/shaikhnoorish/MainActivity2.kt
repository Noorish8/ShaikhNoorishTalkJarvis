package com.example.shaikhnoorish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONArray
import org.json.JSONObject

class MainActivity2 : AppCompatActivity() {
//    lateinit var textView: TextView
//    val urlwether :String=
//         "api.openweathermap.org/data/2.5/weather?q=ahmedabad&APPID=6fb2e20257d0f9a75e5ef83d0cab810e"

//    val url: String =
//        "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9080db8748044ce7bf94ebfabc0592ff"
//    val i: Int = 0
//    var list:ArrayList<News> = ArrayList<News>()
//    lateinit var adapter: NewsListAdapter
//    lateinit var recyclerView: RecyclerView

    lateinit var newsradio:RadioButton
    lateinit var weatherradio:RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //textView=findViewById(R.id.temp)

        newsradio = findViewById(R.id.radio0)
        weatherradio = findViewById(R.id.radio2)

        newsradio.setOnClickListener {
            val fragment = BlankFragmentNews()
            supportFragmentManager.beginTransaction().replace(R.id.fram, fragment).commit()
            true
        }
        weatherradio.setOnClickListener {
            val fragment = BlankFragmentWeather()
            supportFragmentManager.beginTransaction().replace(R.id.fram, fragment).commit()
            true
//            val intent=Intent(this,MainActivity2::class.java)
//            startActivity(intent)
//            true
        }


//        val fragment = BlankFragmentNews()
//        supportFragmentManager.beginTransaction().replace(R.id.fram, fragment).commit()
//        true
//
//        weatherradio.setOnClickListener {
//            val fragment2 = BlankFragmentWeather()
//            supportFragmentManager.beginTransaction().replace(R.id.fram, fragment).commit()
//            true

    }

    }
