package com.example.jewelry

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @GET("login.php")
    fun loginCall(
        Username: String,
        Password: String
    ): Call<User>

    @POST("register.php")
    fun regCall(
        @Query("Username") Username: String?,
        @Query("Password") Password: String?
    ): Call<User?>?
}