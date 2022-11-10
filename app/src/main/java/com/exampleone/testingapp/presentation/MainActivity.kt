package com.exampleone.testingapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.DataRepository
import com.exampleone.testingapp.databinding.ActivityMainBinding
import com.exampleone.testingapp.presentation.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    lateinit var viewModel: UserViewModel

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

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.d("MyLog"," from search: onCreateOptionsMenu")
        return super.onCreateOptionsMenu(menu)
    }
}