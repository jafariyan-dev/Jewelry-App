package com.example.jewelry

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {
    var BASE_URL: String = "http://192.168.56.1/api/"
    lateinit var myRetrofit: Retrofit

    public fun getAPI(): Retrofit {

        if (myRetrofit == null) {

            myRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return myRetrofit
    }
}