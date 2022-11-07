package com.exampleone.testingapp.presentation.fragments.people_frags_tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.exampleone.testingapp.databinding.FragmentSubscribersBinding
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.adapters.SubscribersAdapter
import com.exampleone.testingapp.presentation.viewmodel.UserViewModel


class SubscribersFragment : Fragment() {

    private val binding by lazy {
        FragmentSubscribersBinding.inflate(layoutInflater)
    }
    lateinit var subscribersAdapter: SubscribersAdapter
    lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun initRecyclerView() {
      viewModel = ViewModelProvider(this)[UserViewModel::class.java]
      viewModel.users.observe(viewLifecycleOwner) {
            subscribersAdapter.submitList(it)
        }
        val recyclerView = binding.rvRecycler
        val manager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = manager
        recyclerView.setHasFixedSize(true)
        subscribersAdapter = SubscribersAdapter(context as FragmentActivity)
        recyclerView.adapter = subscribersAdapter

    }
}