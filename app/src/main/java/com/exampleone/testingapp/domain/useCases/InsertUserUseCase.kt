package com.exampleone.testingapp.domain.useCases

import com.exampleone.testingapp.domain.UserItem
import com.exampleone.testingapp.domain.UserRepository

class InsertUserUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(userItem: UserItem) {
        return userRepository.insertUser(userItem)
    }

}
