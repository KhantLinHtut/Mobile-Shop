package com.klh.mobileshop.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.klh.mobileshop.api.SpecApi
import com.klh.mobileshop.model.Mobile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpecViewModel : ViewModel() {
    var results : MutableLiveData<Mobile> = MutableLiveData()

    var specLoadError : MutableLiveData<Boolean> = MutableLiveData()

    var loading : MutableLiveData<Boolean> = MutableLiveData()


    fun getResults() : LiveData<Mobile> = results
    fun getError() : LiveData<Boolean> = specLoadError
    fun getLoading() : LiveData<Boolean> = loading

    private val specApi : SpecApi = SpecApi()

    fun loadResults() {


        loading.value = true

        val call = specApi.getResults()
        call.enqueue(object : Callback<Mobile> {
            override fun onFailure(call: Call<Mobile>, t: Throwable) {
                specLoadError.value = true
                loading.value = false

                Log.d("Result>>>>>>>>", t.toString())
            }

            override fun onResponse(call: Call<Mobile>, response: Response<Mobile>) {
                loading.value = false
//                val resultList = Mobile(response?.body()?.specificates?: emptyList())
//
//                results.value = resultList

                results.value = response.body()

//                Log.d("Result>>>>>>>>", resultList.toString())
            }

        })
    }
}
