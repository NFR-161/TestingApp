package com.exampleone.testingapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exampleone.testingapp.data.RepositoryImpl
import com.exampleone.testingapp.data.UserModel
import com.exampleone.testingapp.domain.UserItem
import com.exampleone.testingapp.domain.useCases.GetUserListUseCase
import com.exampleone.testingapp.domain.useCases.InsertUserListUseCase
import com.exampleone.testingapp.domain.useCases.InsertUserUseCase
import com.exampleone.testingapp.domain.useCases.UpdateUserUseCase
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {


    private val repository = RepositoryImpl(application)

    private val insertListUseCase = InsertUserListUseCase(repository)
    private val getUserListUseCase = GetUserListUseCase(repository)
    private val insertUserUseCase = InsertUserUseCase(repository)
    private val updateUserUseCase = UpdateUserUseCase(repository)


    val users = getUserListUseCase.users

      fun insert(userItem: UserItem) = viewModelScope.launch {
        insertUserUseCase(userItem)
    }

      fun updateTask(userItem: UserItem) = viewModelScope.launch {
        updateUserUseCase(userItem)
    }

       fun insertUserList(userModel: List<UserModel>) = viewModelScope.launch {
           insertListUseCase(userModel)
       }
    }
