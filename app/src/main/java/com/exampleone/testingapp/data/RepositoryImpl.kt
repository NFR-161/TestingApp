package com.exampleone.testingapp.data

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.exampleone.testingapp.data.mappers.UserMapper
import com.exampleone.testingapp.domain.UserItem
import com.exampleone.testingapp.domain.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RepositoryImpl(application: Application) : UserRepository {

    private val userDao = DataBase.getInstance(application).userDAO
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