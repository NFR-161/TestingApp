package com.exampleone.testingapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.exampleone.testingapp.data.RepositoryImpl
import com.exampleone.testingapp.data.UserModel
import com.exampleone.testingapp.domain.UserItem
import com.exampleone.testingapp.domain.useCases.*
import kotlinx.coroutines.launch

class SubViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)
    private val insertUserListUseCase = InsertUserListUseCase(repository)
    private val getUserListUseCase = GetUserListUseCase(repository)
    private val insertUserUseCase = InsertUserUseCase(repository)
    private val updateUserUseCase = UpdateUserUseCase(repository)
    private val clearListUseCase = ClearListUseCase(repository)


    private var _searchText = MutableLiveData<String>()
    var searchText: LiveData<String> = _searchText

    val users = getUserListUseCase.users

    fun initSearchText(text: String) {
        _searchText.postValue(text)
    }

    fun insert(userItem: UserItem) = viewModelScope.launch {
        insertUserUseCase(userItem)
    }

    fun updateTask(userItem: UserItem) = viewModelScope.launch {
        updateUserUseCase(userItem)
    }

    fun insertUserList() = viewModelScope.launch {
        insertUserListUseCase()
    }
    fun clear() = viewModelScope.launch {
        clearListUseCase.clear()
    }

}
