package com.exampleone.testingapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exampleone.testingapp.domain.user.UserItem
import com.exampleone.testingapp.domain.useCases.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelUser @Inject constructor(
    val insertUserListUseCase: InsertUserListUseCase,
    getUserListUseCase: GetUserListUseCase,
    val insertUserUseCase: InsertUserUseCase,
    val updateUserUseCase: UpdateUserUseCase,
    private val clearListUseCase: ClearListUseCase
) : ViewModel() {

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
