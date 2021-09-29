package com.example.shaikhnoorish

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsListAdapter(val context: Context?, val list: ArrayList<News>,val listener:NewsItemClicked ) :
    RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

//    private val inflater: LayoutInflater =
//        context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewtitle: TextView = view.findViewById(R.id.text1)
        val textViewdis: TextView = view.findViewById(R.id.text2)
        val textViewpubAd: TextView = view.findViewById(R.id.text3)
        val textView4:TextView=view.findViewById(R.id.text4)
        val textView5:TextView=view.findViewById(R.id.text5)
        val textView6:TextView=view.findViewById(R.id.text6)

        val imageView: ImageView = view.findViewById(R.id.image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowView = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
       //return ViewHolder(rowView)
        val viewHolder=ViewHolder(rowView)
        rowView.setOnClickListener{
            listener.onListClicked(list[viewHolder.adapterPosition])
        }
        return viewHolder


//        val rowView1=inflater.inflate(R.layout.weatherlist,parent,false)
//        return ViewHolder(rowView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewtitle.text = list.get(position).text1
        holder.textViewdis.text = list.get(position).text2
        holder.textViewpubAd.text = list.get(position).text3
        holder.textView4.text=list.get(position).text4
        holder.textView5.text=list.get(position).text5
        holder.textView6.text=list.get(position).text6
        context?.let {
            Glide.with(it)
                .load(list.get(position).urlToImage)
                .into(holder.imageView)

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
    interface  NewsItemClicked{
        fun onListClicked(list: News)
    }
//    private val items: ArrayList<News> = ArrayList()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
//        val viewHolder = NewsViewHolder(view)
//        view.setOnClickListener{
//            listener.onItemClicked(items[viewHolder.adapterPosition])
//        }
//        return viewHolder
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//
//    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
//        val currentItem = items[position]
//        holder.titleView.text = currentItem.title
//        holder.author.text = currentItem.description
//        Glide.with(holder.itemView.context).load(currentItem.urlToImage).into(holder.image)
//    }
//
//    fun updateNews(updatedNews: ArrayList<News>) {
//        items.clear()
//        items.addAll(updatedNews)
//
//        notifyDataSetChanged()
//    }
//}
//
//class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    val titleView: TextView = itemView.findViewById(R.id.title)
//    val image: ImageView = itemView.findViewById(R.id.image)
//    val author: TextView = itemView.findViewById(R.id.author)
//}
//
//interface NewsItemClicked {
//    fun onItemClicked(item: News)
}