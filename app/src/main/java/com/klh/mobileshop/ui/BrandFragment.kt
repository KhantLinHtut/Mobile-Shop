package com.klh.mobileshop.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.klh.mobileshop.R
import com.klh.mobileshop.adapter.BrandAdapter
import com.klh.mobileshop.adapter.PopularAdapter
import com.klh.mobileshop.viewmodel.SpecViewModel
import kotlinx.android.synthetic.main.fragment_brand.*
import kotlinx.android.synthetic.main.fragment_popular.*

/**
 * A simple [Fragment] subclass.
 */
class BrandFragment : Fragment() {

    lateinit var brandListAdapter : BrandAdapter

    lateinit var specViewModel: SpecViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_brand, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        brandListAdapter = BrandAdapter()
        recycler_brand.adapter = brandListAdapter
        recycler_brand.layoutManager = GridLayoutManager(context,2)

        observeViewModel()
    }

    fun observeViewModel() {

        specViewModel = ViewModelProvider(this).get(SpecViewModel::class.java)

        specViewModel.getResults().observe(
            viewLifecycleOwner, Observer { result ->
                brandListAdapter.updateBrandList(result.specificates)
            }
        )

    }

    override fun onResume() {
        super.onResume()

        specViewModel.loadResults()
    }

}
