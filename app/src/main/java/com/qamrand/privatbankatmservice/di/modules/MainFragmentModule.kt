package com.qamrand.privatbankatmservice.di.modules

import com.qamrand.privatbankatmservice.di.scopes.FragmentScope
import com.qamrand.privatbankatmservice.ui.fragment.main.AtmAdapter
import com.qamrand.privatbankatmservice.ui.fragment.main.MainFragment
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule(
    private var mainFragment: MainFragment
)  {

    @FragmentScope
    @Provides
    fun provideAtmAdapter() : AtmAdapter = AtmAdapter(mainFragment)

}