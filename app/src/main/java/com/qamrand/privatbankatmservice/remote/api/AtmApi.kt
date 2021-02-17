package com.qamrand.privatbankatmservice.remote.api

import com.qamrand.privatbankatmservice.model.AtmData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName

interface AtmApi {

    @GET("infrastructure")
    suspend fun getAtmDataByCity(
        @QueryName format: String?,
        @QueryName atm: String?,
        @Query("address") address: String?,
        @Query("city") compact: String?
    ): Response<AtmData>
}