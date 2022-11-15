package com.exampleone.testingapp.domain.useCases

import com.exampleone.testingapp.domain.user.UserRepository
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(private val userRepository: UserRepository) {

    val users = userRepository.getAllUsersForSubscribe()
}
