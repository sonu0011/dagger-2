package com.sonu.dagger2example.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sonu.dagger2example.R

class MainActivity : AppCompatActivity() {
    //    lateinit var registrationService: UserRegistrationService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
            if we are passing any parameter to module in that case dagger will not crete that module for us
            in that case we have to crete the module by ourself. The problem with this approach is if we does not
            set user repo module then at compile time it will not give error but at run time  app crash
            so in that case we can go for Component.Factory method  where we tell dagger use this factory to crete
            component


        val dagger = DaggerUserRegistrationComponent
            .builder()
            .userRepositoryModule(UserRepositoryModule(4))
            .build()
            .inject(this)
        registrationService.registerUser("skr3704@gmail.com", "123456")
          */

        /*
            Using Component.Factory method


        val dagger = DaggerUserRegistrationComponent
            .factory()
            .create(retryCount = 3)
            .inject(this)
        registrationService.registerUser("skr3704@gmail.com", "123456")

*/
        /*
        @Singleton annotation
         Singleton annotation is misleading . It does crete single instance but within scope of  component.
         Singleton annotation defines basically.  if we create multiple component then we get the multiple object
         of class which we have annotated with @Singleton . so it all depends on where we create our component
         if we create inside application class and then every time we ask for object it give single instance. it is true singleton
         so if we crete component inside activity  then on activity  / screen rotate new component gets recreated and same
         singleton object .But if we initialize  component in application then we will get true singleton
         if we are annotating dependency with @Singleton we also have to annotate component with same annotaion
         */

        /*
        after creating component  in application class

        (application as BaseApplication).registrationComponent.inject(this)
        registrationService.registerUser("skr3704@gmail.com", "123456")

         */

        /*
            after creating two different components


        val appComponent = (application as BaseApplication).appComponent
        //here are creating user component  so life time of  dependency are scoped inside this activity
        val userRegistrationComponent = DaggerUserRegistrationComponent
            .factory()
            .create(retryCount = 10, appComponent)
        userRegistrationComponent.inject(this)
        registrationService.registerUser("skr3704@gmail.com", "123456")
         */

        /*
            after making userComponent as subcomponent of  app component with factory method


        (application as BaseApplication).appComponent.userRegistrationSubcomponent().create(10)
            .inject(this)
        registrationService.registerUser("skr3704@gmail.com", "123456")

*/
        /*
            after making userComponent as subcomponent of  app component with builder  method
            //here we can skip method like retrycount but in case of factory we have to provide all the paramters


        (application as BaseApplication).appComponent.userRegistrationSubcomponent()
            .build()
            .inject(this)

         */

    }
}