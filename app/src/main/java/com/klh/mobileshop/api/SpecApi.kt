package com.klh.mobileshop.api

import com.klh.mobileshop.model.Mobile
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpecApi {
    private val specInterface : SpecInterface

    companion object {
        const val BASE_URL = "http://mobile.khaingthinkyi.me/api/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        specInterface = retrofit.create(
            SpecInterface::class.java
        )
    }

    fun getResults(): Call<Mobile> {
        return specInterface.getSpec()
    }
}