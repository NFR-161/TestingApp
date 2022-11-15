package com.exampleone.testingapp.domain.useCases

import com.exampleone.testingapp.data.UserModel
import com.exampleone.testingapp.domain.UserItem
import com.exampleone.testingapp.domain.UserRepository
import javax.inject.Inject

class InsertUserListUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke() {
        return userRepository.insertUserList()

    }
}