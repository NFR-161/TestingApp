package com.exampleone.testingapp.domain.useCases

import com.exampleone.testingapp.data.UserModel
import com.exampleone.testingapp.domain.UserRepository

class InsertUserListUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(userModel: List<UserModel>) {
        return userRepository.insertUserLIst(userModel)

    }
}