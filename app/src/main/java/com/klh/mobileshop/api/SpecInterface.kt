package com.klh.mobileshop.api

import com.klh.mobileshop.model.Mobile
import retrofit2.Call
import retrofit2.http.GET


interface SpecInterface {

    @GET("specifications")
    fun getSpec() : Call<Mobile>
}