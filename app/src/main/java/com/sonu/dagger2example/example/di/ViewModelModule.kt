package com.sonu.dagger2example.example.di

import androidx.lifecycle.ViewModel
import com.sonu.dagger2example.example.viewmodels.MainViewModel
import com.sonu.dagger2example.example.viewmodels.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap // add to map
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    /*
    @Class key rerers to key in map and view model is it's value
    @IntoMap means add to map created by dagger  and later we can inject that map in view model factory to get view model at specific key
     */

    @Binds
    @ClassKey(UserViewModel::class)
    @IntoMap
    abstract fun bindUserVieModel(viewModel: UserViewModel): ViewModel

}