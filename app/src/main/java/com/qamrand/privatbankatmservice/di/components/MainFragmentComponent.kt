package com.qamrand.privatbankatmservice.di.components

import com.qamrand.privatbankatmservice.di.modules.MainFragmentModule
import com.qamrand.privatbankatmservice.di.scopes.FragmentScope
import com.qamrand.privatbankatmservice.ui.fragment.main.AtmAdapter
import dagger.Component

@FragmentScope
@Component(modules = [MainFragmentModule::class])
interface MainFragmentComponent {

    fun getAtmAdapter(): AtmAdapter

    //fun inject(mainFragment: MainFragment)

}