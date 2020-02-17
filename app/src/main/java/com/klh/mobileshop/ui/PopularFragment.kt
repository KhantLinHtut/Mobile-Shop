package com.klh.mobileshop.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.klh.mobileshop.R
import com.klh.mobileshop.adapter.NewReleaseAdapter
import com.klh.mobileshop.adapter.PopularAdapter
import com.klh.mobileshop.model.Popular
import com.klh.mobileshop.viewmodel.SpecViewModel
import kotlinx.android.synthetic.main.fragment_popular.*

/**
 * A simple [Fragment] subclass.
 */
class PopularFragment : Fragment() {

    lateinit var popularListAdapter : PopularAdapter

    lateinit var specViewModel: SpecViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularListAdapter = PopularAdapter()
        recycler_popular.adapter = popularListAdapter
        recycler_popular.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        observeViewModel()
    }

    fun observeViewModel() {

        specViewModel = ViewModelProvider(this).get(SpecViewModel::class.java)

        specViewModel.getResults().observe(
            viewLifecycleOwner, Observer { result ->
                popularListAdapter.updateList(result.specificates)
            }
        )

    }

    override fun onResume() {
        super.onResume()

        specViewModel.loadResults()
    }


}
