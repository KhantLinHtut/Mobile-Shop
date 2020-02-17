package com.klh.mobileshop.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.klh.mobileshop.R
import com.klh.mobileshop.adapter.BrowseAdapter
import com.klh.mobileshop.model.Popular


/**
 * A simple [Fragment] subclass.
 */
class BrowseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_browse, container, false)

        var browseRecycler = view.findViewById<RecyclerView>(R.id.recycler_browse)

        var browseList = ArrayList<Popular>()
        browseList.add(Popular(R.drawable.iphonexs, "iPhone XS", "2018 September", "iOS 12"))
        browseList.add(Popular(R.drawable.iphone11promax, "iPhone 11 Pro Max", "2019 September", "iOS 13"))
        browseList.add(Popular(R.drawable.mi9pro, "Mi 9 Pro", "2019 September", "MIUI 10.0"))
        browseList.add(Popular(R.drawable.googlepixel3, "Google Pixel 3", "2018 November", "Android 9.0"))

        var browseAdapter = BrowseAdapter(browseList)
        browseRecycler.layoutManager = GridLayoutManager(context,1)
        browseRecycler.adapter = browseAdapter


        return view
    }


}
