package com.exampleone.testingapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.exampleone.testingapp.domain.useCases.*
import javax.inject.Inject

class ViewFactoryUser @Inject constructor(
    private val insertUserListUseCase: InsertUserListUseCase,
    private val getUserListUseCase: GetUserListUseCase,
    private val insertUserUseCase: InsertUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val clearListUseCase: ClearListUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelUser::class.java)) {
            return ViewModelUser(
                 insertUserListUseCase, getUserListUseCase,
                insertUserUseCase, updateUserUseCase, clearListUseCase
            ) as T
        }
        throw RuntimeException("Unknown view model class $modelClass")
    }
}

