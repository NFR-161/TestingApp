package com.exampleone.testingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.exampleone.testingapp.adapters.ChroniclesAdapter
import com.exampleone.testingapp.adapters.MomentsAdapter
import com.exampleone.testingapp.adapters.ProfileAdapter
import com.exampleone.testingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private var profileAdapter = ProfileAdapter()
    private var momentsAdapter = MomentsAdapter()
    private var chroniclesAdapter = ChroniclesAdapter()

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        fillProfileData()
        initAdapters()

    }

    private fun fillProfileData() {
        binding.tvRate.text = getString(R.string.rate_for_profile)
        binding.tvName.text = getString(R.string.name_for_profile)
        binding.tvCities.text = getString(R.string.cities_for_profile)
        binding.tvLanguage.text = getString(R.string.language_for_profile)
    }

    private fun initAdapters() {
        binding.apply {
            rcProfile.adapter = profileAdapter
            rcMoments.adapter = momentsAdapter
            rcChronicles.adapter = chroniclesAdapter

        }
    }

}