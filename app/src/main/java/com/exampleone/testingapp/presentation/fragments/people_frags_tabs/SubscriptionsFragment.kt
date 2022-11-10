package com.exampleone.testingapp.presentation.fragments.people_frags_tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.exampleone.testingapp.data.DataRepository
import com.exampleone.testingapp.databinding.FragmentSubscriptionsBinding
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.adapters.SubscriptionsAdapter
import com.exampleone.testingapp.presentation.viewmodel.UserViewModel

class SubscriptionsFragment : Fragment() {

    val dataRepository = DataRepository()
    private val binding by lazy {
        FragmentSubscriptionsBinding.inflate(layoutInflater)
    }

    lateinit var subscriptionsAdapter: SubscriptionsAdapter
    lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initRecyclerView()
        return binding.root
    }
    private fun initRecyclerView() {
        initSubAdapterWithLists()
        val recyclerView = binding.rvRecycler
        val manager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = manager
        subscriptionsAdapter = SubscriptionsAdapter(context as FragmentActivity)
        recyclerView.adapter = subscriptionsAdapter

    }

    private fun initSubAdapterWithLists() {
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.clear()
        viewModel.insertUserList(dataRepository.getSubscripList())
        viewModel.users.observe(viewLifecycleOwner) {
            subscriptionsAdapter.submitList(it)
        }
    }

}