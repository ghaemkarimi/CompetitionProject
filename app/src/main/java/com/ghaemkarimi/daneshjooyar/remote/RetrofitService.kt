package com.ghaemkarimi.daneshjooyar.remote

import com.ghaemkarimi.daneshjooyar.remote.apiservice.SendMessageApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val url = "https://notificator.ir/api/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val SendMessage: SendMessageApiService = retrofit.create(SendMessageApiService::class.java)

}