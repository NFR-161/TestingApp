package com.exampleone.testingapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.DataBase
import com.exampleone.testingapp.data.RepositoryImpl
import com.exampleone.testingapp.databinding.ActivityMainBinding
import com.exampleone.testingapp.domain.useCases.*
import com.exampleone.testingapp.presentation.viewmodel.ViewFactoryUser
import com.exampleone.testingapp.presentation.viewmodel.ViewModelUser

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    lateinit var viewModelUser: ViewModelUser

    private lateinit var repository: RepositoryImpl
    private lateinit var insertUserListUseCase: InsertUserListUseCase
    private lateinit var getUserListUseCase: GetUserListUseCase
    private lateinit var insertUserUseCase: InsertUserUseCase
    private lateinit var updateUserUseCase: UpdateUserUseCase
    private lateinit var clearListUseCase: ClearListUseCase

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        Log.d("MyLog", " MainActivity")

        initData()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.place_holder) as NavHostFragment
        navController = navHostFragment.navController

    }

    private fun initData() {
        val userDao = DataBase.getInstance(this).userDAO
        repository = RepositoryImpl(userDao)
        insertUserListUseCase = InsertUserListUseCase(repository)
        getUserListUseCase = GetUserListUseCase(repository)
        insertUserUseCase = InsertUserUseCase(repository)
        updateUserUseCase = UpdateUserUseCase(repository)
        clearListUseCase = ClearListUseCase(repository)

        val viewModelFactory = ViewFactoryUser(
            insertUserListUseCase, getUserListUseCase,
            insertUserUseCase, updateUserUseCase, clearListUseCase

        )
        viewModelUser = ViewModelProvider(this, viewModelFactory)[ViewModelUser::class.java]
        viewModelUser.clear()
        viewModelUser.insertUserList()
    }

}