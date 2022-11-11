package com.exampleone.testingapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.exampleone.testingapp.data.RepositoryImpl
import com.exampleone.testingapp.data.UserModel
import com.exampleone.testingapp.domain.UserItem
import com.exampleone.testingapp.domain.useCases.*
import kotlinx.coroutines.launch

class SubViewModel(application: Application) : AndroidViewModel(application) {


    private val repository = RepositoryImpl(application)

    private val insertListUseCase = InsertUserListUseCase(repository)
    private val getUserListUseCase = GetUserListUseCase(repository)
    private val insertUserUseCase = InsertUserUseCase(repository)
    private val updateUserUseCase = UpdateUserUseCase(repository)
    private val clearListUseCase = ClearListUseCase(repository)

    private var _searchText = MutableLiveData<String>()
    var searchText: LiveData<String> = _searchText

    val users = getUserListUseCase.users

    fun initSearchText(text: String){
        _searchText.postValue(text)
    }

    fun insert(userItem: UserItem) = viewModelScope.launch {
        insertUserUseCase(userItem)
    }

    fun updateTask(userItem: UserItem) = viewModelScope.launch {
        updateUserUseCase(userItem)
    }

    fun insertUserList(userModel: List<UserModel>) = viewModelScope.launch {
        insertListUseCase(userModel)
    }

    fun clear() = viewModelScope.launch {
        clearListUseCase.clear()
    }

    fun searchDataBase(search: String): LiveData<List<UserItem>> {
        return repository.searchDataBase(search)
    }

}
