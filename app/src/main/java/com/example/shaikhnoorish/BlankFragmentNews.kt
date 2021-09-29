package com.example.shaikhnoorish

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.item_data.*
import org.json.JSONArray
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragmentNews.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragmentNews : Fragment(), NewsListAdapter.NewsItemClicked {
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
        return inflater.inflate(R.layout.fragment_blank_news, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val urlwether :String=
//            "api.openweathermap.org/data/2.5/weather?q=ahmedabad&APPID=6fb2e20257d0f9a75e5ef83d0cab810e"
        val url: String =
            "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9080db8748044ce7bf94ebfabc0592ff"
        val i: Int = 0
        var list: ArrayList<News> = ArrayList<News>()
        var adapter: NewsListAdapter
        var recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val urlstringRequest1 = object : StringRequest(
            Request.Method.GET, url, Response.Listener { response ->
                list = ArrayList<News>()
                // val getRequest = object : JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {
                val jsonObject: JSONObject = JSONObject(response)
                Log.e("resss>>>>", response)
                val ja: JSONArray = jsonObject.getJSONArray("articles")

                for (i in 0 until ja.length()) {
                    val jsonObject1: JSONObject = ja.getJSONObject(i)
                    val title: String = jsonObject1.getString("title")
                    val description: String = jsonObject1.getString("description")
                    val publishedAt: String = jsonObject1.getString("publishedAt")
                    val urlToImage: String = jsonObject1.getString("urlToImage")

                    val datamodel = News()
                    datamodel.text1 = title
                    datamodel.text2 = description
                    datamodel.text3 = publishedAt
                    datamodel.urlToImage = urlToImage
                    list.add(datamodel)


                    adapter = NewsListAdapter(context, list, this)
                    val layoutManager = LinearLayoutManager(context)
                    recyclerView.layoutManager = layoutManager
                    recyclerView.adapter = adapter
                }

            },
            Response.ErrorListener { error ->
                Log.e("error>>>>>>", error.toString())
            }) {

            override fun getHeaders(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["User-Agent"] = "Mozilla/5.0"
                return params
            }
        }

        var queue = Volley.newRequestQueue(context)
        queue.add(urlstringRequest1)


        val builder=CustomTabsIntent.Builder()
        val customTabsIntent =builder.build()
       // customTabsIntent.launchUrl(requireContext(), Uri.parse(url))

//        val urlstringRequest2 =
//            object : StringRequest(Request.Method.GET, urlwether, Response.Listener { response ->
//                Log.e("resss>>>>", response)

//                val jsonObject: JSONObject = JSONObject(response)
//
//                val ja: JSONArray = jsonObject.getJSONArray("weather")
//                val title:String=jsonObject.getString("title")
//                val main:String=jsonObject.getString("main")
//                val icon:String=jsonObject.getString("icon")
//                val id: String = ja.getString("id")
//                val main: String = ja.getString("main")
//                val icon: String = ja.getString("icon")




//
//            }, Response.ErrorListener {
//                Log.e("resss>>>>", it.toString())
//
//            }) {
//
//                override fun getHeaders(): Map<String, String> {
//                    val params: MutableMap<String, String> = HashMap()
//                    params["User-Agent"] = "Mozilla/5.0"
//                    return params
//                }
//            }
//
//        var queue1 = Volley.newRequestQueue(context)
//        queue1.add(urlstringRequest2)




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
        fun newInstance(sectionNumber: Int): BlankFragmentNews {
            return BlankFragmentNews().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onListClicked(list: News) {

        val intent = Intent(context, MainActivity3::class.java)
        intent.putExtra("text1", list.text1)
        intent.putExtra("text2", list.text2)
        intent.putExtra("text3", list.text3)
        intent.putExtra("urlToImage",list.urlToImage)
        startActivity(intent)



        Log.d("ppkkkmkm>>>", list.text1)
        Log.d("ppkkkmkm>>>", list.text2)
        Log.d("ppkkkmkm>>>", list.text3)
        Log.d("ppkkkmkm>>>", list.urlToImage)

    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment BlankFragmentNews.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: Int, param2: String) =
//            BlankFragmentNews().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
          //  }
    //}
}