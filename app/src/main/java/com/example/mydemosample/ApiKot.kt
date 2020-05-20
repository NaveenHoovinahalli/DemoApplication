package com.example.mydemosample

import retrofit2.Call
import retrofit2.http.GET

interface ApiKot {

    companion object {
        const val BASE_URL = "https://simplifiedcoding.net/demos/"
    }

    @GET("marvel")
    fun getHeros() : Call<List<Hero>>


}