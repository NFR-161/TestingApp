package com.exampleone.testingapp.domain

import androidx.lifecycle.LiveData
import com.exampleone.testingapp.data.UserModel

interface UserRepository {

    suspend fun insertUser(userItem: UserItem)

    suspend fun updateUser(userItem: UserItem)

    fun getAllUsers(): LiveData<List<UserItem>>

}