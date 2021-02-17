package com.qamrand.privatbankatmservice.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class AtmDevice: Serializable{

    @SerializedName("type")
    @Expose
    private var type: String? = null

    @SerializedName("latitude")
    @Expose
    private var latitude: String? = null

    @SerializedName("longitude")
    @Expose
    private var longitude: String? = null

    @SerializedName("tw")
    @Expose
    private var mAtmTimeWork: AtmTimeWork? = null

    @SerializedName("fullAddressRu")
    @Expose
    private var fullAddressRu: String? = null

    @SerializedName("fullAddressUa")
    @Expose
    private var fullAddressUa: String? = null

    @SerializedName("fullAddressEn")
    @Expose
    private var fullAddressEn: String? = null

    @SerializedName("placeRu")
    @Expose
    private var placeRu: String? = null

    @SerializedName("placeUa")
    @Expose
    private var placeUa: String? = null

    @SerializedName("cityRU")
    @Expose
    private var cityRU: String? = null

    @SerializedName("cityUA")
    @Expose
    private var cityUA: String? = null

    @SerializedName("cityEN")
    @Expose
    private var cityEN: String? = null
    private val serialVersionUID = 5243860607802477464L

    fun getType(): String? {
        return type
    }

    fun setType(type: String?) {
        this.type = type
    }

    fun withType(type: String?): AtmDevice? {
        this.type = type
        return this
    }

    fun getLatitude(): String? {
        return latitude
    }

    fun setLatitude(latitude: String?) {
        this.latitude = latitude
    }

    fun withLatitude(latitude: String?): AtmDevice? {
        this.latitude = latitude
        return this
    }

    fun getLongitude(): String? {
        return longitude
    }

    fun setLongitude(longitude: String?) {
        this.longitude = longitude
    }

    fun withLongitude(longitude: String?): AtmDevice? {
        this.longitude = longitude
        return this
    }

    fun getAtmTimeWork(): AtmTimeWork? {
        return mAtmTimeWork
    }

    fun setAtmTimeWork(atmTimeWork: AtmTimeWork?) {
        mAtmTimeWork = atmTimeWork
    }

    fun withTw(atmTimeWork: AtmTimeWork?): AtmDevice? {
        mAtmTimeWork = atmTimeWork
        return this
    }

    fun getFullAddressRu(): String? {
        return fullAddressRu
    }

    fun setFullAddressRu(fullAddressRu: String?) {
        this.fullAddressRu = fullAddressRu
    }

    fun withFullAddressRu(fullAddressRu: String?): AtmDevice? {
        this.fullAddressRu = fullAddressRu
        return this
    }

    fun getFullAddressUa(): String? {
        return fullAddressUa
    }

    fun setFullAddressUa(fullAddressUa: String?) {
        this.fullAddressUa = fullAddressUa
    }

    fun withFullAddressUa(fullAddressUa: String?): AtmDevice? {
        this.fullAddressUa = fullAddressUa
        return this
    }

    fun getFullAddressEn(): String? {
        return fullAddressEn
    }

    fun setFullAddressEn(fullAddressEn: String?) {
        this.fullAddressEn = fullAddressEn
    }

    fun withFullAddressEn(fullAddressEn: String?): AtmDevice? {
        this.fullAddressEn = fullAddressEn
        return this
    }

    fun getPlaceRu(): String? {
        return placeRu
    }

    fun setPlaceRu(placeRu: String?) {
        this.placeRu = placeRu
    }

    fun withPlaceRu(placeRu: String?): AtmDevice? {
        this.placeRu = placeRu
        return this
    }

    fun getPlaceUa(): String? {
        return placeUa
    }

    fun setPlaceUa(placeUa: String?) {
        this.placeUa = placeUa
    }

    fun withPlaceUa(placeUa: String?): AtmDevice? {
        this.placeUa = placeUa
        return this
    }

    fun getCityRU(): String? {
        return cityRU
    }

    fun setCityRU(cityRU: String?) {
        this.cityRU = cityRU
    }

    fun withCityRU(cityRU: String?): AtmDevice? {
        this.cityRU = cityRU
        return this
    }

    fun getCityUA(): String? {
        return cityUA
    }

    fun setCityUA(cityUA: String?) {
        this.cityUA = cityUA
    }

    fun withCityUA(cityUA: String?): AtmDevice? {
        this.cityUA = cityUA
        return this
    }

    fun getCityEN(): String? {
        return cityEN
    }

    fun setCityEN(cityEN: String?) {
        this.cityEN = cityEN
    }

    fun withCityEN(cityEN: String?): AtmDevice? {
        this.cityEN = cityEN
        return this
    }

    override fun toString(): String {
        return "Device{" +
                "type='" + type + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", tw=" + mAtmTimeWork +
                ", fullAddressRu='" + fullAddressRu + '\'' +
                ", fullAddressUa='" + fullAddressUa + '\'' +
                ", fullAddressEn='" + fullAddressEn + '\'' +
                ", placeRu='" + placeRu + '\'' +
                ", placeUa='" + placeUa + '\'' +
                ", cityRU='" + cityRU + '\'' +
                ", cityUA='" + cityUA + '\'' +
                ", cityEN='" + cityEN + '\'' +
                '}'
    }
}