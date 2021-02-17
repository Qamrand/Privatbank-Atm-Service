package com.qamrand.privatbankatmservice.di

import com.qamrand.privatbankatmservice.ui.fragment.main.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AtmApiModule::class])
interface AppComponent {

    fun injectMainFragment(mainFragment: MainFragment)

}