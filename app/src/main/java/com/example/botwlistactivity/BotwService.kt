package com.example.botwlistactivity

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BotwService {
    @GET("api/v2")
    fun getItem(@Query("actualItem") actualItem: String): Call<List<botwItem>>
}