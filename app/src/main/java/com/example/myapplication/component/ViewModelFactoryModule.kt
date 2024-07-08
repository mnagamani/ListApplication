package com.example.myapplication.component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.component.scopes.ViewModelKey
import com.example.myapplication.screen.viewmodel.FirstViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    internal abstract fun bindSearchViewModel(viewModel: FirstViewModel): ViewModel

    //Add more ViewModels here if needed
}