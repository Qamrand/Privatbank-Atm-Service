package com.qamrand.privatbankatmservice.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class AtmTimeWork: Serializable {

    @SerializedName("mon")
    @Expose
    private  var mon: String? = null

    @SerializedName("tue")
    @Expose
    private var tue: String? = null

    @SerializedName("wed")
    @Expose
    private var wed: String? = null

    @SerializedName("thu")
    @Expose
    private  var thu: String? = null

    @SerializedName("fri")
    @Expose
    private var fri: String? = null

    @SerializedName("sat")
    @Expose
    private var sat: String? = null

    @SerializedName("sun")
    @Expose
    private var sun: String? = null

    @SerializedName("hol")
    @Expose
    private  var hol: String? = null

    private val serialVersionUID = -5682477465344989791L

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

    fun getMon(): String? {
        return mon
    }

    fun setMon(mon: String?) {
        this.mon = mon
    }

    fun withMon(mon: String?): AtmTimeWork? {
        this.mon = mon
        return this
    }

    fun getTue(): String? {
        return tue
    }

    fun setTue(tue: String?) {
        this.tue = tue
    }

    fun withTue(tue: String?): AtmTimeWork? {
        this.tue = tue
        return this
    }

    fun getWed(): String? {
        return wed
    }

    fun setWed(wed: String?) {
        this.wed = wed
    }

    fun withWed(wed: String?): AtmTimeWork? {
        this.wed = wed
        return this
    }

    fun getThu(): String? {
        return thu
    }

    fun setThu(thu: String?) {
        this.thu = thu
    }

    fun withThu(thu: String?): AtmTimeWork? {
        this.thu = thu
        return this
    }

    fun getFri(): String? {
        return fri
    }

    fun setFri(fri: String?) {
        this.fri = fri
    }

    fun withFri(fri: String?): AtmTimeWork? {
        this.fri = fri
        return this
    }

    fun getSat(): String? {
        return sat
    }

    fun setSat(sat: String?) {
        this.sat = sat
    }

    fun withSat(sat: String?): AtmTimeWork? {
        this.sat = sat
        return this
    }

    fun getSun(): String? {
        return sun
    }

    fun setSun(sun: String?) {
        this.sun = sun
    }

    fun withSun(sun: String?): AtmTimeWork? {
        this.sun = sun
        return this
    }

    fun getHol(): String? {
        return hol
    }

    fun setHol(hol: String?) {
        this.hol = hol
    }

    fun withHol(hol: String?): AtmTimeWork? {
        this.hol = hol
        return this
    }
}