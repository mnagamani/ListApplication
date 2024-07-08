package com.example.myapplication.component.module

import androidx.fragment.app.Fragment
import com.example.myapplication.screen.FirstFragment
import dagger.Binds
import dagger.Module

@Module//(includes = [ViewModelFactoryModule :: class])
abstract class FirstFragmentModule {
    @Binds
    abstract fun bindFragment(firstFragment: FirstFragment): Fragment

}