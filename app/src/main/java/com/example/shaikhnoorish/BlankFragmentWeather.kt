package com.example.shaikhnoorish

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragmentWeather.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragmentWeather : Fragment() , NewsListAdapter.NewsItemClicked {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_weather, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        var piclist: ArrayList<String> = ArrayList<String>()
        piclist.add("https://cdn.pixabay.com/photo/2021/08/29/13/19/kingfisher-6583229_960_720.jpg")
        piclist.add("https://www.istockphoto.com/photo/common-kingfisher-alcedo-atthis-gm1221807406-358292036?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_photo_sponsored&referrer_url=&utm_term=kingfisher%20bird")
        piclist.add("https://www.istockphoto.com/photo/common-european-kingfisher-emerging-abstract-gm1202608530-345336416")
        piclist.add("https://www.istockphoto.com/photo/male-kingfisher-with-minnow-gm471851743-26724682")
        piclist.add("https://www.istockphoto.com/photo/kingfisher-alcedo-atthis-gm471846571-26692591")

        val urlwether: String =
            "http://api.openweathermap.org/data/2.5/weather?q=ahmedabad&APPID=6fb2e20257d0f9a75e5ef83d0cab810e"
        val i: Int = 0
        var list: ArrayList<News> = ArrayList<News>()
        var adapter: NewsListAdapter
        var recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val stringRequest =
            object : StringRequest(Request.Method.GET, urlwether, Response.Listener { response ->
                //val jsonObject: JSONObject = JSONObject(response)
                Log.e("resss>>>>", response)
                val jsonObject: JSONObject = JSONObject(response)

                val ja: JSONArray = jsonObject.getJSONArray("weather")

                for (i in 0 until ja.length()) {
                    val jsonObject1: JSONObject = ja.getJSONObject(i)
                    val id:String=jsonObject1.getString("id")
                    val main:String=jsonObject1.getString("main")
                    val icon:String=jsonObject1.getString("icon")
                    val datamodel = News()
                    datamodel.text1 = id
                    datamodel.text2 = main
                    datamodel.text3 = ""
                    datamodel.urlToImage = piclist.get(i)
                    list.add(datamodel)
//                    val jsonObject22=jsonObject.getJSONObject("base")
//                    val ja2:JSONArray=jsonObject.getJSONArray("main")
//                    for (i2 in 0 until ja2.length()){
//                        val jsonObject22:JSONObject=ja2.getJSONObject(i2)
//                        val temp:String=jsonObject22.getString("temp")
//
//
//                    }

                }

                adapter = NewsListAdapter(context, list,this)
                val layoutManager = LinearLayoutManager(context)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = adapter

            }, Response.ErrorListener {
                Log.e("error>>>>", it.toString())

            }) {

                override fun getHeaders(): Map<String, String> {
                    val params: MutableMap<String, String> = HashMap()
                    params["User-Agent"] = "Mozilla/5.0"
                    return params
                }
            }
                val queue = Volley.newRequestQueue(context)
                queue.add(stringRequest)


    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): BlankFragmentWeather {
            return BlankFragmentWeather().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onListClicked(list: News) {
      val intent=Intent(context,MainActivity4::class.java)
        intent.putExtra("text1",list.text1)
        intent.putExtra("text2",list.text2)
        intent.putExtra("text3",list.text3)
        intent.putExtra("text4",list.text4)
        startActivity(intent)
    }
}