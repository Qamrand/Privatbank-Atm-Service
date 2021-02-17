package com.qamrand.privatbankatmservice.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class AtmData: Serializable {

    @SerializedName("devices")
    @Expose
    private var mAtmDevices: List<AtmDevice>? = null

    @SerializedName("address")
    @Expose
    private var address: String? = null

    @SerializedName("city")
    @Expose
    private var city: String? = null
    private val serialVersionUID = -1751131371325279670L

    fun getAtmDevices(): List<AtmDevice> {
        return mAtmDevices!!
    }

    fun setAtmDevices(atmDevices: List<AtmDevice>) {
        mAtmDevices = atmDevices
    }

    fun withDevices(atmDevices: List<AtmDevice>?): AtmData {
        mAtmDevices = atmDevices
        return this
    }

    fun getAddress(): String? {
        return address
    }

    fun setAddress(address: String?) {
        this.address = address
    }

    fun withAddress(address: String?): AtmData {
        this.address = address
        return this
    }

    fun getCity(): String? {
        return city
    }

    fun setCity(city: String?) {
        this.city = city
    }

    fun withCity(city: String?): AtmData {
        this.city = city
        return this
    }
}