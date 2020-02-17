package com.klh.mobileshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.klh.mobileshop.R
import com.klh.mobileshop.model.Popular
import kotlinx.android.synthetic.main.browse_item.view.*

class BrowseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var image = itemView.findViewById<ImageView>(R.id.img_browseImage)
    var name = itemView.findViewById<TextView>(R.id.txt_browseName)
    var date = itemView.findViewById<TextView>(R.id.txt_browseDate)
    var os = itemView.findViewById<TextView>(R.id.txt_browseOS)
}

class BrowseAdapter (var browseList: ArrayList<Popular>): RecyclerView.Adapter<BrowseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrowseViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.browse_item, parent,false)
        return BrowseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return browseList.size
    }

    override fun onBindViewHolder(holder: BrowseViewHolder, position: Int) {
        holder.image.setImageResource(browseList[position].image)
        holder.name.text = browseList[position].name
        holder.date.text = browseList[position].date
        holder.os.text = browseList[position].os
    }

}