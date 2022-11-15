package com.exampleone.testingapp.domain.useCases

import com.exampleone.testingapp.domain.user.UserRepository
import javax.inject.Inject

class InsertUserListUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke() {
        return userRepository.insertUserList()

    }
}