package com.qamrand.privatbankatmservice.remote.repository

import com.qamrand.privatbankatmservice.remote.api.AtmDataSource
import javax.inject.Inject

class AtmRepository @Inject constructor(
    private val atmDataSource: AtmDataSource
) {

    //fun getAtmByCity(city: String) = atmApi.getAtmDataByCity("json", "atm", "", city)

}