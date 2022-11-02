package com.exampleone.testingapp.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.Repository
import com.exampleone.testingapp.data.User
import com.exampleone.testingapp.databinding.FragmentPeopleBinding
import com.exampleone.testingapp.presentation.adapters.PeopleAdapter

class PeopleFragment : Fragment() {

    private lateinit var peopleAdapter: PeopleAdapter
    private val repository = Repository()

    private val binding by lazy {
        FragmentPeopleBinding.inflate(layoutInflater)
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

        initPeopleAdapter()
        initAppbar()
    }

    private fun initPeopleAdapter() {
        val peopleList = repository.getPersonList()
        peopleAdapter = PeopleAdapter(peopleList, activity as Context)
        binding.rcPeople.adapter = peopleAdapter
    }

    private fun initAppbar() {
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.fragmentPeopleToolbar.setupWithNavController(navController, appBarConfiguration)
        binding.fragmentPeopleToolbar.title = getString(R.string.fragment_people_title)
    }

}
