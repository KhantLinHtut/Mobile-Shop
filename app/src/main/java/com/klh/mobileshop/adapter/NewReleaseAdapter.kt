package com.klh.mobileshop.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.klh.mobileshop.R
import com.klh.mobileshop.model.Specificate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.new_release_item.view.*

class NewReleaseAdapter(var mobileList: List<Specificate> = ArrayList()):
    RecyclerView.Adapter<NewReleaseAdapter.NewReleaseViewHolder>() {

    inner class NewReleaseViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        private var view = itemView
        private lateinit var mobileSpec : Specificate

        fun bindSpec(mobileSpec: Specificate) {
            this.mobileSpec = mobileSpec

            Picasso.get()
                .load(mobileSpec.image)
                .placeholder(R.drawable.loading1)
                .into(view.img_newReleaseImage)
            view.txt_newReleaseName.text = mobileSpec.category.name
            view.txt_newReleaseDate.text = mobileSpec.date
            view.txt_newReleaseOS.text = mobileSpec.os

        }
    }


    fun updateList(mobileList: List<Specificate>) {
        this.mobileList = mobileList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewReleaseViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.new_release_item, parent, false)
        return NewReleaseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mobileList.size
    }

    override fun onBindViewHolder(holder: NewReleaseViewHolder, position: Int) {
        holder.bindSpec(mobileList.get(position))
    }

    fun updateNewReleaseList(mobileList: List<Specificate>) {
        this.mobileList = mobileList
        notifyDataSetChanged()
    }


}

