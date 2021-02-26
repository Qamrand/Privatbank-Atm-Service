package com.qamrand.privatbankatmservice.di.components

import com.qamrand.privatbankatmservice.di.modules.AtmApiModule
import com.qamrand.privatbankatmservice.ui.fragment.main.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AtmApiModule::class])
interface AppComponent {

    fun injectMainFragment(mainFragment: MainFragment)
/*
    fun mainFragmentComponent() : MainFragmentComponent*/
}