package com.exampleone.testingapp.presentation.fragments.people_frags_tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.DataRepository
import com.exampleone.testingapp.databinding.FragmentSubscribersBinding
import com.exampleone.testingapp.domain.useCases.GetUserListUseCase
import com.exampleone.testingapp.domain.useCases.InsertUserUseCase
import com.exampleone.testingapp.domain.useCases.UpdateUserUseCase
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.adapters.SubscribersAdapter
import com.exampleone.testingapp.presentation.viewmodel.UserViewModel

class SubscribersFragment(): Fragment() {

    private val binding by lazy {
        FragmentSubscribersBinding.inflate(layoutInflater)
    }

    private val dataRepository = DataRepository()
    private lateinit var subscribersAdapter: SubscribersAdapter
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initRecyclerView()
        return inflater.inflate(R.layout.fragment_subscribers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.users.observe(viewLifecycleOwner) {
            subscribersAdapter.submitList(it)
        }

    }

    private fun initRecyclerView() {
        val recyclerView = binding.rvSubscribers
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        subscribersAdapter = SubscribersAdapter(requireContext())
        recyclerView.adapter = subscribersAdapter
    }
}