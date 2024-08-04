package com.ghaemkarimi.daneshjooyar.remote.apiservice

import com.ghaemkarimi.daneshjooyar.remote.datamodel.SupportApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SendMessageApiService {

    @GET("send")
    suspend fun sendMassageToSupport(
        @Query("to") to: String,
        @Query("text") text: String
    ): Response<SupportApiModel>

}