package com.example.myapplication

import android.app.Application
import com.example.myapplication.component.AppComponent
import com.example.myapplication.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

open class MyApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        initializeComponent().inject(this)
    }

     fun initializeComponent(): AppComponent {
        return DaggerAppComponent.builder().applicationBind(this).context(this).build()
    }

    override fun androidInjector(): AndroidInjector<Any> = fragmentInjector
}