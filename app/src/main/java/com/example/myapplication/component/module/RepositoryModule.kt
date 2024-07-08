package com.example.myapplication.component.module

import com.example.myapplication.repository.interfaces.Repository
import com.example.myapplication.repository.impls.RepositoryImpl

import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class])
interface RepositoryModule {

    @Binds
    fun provideRepository(repository: RepositoryImpl) : Repository

}