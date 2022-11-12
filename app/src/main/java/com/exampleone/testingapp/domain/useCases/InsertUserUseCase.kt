package com.exampleone.testingapp.domain.useCases

import com.exampleone.testingapp.domain.UserItemSubscribe
import com.exampleone.testingapp.domain.UserRepository

class InsertUserUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(userItemSubscribe: UserItemSubscribe) {
        return userRepository.insertUser(userItemSubscribe)
    }

}
