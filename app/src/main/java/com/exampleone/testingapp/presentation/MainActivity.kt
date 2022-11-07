package com.exampleone.testingapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.annotation.RestrictTo
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.DataRepository
import com.exampleone.testingapp.data.RepositoryImpl
import com.exampleone.testingapp.databinding.ActivityMainBinding
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.SubscribersFragment
import com.exampleone.testingapp.presentation.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel

    val dataRepository = DataRepository()
    private lateinit var navController: NavController


    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.place_holder) as NavHostFragment
        navController = navHostFragment.navController
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        userViewModel.insertUserList(dataRepository.getPersonList())
    }
}