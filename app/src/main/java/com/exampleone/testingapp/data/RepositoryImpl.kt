package com.exampleone.testingapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.exampleone.testingapp.data.mappers.UserMapper
import com.exampleone.testingapp.domain.user.UserItem
import com.exampleone.testingapp.domain.user.UserRepository
import javax.inject.Inject


class RepositoryImpl @Inject constructor (private val userDao: UserDao) : UserRepository {

    private val mapper = UserMapper()
    private val dataRepository = DataRepository()

    override suspend fun insertUserList() {
        userDao.insertUserList(dataRepository.getSubList())

        }

    override suspend fun insertUser(userItem: UserItem) {
        userDao.insertUser(mapper.mapUserItemSubscribeToDbModel(userItem))
    }

    override suspend fun clear() {
        userDao.clear()
    }

    override suspend fun updateUser(userItem: UserItem) {
        userDao.updateUser(mapper.mapUserItemSubscribeToDbModel(userItem))

    }

    override fun getAllUsersForSubscribe(): LiveData<List<UserItem>> {
        return Transformations.map(userDao.getAllUsersForSubscribe()) {
            it.map {
                mapper.mapDbModelToUserItemSubscribe(it)
            }
        }
    }
}