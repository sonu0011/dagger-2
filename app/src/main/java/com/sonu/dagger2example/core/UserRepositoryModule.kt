package com.sonu.dagger2example.core

import dagger.Module
import dagger.Provides

@Module
class UserRepositoryModule(
) {

    @Provides
    fun provideUserRepository(retryCount: Int): UserRepository {
        return SQLRepository(retryCount = retryCount)
    }
}