package com.klh.mobileshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.klh.mobileshop.R
import com.klh.mobileshop.model.Specificate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.brand_item.view.*
import kotlinx.android.synthetic.main.popular_item.view.*

class BrandAdapter(var mobileList: List<Specificate> = ArrayList()):
    RecyclerView.Adapter<BrandAdapter.BrandViewHolder>() {

    inner class BrandViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        private var view = itemView
        private lateinit var mobileSpec : Specificate

        fun bindSpec(mobileSpec: Specificate) {
            this.mobileSpec = mobileSpec

            Picasso.get()
                .load(mobileSpec.category.brand.image)
                .placeholder(R.drawable.loading1)
                .into(view.img_brandImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.brand_item, parent, false)
        return BrandViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mobileList.size
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        holder.bindSpec(mobileList.get(position))
    }

    fun updateBrandList(mobileList: List<Specificate>) {
        this.mobileList = mobileList
        notifyDataSetChanged()
    }

}

