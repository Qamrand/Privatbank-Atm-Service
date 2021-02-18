package com.qamrand.privatbankatmservice.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

//todo change to parselable
data class AtmDevice(
    @SerializedName("type")
    @Expose
    var type: String,

    @SerializedName("latitude")
    @Expose
    var latitude: String,

    @SerializedName("longitude")
    @Expose
    var longitude: String,

    @SerializedName("tw")
    @Expose
    var atmTimeWork: AtmTimeWork,

    @SerializedName("fullAddressRu")
    @Expose
    var fullAddressRu: String,

    @SerializedName("fullAddressUa")
    @Expose
    var fullAddressUa: String,

    @SerializedName("fullAddressEn")
    @Expose
    var fullAddressEn: String,

    @SerializedName("placeRu")
    @Expose
    var placeRu: String,

    @SerializedName("placeUa")
    @Expose
    var placeUa: String,

    @SerializedName("cityRU")
    @Expose
    var cityRU: String,

    @SerializedName("cityUA")
    @Expose
    var cityUA: String,

    @SerializedName("cityEN")
    @Expose
    var cityEN: String
) : Serializable {


    override fun toString(): String {
        return "Device{" +
                "type='" + type + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", tw=" + atmTimeWork +
                ", fullAddressUa='" + fullAddressUa + '\'' +
                ", fullAddressRu='" + fullAddressRu + '\'' +
                ", fullAddressEn='" + fullAddressEn + '\'' +
                ", placeRu='" + placeRu + '\'' +
                ", placeUa='" + placeUa + '\'' +
                ", cityRU='" + cityRU + '\'' +
                ", cityUA='" + cityUA + '\'' +
                ", cityEN='" + cityEN + '\'' +
                '}'
    }
}