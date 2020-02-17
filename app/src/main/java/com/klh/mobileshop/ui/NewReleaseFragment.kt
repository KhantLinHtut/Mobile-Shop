package com.klh.mobileshop.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.klh.mobileshop.R
import com.klh.mobileshop.adapter.NewReleaseAdapter
import com.klh.mobileshop.adapter.PopularAdapter
import com.klh.mobileshop.viewmodel.SpecViewModel
import kotlinx.android.synthetic.main.fragment_new_release.*
import kotlinx.android.synthetic.main.fragment_popular.*


/**
 * A simple [Fragment] subclass.
 */
class NewReleaseFragment : Fragment() {

    lateinit var newReleaseAdapter : NewReleaseAdapter

    lateinit var specViewModel: SpecViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        return inflater.inflate(R.layout.fragment_new_release, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newReleaseAdapter = NewReleaseAdapter()
        recycler_newRelease.adapter = newReleaseAdapter
        recycler_newRelease.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)

        observeViewModel()
    }

    fun observeViewModel() {

        specViewModel = ViewModelProvider(this).get(SpecViewModel::class.java)

        specViewModel.getResults().observe(
            viewLifecycleOwner, Observer { result ->
                newReleaseAdapter.updateNewReleaseList(result.specificates)
            }
        )

    }

    override fun onResume() {
        super.onResume()

        specViewModel.loadResults()
    }
}

