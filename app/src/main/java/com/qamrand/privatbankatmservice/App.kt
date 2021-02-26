package com.qamrand.privatbankatmservice

import android.app.Application
import com.qamrand.privatbankatmservice.di.components.AppComponent
import com.qamrand.privatbankatmservice.di.components.DaggerAppComponent
import com.qamrand.privatbankatmservice.di.components.MainFragmentComponent

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
        //lateinit var mainFragmentComponent: MainFragmentComponent
        const val TAG_APP = "TAG_APP"
    }

    override fun onCreate() {
        super.onCreate()
        //DaggerMainFragmentComponent.builder().build();
        appComponent = DaggerAppComponent.builder().build();
    }


}