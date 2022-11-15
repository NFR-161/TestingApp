package com.exampleone.testingapp.domain.user

import androidx.lifecycle.LiveData
import com.exampleone.testingapp.domain.user.UserItem

interface UserRepository {

    suspend fun insertUserList()

    suspend fun insertUser(userItem: UserItem)

    suspend fun clear()

    suspend fun updateUser(userItem: UserItem)

    fun getAllUsersForSubscribe(): LiveData<List<UserItem>>

}