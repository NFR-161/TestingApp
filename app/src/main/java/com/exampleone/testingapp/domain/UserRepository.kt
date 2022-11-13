package com.exampleone.testingapp.domain

import androidx.lifecycle.LiveData
import com.exampleone.testingapp.data.UserModel

interface UserRepository {

    suspend fun insertUserList()

    suspend fun insertUser(userItem: UserItem)

    suspend fun clear()

    suspend fun updateUser(userItem: UserItem)

    fun getAllUsersForSubscribe(): LiveData<List<UserItem>>

}