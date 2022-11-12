package com.exampleone.testingapp.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.exampleone.testingapp.data.mappers.UserMapper
import com.exampleone.testingapp.domain.UserItemSubscribe
import com.exampleone.testingapp.domain.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class RepositoryImpl(application: Application) : UserRepository {

    private val userDao = DataBase.getInstance(application).userDAO

    private val mapper = UserMapper()

    override suspend fun insertUserLIst(userModel: List<UserModel>) {
        userDao.insertUserList(userModel)
    }

    override fun searchDataBase(search: String): LiveData<List<UserItemSubscribe>> {
        return Transformations.map(userDao.searchDataBase(search)) {
            it.map {
                mapper.mapDbModelToUserItemSubscribe(it)
            }
        }
    }
    override suspend fun insertUser(userItemSubscribe: UserItemSubscribe) {
        userDao.insertUser(mapper.mapUserItemSubscribeToDbModel(userItemSubscribe))
    }

    override suspend fun clear() {
        userDao.clear()
    }

    override suspend fun updateUser(userItemSubscribe: UserItemSubscribe) {
        userDao.updateUser(mapper.mapUserItemSubscribeToDbModel(userItemSubscribe))

    }

    override fun getAllUsersForSubscribe(): LiveData<List<UserItemSubscribe>> {
        return Transformations.map(userDao.getAllUsersForSubscribe()) {
            it.map {
                mapper.mapDbModelToUserItemSubscribe(it)
            }
        }
    }

}