package com.sonu.dagger2example.core

import dagger.BindsInstance
import dagger.Subcomponent


@ActivityScope
//@Component(
@Subcomponent(
//    dependencies = [AppComponent::class],
    modules = [
        NotificationModule::class,
        UserRepositoryModule::class,
    ]
)
interface UserRegistrationComponent {
    /*
        get dependency using provision methods
     */
//    fun provideUserRegistrationService(): UserRegistrationService

    /*
        tell dagger to inject all dependencies in MainActivity annotate with @Inject field
     */
//    fun inject(activity: MainActivity)

    /*
            @BindInstance is used to bind the things at run time
            now retryCount variable is available with component
            so we can remove argument from module directly we can
            pass inject where retry count is required
     */

    /*
        here we will have to pass all the component on which this component  depends
        like app component  whe have mentioned in dependencies section
     */


    @Subcomponent.Factory
//    @Component.Factory
    interface Factory {
        /*
        before using subcomponent
            fun create(
            @BindsInstance retryCount: Int,
            appComponent: AppComponent
        ): UserRegistrationComponent
         */

        //with subcomponent you don't have to mention other component as subcomponent
        fun create(
            @BindsInstance retryCount: Int
        ): UserRegistrationComponent
    }






    /*
        subcomponent using builder pattern
        first annotate with @Subcomponet.Builder
        then create build method which return the  subcomponent
        fore every parameter we need create method and return the Builder
        the  main diff between builder and factory pattern is compiler does not give error if we don't call other method like setRetryCount in
         building phase eX:

                 (application as BaseApplication).appComponent.userRegistrationSubcomponent()
            .build()
            .inject(this)

            in above example we have not provide the retrycount method but still code compiles at runtime we will get error

           but in factory you have one method to create subcomponent  where as compiler gives error
        in case of factory if we don't crete factory  , factory pattern is latest and builder patter is mostly used in old project

     */
    /*

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserRegistrationComponent

        fun setRetryCount(@BindsInstance retryCount: Int): Builder
    }

     */
}