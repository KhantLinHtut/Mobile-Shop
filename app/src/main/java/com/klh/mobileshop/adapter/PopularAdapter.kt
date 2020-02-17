package com.klh.mobileshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.klh.mobileshop.R
import com.klh.mobileshop.model.Specificate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.popular_item.view.*

class PopularAdapter(var mobileList: List<Specificate> = ArrayList()):
        RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    inner class PopularViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        private var view = itemView
        private lateinit var mobileSpec : Specificate

        fun bindSpec(mobileSpec: Specificate) {
            this.mobileSpec = mobileSpec

            Picasso.get()
                .load(mobileSpec.image)
                .placeholder(R.drawable.loading1)
                .into(view.img_popularImage)
            view.txt_popularName.text = mobileSpec.category.name
            view.txt_popularDate.text = mobileSpec.date
            view.txt_popularOS.text = mobileSpec.os

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.popular_item, parent, false)
        return PopularViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mobileList.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bindSpec(mobileList.get(position))
    }

    fun updateList(mobileList: List<Specificate>) {
        this.mobileList = mobileList
        notifyDataSetChanged()
    }

}

