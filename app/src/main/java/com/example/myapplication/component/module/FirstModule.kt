package com.example.myapplication.component.module

import com.example.myapplication.component.scopes.ActivityScope
import com.example.myapplication.screen.FirstActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FirstModule {
    @[ActivityScope ContributesAndroidInjector(modules = [FirstActivityModule::class])]
    abstract fun contributeActivity() : FirstActivity
}