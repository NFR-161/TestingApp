package com.exampleone.testingapp.domain.useCases

import com.exampleone.testingapp.data.UserModel
import com.exampleone.testingapp.domain.UserItem
import com.exampleone.testingapp.domain.UserRepository

class UpdateUserUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(userItem: UserItem) {
        return userRepository.updateUser(userItem)
    }
}
