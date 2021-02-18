package com.qamrand.privatbankatmservice.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

//todo change to parselable
data class AtmTimeWork(
    @SerializedName("mon")
    @Expose
    var mon: String,

    @SerializedName("tue")
    @Expose
    var tue: String,

    @SerializedName("wed")
    @Expose
    var wed: String,

    @SerializedName("thu")
    @Expose
    var thu: String,

    @SerializedName("fri")
    @Expose
    var fri: String,

    @SerializedName("sat")
    @Expose
    var sat: String,

    @SerializedName("sun")
    @Expose
    var sun: String,

    @SerializedName("hol")
    @Expose
    var hol: String
) : Serializable {

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Понедельник:   ").append(mon).append("\n")
        sb.append("Вторник:             ").append(tue).append("\n")
        sb.append("Среда:                 ").append(wed).append("\n")
        sb.append("Четверг:             ").append(thu).append("\n")
        sb.append("Пятница:            ").append(fri).append("\n")
        sb.append("Субота:               ").append(sat).append("\n")
        sb.append("Воскресенье:    ").append(sun).append("\n")
        sb.append("Праздники:        ").append(hol).append("\n")
        return sb.toString()
    }
}