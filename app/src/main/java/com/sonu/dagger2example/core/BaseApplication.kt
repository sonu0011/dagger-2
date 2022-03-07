package com.sonu.dagger2example.core

import android.app.Application
import com.sonu.dagger2example.example.di.DaggerMainAppComponent
import com.sonu.dagger2example.example.di.MainAppComponent

class BaseApplication : Application() {
    lateinit var mainComponent: MainAppComponent
    override fun onCreate() {
        super.onCreate()
        mainComponent = DaggerMainAppComponent.builder().build()
    }
}