package com.sonu.dagger2example.core

import dagger.Component

@Component(
    modules = [
        AnalyticsModule::class
    ]
)
@Singleton
interface AppComponent {
    /*
    here we have to expose all the dependencies exposed by this component to be used by other component
    till we are not creating it's subcomponent so if we want to exposed 100 dependencies then we have create 100 methods
    to avoid this we should go for subcomponent concept with subcomponent we only have to expose the sub component only
    if it does not have any  factory/ builder . if it has factory then expose factory so at runtime we can create subcomponent
     if not then simply expose subcomponent

    fun getMixPanelAnalytic(): AnalyticService

     */

    /*
        with subcomponent having factory method / Builder pattern
     */
//    fun userRegistrationSubcomponent(): UserRegistrationComponent.Builder
    fun userRegistrationSubcomponent(): UserRegistrationComponent.Factory
}