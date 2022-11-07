package com.exampleone.testingapp.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.DataRepository
import com.exampleone.testingapp.databinding.FragmentPeopleBinding
import com.exampleone.testingapp.presentation.adapters.PeopleStateAdapter
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.SubscribersFragment
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.adapters.SubscribersAdapter
import com.exampleone.testingapp.presentation.viewmodel.UserViewModel
import com.google.android.material.tabs.TabLayoutMediator

class PeopleFragment : Fragment() {

    private val binding by lazy {
        FragmentPeopleBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initAppbar()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPager()
    }

    private fun initAppbar() {
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.fragmentPeopleToolbar.setupWithNavController(navController, appBarConfiguration)
        binding.fragmentPeopleToolbar.title = getString(R.string.fragment_people_title)
    }

    private fun initPager(){

        binding.pager.adapter = PeopleStateAdapter(requireActivity())
        val tabLayoutMediator = binding.tabLayout.let {
            binding.pager.let { it1 ->
                TabLayoutMediator(it,
                    it1,
                    TabLayoutMediator.TabConfigurationStrategy { tab, position ->

                        when (position) {
                            0 -> {
                                tab.text = getString(R.string.subscribers)
                            }
                            1 -> {
                                tab.text = getString(R.string.subscriptions)
                            }
                            2 -> {
                                tab.text = getString(R.string.mutually)
                            }
                        }

                    })
            }
        }
        tabLayoutMediator.attach()
    }
}




