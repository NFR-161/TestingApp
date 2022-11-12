package com.exampleone.testingapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.DataRepository
import com.exampleone.testingapp.databinding.ActivityMainBinding
import com.exampleone.testingapp.presentation.viewmodel.SubViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    val dataRepository = DataRepository()
    lateinit var  subViewModel: SubViewModel

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        Log.d("MyLog"," MainActivity")

        initSubScribeList()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.place_holder) as NavHostFragment
        navController = navHostFragment.navController

    }

    private fun initSubScribeList(){
        subViewModel = ViewModelProvider(this)[SubViewModel::class.java]
        subViewModel.clear()
        subViewModel.insertUserList(dataRepository.getSubList())

    }

}