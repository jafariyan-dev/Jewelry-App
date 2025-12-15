package com.example.jewelry

public class User() {
    lateinit var Username:String
    lateinit var Password:String
    var IsAdmin:Boolean = false

    fun getApiName(): String {
        return Username
    }

    fun getApiUsername(): String {
        return Password
    }
}