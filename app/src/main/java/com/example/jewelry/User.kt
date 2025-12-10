package com.example.jewelry

public class User() {
    lateinit var Response:String
    lateinit var Username:String
    lateinit var Password:String

    fun getApiResponse(): String {
        return Response
    }

    fun getApiName(): String {
        return Username
    }

    fun getApiUsername(): String {
        return Password
    }
}