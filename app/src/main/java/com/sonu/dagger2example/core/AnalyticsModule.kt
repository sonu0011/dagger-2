package com.sonu.dagger2example.core

import dagger.Binds
import dagger.Module

@Module
abstract class AnalyticsModule {

    @Binds
    @Singleton
    abstract fun bindMixPanelAnalytic(panel: MixPanel): AnalyticService
}