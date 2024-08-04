package com.ghaemkarimi.daneshjooyar.remote

object RetrofitService {

    private const val url = "https://notificator.ir/api/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}