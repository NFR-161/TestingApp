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
import androidx.recyclerview.widget.LinearLayoutManager
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.Repository
import com.exampleone.testingapp.data.User
import com.exampleone.testingapp.databinding.FragmentPeopleBinding
import com.exampleone.testingapp.presentation.adapters.PeopleAdapter
import java.util.ArrayList

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
        initRecyclerView()
        initAppbar()
        initAdapterItem()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        peopleAdapter.submitList(repository.getPersonList())

    }

    private fun initRecyclerView() {
        val recyclerView = binding.rcPeople
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        peopleAdapter = PeopleAdapter(requireContext())
        recyclerView.adapter = peopleAdapter
    }

      private fun initAdapterItem() {

          peopleAdapter.onItemClickListener = { position ->
              val listOfPeople = peopleAdapter.currentList.toMutableList()
              val userItem = listOfPeople [position]
              listOfPeople [position] = User(
                  id = userItem.id,
                  name = userItem.name,
                  enabled = !userItem.enabled,
                  picUrl = userItem.picUrl
              )
              peopleAdapter.submitList(listOfPeople )
          }
      }

    private fun initAppbar() {
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.fragmentPeopleToolbar.setupWithNavController(navController, appBarConfiguration)
        binding.fragmentPeopleToolbar.title = getString(R.string.fragment_people_title)
    }

}
