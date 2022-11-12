package com.exampleone.testingapp.domain

import androidx.lifecycle.LiveData
import com.exampleone.testingapp.data.UserModel

interface UserRepository {

    suspend fun insertUserLIst(userModel: List<UserModel>)

    suspend fun insertUser(userItemSubscribe: UserItemSubscribe)

    suspend fun clear()

    suspend fun updateUser(userItemSubscribe: UserItemSubscribe)

    fun searchDataBase(search:String): LiveData<List<UserItemSubscribe>>

    fun getAllUsersForSubscribe(): LiveData<List<UserItemSubscribe>>

}