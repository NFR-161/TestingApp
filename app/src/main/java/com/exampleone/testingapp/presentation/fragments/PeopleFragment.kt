package com.exampleone.testingapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.DataRepository
import com.exampleone.testingapp.databinding.FragmentPeopleBinding
import com.exampleone.testingapp.presentation.adapters.PeopleStateAdapter
import com.exampleone.testingapp.presentation.viewmodel.MutuallyViewModel
import com.exampleone.testingapp.presentation.viewmodel.SubViewModel
import com.exampleone.testingapp.presentation.viewmodel.SubscripViewModel
import com.google.android.material.tabs.TabLayoutMediator

class PeopleFragment : Fragment() {

    private val binding by lazy {
        FragmentPeopleBinding.inflate(layoutInflater)
    }

    private val subViewModel: SubViewModel by activityViewModels()
    private val subscripViewModel: SubscripViewModel by activityViewModels()
    private val mutuallyViewModel: MutuallyViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("MyLog", " PeopleFragment")
        test()
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

    private fun initPager() {
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

    fun test() {
        val searchView =
            binding.fragmentPeopleToolbar.menu.findItem(R.id.search).actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    subViewModel.initSearchText(newText)
                    subscripViewModel.initSearchText(newText)
                    mutuallyViewModel.initSearchText(newText)
                }
                return false
            }
        })
    }
}






