package com.qamrand.privatbankatmservice.remote.api

class AtmDataSource(private val atmApi: AtmApi) {

    suspend fun getAtmByCity(city: String) = atmApi.getAtmDataByCity("json", "atm", "", city)

}