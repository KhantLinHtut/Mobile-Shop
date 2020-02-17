package com.klh.mobileshop.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

import com.klh.mobileshop.R

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_home, container, false)

        var btnBrowse = root.findViewById<Button>(R.id.btn_browse)
        btnBrowse.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_homeFragment3_to_browseFragment)
        }

        var btnDetail = root.findViewById<Button>(R.id.btn_detail)
        btnDetail.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment3_to_detailFragment)
        }

        return root
    }


}
