package com.exampleone.testingapp.domain.useCases

import com.exampleone.testingapp.domain.user.UserItem
import com.exampleone.testingapp.domain.user.UserRepository
import javax.inject.Inject

class InsertUserUseCase @Inject constructor (private val userRepository: UserRepository) {

    suspend operator fun invoke(userItem: UserItem) {
        return userRepository.insertUser(userItem)
    }

}
