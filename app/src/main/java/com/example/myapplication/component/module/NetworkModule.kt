package com.example.myapplication.component.module

import com.example.myapplication.repository.interfaces.NetworkHelper
import com.example.myapplication.repository.impls.NetworkHelperImpl
import dagger.Binds
import dagger.Module


@Module
interface NetworkModule {

    @Binds
    fun providesNetworkHelper(helper: NetworkHelperImpl) : NetworkHelper
}