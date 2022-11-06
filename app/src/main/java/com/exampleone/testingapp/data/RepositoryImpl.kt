package com.exampleone.testingapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.exampleone.testingapp.data.mappers.UserMapper
import com.exampleone.testingapp.domain.UserItem
import com.exampleone.testingapp.domain.UserRepository

class RepositoryImpl( application: Application) : UserRepository {

    private val userDao = DataBase.getInstance(application).userDAO

    private val mapper = UserMapper()

    override suspend fun insertUser(userItem: UserItem) {
        userDao.insertUser(mapper.mapUserItemToDbModel(userItem))
    }

    override suspend fun updateUser(userItem: UserItem) {
        userDao.updateUser(mapper.mapUserItemToDbModel(userItem))

    }

    override fun getAllUsers(): LiveData<List<UserItem>> {
        return Transformations.map(userDao.getAllUsers()) {
            it.map {
                mapper.mapDbModelToUserItem(it)
            }
        }
    }

}