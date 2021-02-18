package com.qamrand.privatbankatmservice.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

//todo change to parselable
data class AtmData(
    @SerializedName("devices")
    @Expose
    var atmDevices: List<AtmDevice>,

    @SerializedName("address")
    @Expose
    var address: String,

    @SerializedName("city")
    @Expose
    var city: String
) : Serializable