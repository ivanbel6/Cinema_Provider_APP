package com.example.cinema_provider_app.main_Fragments.Home_Fragment.Adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema_provider_app.R
import com.example.cinema_provider_app.main_Fragments.Home_Fragment.Data_Classes.FirstDataType

class FirstTypeAdapter(private var list: List<FirstDataType>) :
    RecyclerView.Adapter<FirstTypeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val createItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.first_type_recycleview, parent, false)
        return ViewHolder(createItem)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.img.setImageResource(currentItem.image)
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var img: ImageView = item.findViewById(R.id.fistTypeImage)
    }
}