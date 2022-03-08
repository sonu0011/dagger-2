package com.sonu.dagger2example.example.di

import androidx.lifecycle.ViewModel
import com.sonu.dagger2example.example.ExampleActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class, ViewModelModule::class]
)
interface MainAppComponent {
    fun inject(activity: ExampleActivity)

    //dagger will create map having classname as key and view model it's value
    //inject this map in view model provider factory
    fun map(): Map<Class<*>, ViewModel>
}