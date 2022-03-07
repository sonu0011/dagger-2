package com.sonu.dagger2example.example.di

import com.sonu.dagger2example.example.ExampleActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface MainAppComponent {
    fun inject(activity: ExampleActivity)
}