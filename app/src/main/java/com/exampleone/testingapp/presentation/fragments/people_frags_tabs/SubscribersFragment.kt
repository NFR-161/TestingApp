package com.exampleone.testingapp.presentation.fragments.people_frags_tabs

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.DataRepository
import com.exampleone.testingapp.data.UserModel
import com.exampleone.testingapp.data.mappers.UserMapper
import com.exampleone.testingapp.databinding.FragmentSubscribersBinding
import com.exampleone.testingapp.domain.UserItem
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.adapters.SubscribersAdapter
import com.exampleone.testingapp.presentation.viewmodel.UserViewModel


class SubscribersFragment : Fragment() {

    private val dataRepository = DataRepository()

    private val binding by lazy {
        FragmentSubscribersBinding.inflate(layoutInflater)
    }
    lateinit var subscribersAdapter: SubscribersAdapter
    private val viewModel: UserViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        initRecyclerView()
        initViewModel()

        return binding.root
    }

    private fun initRecyclerView() {
        val recyclerView = binding.rvRecycler
        val manager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = manager
        subscribersAdapter = SubscribersAdapter(context as FragmentActivity)
        recyclerView.adapter = subscribersAdapter
        recyclerView.itemAnimator = null

    }

    private fun initViewModel() {
        with(viewModel) {
            clear()
            insertUserList(dataRepository.getSubList())
            users.observe(viewLifecycleOwner) {
                subscribersAdapter.modifyList(it)
            }
            searchText.observe(viewLifecycleOwner) {
                subscribersAdapter.filter(it)
            }
        }
    }
}