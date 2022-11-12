package com.exampleone.testingapp.domain.useCases

import com.exampleone.testingapp.domain.UserRepository

class GetUserListUseCase(private val userRepository: UserRepository) {

    val users = userRepository.getAllUsersForSubscribe()
}
