package com.example.cinema_provider_app.main_Fragments.Home_Fragment.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema_provider_app.R
import com.example.cinema_provider_app.main_Fragments.Home_Fragment.Data_Classes.SlideItem
import com.google.android.material.imageview.ShapeableImageView

class SliderAdapter(private val itemList: List<SlideItem>) :
    RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleTextView)
        val description: TextView = itemView.findViewById(R.id.descriptionTextView)
        val image: ShapeableImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slide_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.title.text = item.title
        holder.description.text = item.description
        holder.image.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}

