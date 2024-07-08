package com.example.myapplication.component

import android.app.Application
import android.content.Context
import com.example.myapplication.MyApplication
import com.example.myapplication.component.module.RepositoryModule
import com.example.myapplication.component.module.FirstModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class, FirstModule::class, AndroidSupportInjectionModule::class, ViewModelFactoryModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationBind(application: Application): Builder

        @BindsInstance
        fun context(context: Context) : Builder

        fun build() : AppComponent
    }

    fun inject(application: MyApplication)
}
