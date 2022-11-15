package com.exampleone.testingapp.domain.useCases

import com.exampleone.testingapp.domain.user.UserRepository
import javax.inject.Inject

class ClearListUseCase @Inject constructor (private val userRepository: UserRepository) {

    suspend fun clear() {
        return userRepository.clear()
    }

}