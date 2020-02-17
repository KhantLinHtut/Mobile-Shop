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
class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var root: View =inflater.inflate(R.layout.fragment_start, container, false)

        var btnStart = root.findViewById<Button>(R.id.btn_start)
        btnStart.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_startFragment2_to_homeFragment3)
        }
        // Inflate the layout for this fragment
        return root
    }


}
