package com.sonu.dagger2example.core

import javax.inject.Inject

@ActivityScope
class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    @MessageQualifier private val service: NotificationService
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        service.send("skr3040@gmail.com", "User registered")
    }
}