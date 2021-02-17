package com.qamrand.privatbankatmservice

import android.app.Application
import com.qamrand.privatbankatmservice.di.AppComponent
import com.qamrand.privatbankatmservice.di.DaggerAppComponent

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent

        const val TAG_APP = "TAG_APP"
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build();
    }


}