package com.example.jewelry

class DBResponse {
    var IsSuccess:Boolean = false
    lateinit var Message : String

    fun getApiIsSuccess(): Boolean {
        return IsSuccess
    }
}