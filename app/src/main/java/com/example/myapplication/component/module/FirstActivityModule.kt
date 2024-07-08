package com.example.myapplication.component.module

import com.example.myapplication.component.scopes.FragmentScope
import com.example.myapplication.screen.FirstFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [])

interface FirstActivityModule {
    @[FragmentScope ContributesAndroidInjector(modules = [ FirstFragmentModule::class])]
    fun contributeFirstFragment() : FirstFragment
}