package com.exampleone.testingapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.DataRepository
import com.exampleone.testingapp.databinding.FragmentAccountBinding
import com.exampleone.testingapp.presentation.adapters.ChroniclesAdapter
import com.exampleone.testingapp.presentation.adapters.MomentsAdapter
import com.exampleone.testingapp.presentation.adapters.ProfileAdapter
import com.exampleone.testingapp.presentation.viewmodel.UserViewModel

class AccountFragment: Fragment() {

    private var profileAdapter = ProfileAdapter()
    private var momentsAdapter = MomentsAdapter()
    private var chroniclesAdapter = ChroniclesAdapter()

    private lateinit var viewModel: UserViewModel
    private var dataRepository = DataRepository()

    private val binding by lazy {
        FragmentAccountBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillProfileData()
        initAdapters()

        binding.BtPeople.setOnClickListener {
            view.findNavController().navigate(R.id.action_accountFragment_to_peopleFragment2)
        }
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.insert(dataRepository.getPersonList())
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