package com.sonu.dagger2example.core

import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class NotificationModule {

    /*
    @Provides
    fun provideNotificationService(): NotificationService {
        return MessageService()
    }
     */
    /*
        if we have implemented class and we can annotate its constructor with @Inject then we can use @Binds annotation
        it  means bind the given type with provided argument
     */

    @MessageQualifier
    @Binds
    abstract fun provideMessageService(service: MessageService): NotificationService

    @Binds
    @Named("email")
    abstract fun provideEmailService(service: EmailService): NotificationService


}
