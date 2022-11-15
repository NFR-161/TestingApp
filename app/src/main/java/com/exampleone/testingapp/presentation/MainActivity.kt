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
import com.exampleone.testingapp.di.UserApp
import com.exampleone.testingapp.domain.useCases.*
import com.exampleone.testingapp.presentation.viewmodel.ViewFactoryUser
import com.exampleone.testingapp.presentation.viewmodel.ViewModelUser
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    lateinit var viewModelUser: ViewModelUser

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val component by lazy {
        (application as UserApp).component
    }

    @Inject
    lateinit var viewFactoryUser: ViewFactoryUser

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
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
        viewModelUser = ViewModelProvider(this, viewFactoryUser)[ViewModelUser::class.java]
        viewModelUser.clear()
        viewModelUser.insertUserList()
    }

}