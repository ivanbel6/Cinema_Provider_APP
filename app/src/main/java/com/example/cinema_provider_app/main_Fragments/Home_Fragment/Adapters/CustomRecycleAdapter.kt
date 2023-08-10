package com.example.cinema_provider_app.main_Fragments.Home_Fragment.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema_provider_app.R
import com.example.cinema_provider_app.main_Fragments.Home_Fragment.Data_Classes.CustomDataClass
import com.example.cinema_provider_app.main_Fragments.Home_Fragment.HomeFragment

class CustomRecycleAdapter(private val list: List<CustomDataClass>,private val homeFragment: HomeFragment) :
    RecyclerView.Adapter<CustomRecycleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val createItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_custom_type, parent, false)
        return ViewHolder(createItem)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.bgImage.setImageResource(currentItem.bgImage)
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        holder.rating.text = currentItem.Rating
        holder.genre.text = currentItem.Genre
        holder.icon1.setOnClickListener {

            homeFragment.placeHolder("icon1")
        }




    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val bgImage: ImageView = item.findViewById(R.id.cardBackgroundImage)
        val icon1: ImageView = item.findViewById(R.id.icon1)
        val title : TextView = item.findViewById(R.id.Title)
        val description : TextView = item.findViewById(R.id.description)
        val rating  : TextView = item.findViewById(R.id.Rating)
        val genre : TextView = item.findViewById(R.id.Genre)
        init {
            icon1.setOnClickListener {}

        }



    }



}
