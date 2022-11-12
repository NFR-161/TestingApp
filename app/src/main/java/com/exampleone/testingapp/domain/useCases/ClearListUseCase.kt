package com.exampleone.testingapp.domain.useCases

import com.exampleone.testingapp.domain.UserRepository

class ClearListUseCase(private val userRepository: UserRepository) {

    suspend fun clear() {
        return userRepository.clear()
    }

}