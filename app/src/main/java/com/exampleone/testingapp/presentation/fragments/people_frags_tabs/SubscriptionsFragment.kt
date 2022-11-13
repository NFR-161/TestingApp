package com.exampleone.testingapp.presentation.fragments.people_frags_tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.exampleone.testingapp.databinding.FragmentSubscriptionsBinding
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.adapters.SubscribeAdapter
import com.exampleone.testingapp.presentation.viewmodel.SubscripViewModel

class SubscriptionsFragment : Fragment() {


    private val binding by lazy {
        FragmentSubscriptionsBinding.inflate(layoutInflater)
    }

    lateinit var subscribeAdapter: SubscribeAdapter
    private val subscripViewModel:SubscripViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("MyLog","SubscriptionsFragment")
        setHasOptionsMenu(true)
        initRecyclerView()
        initViewModel()
        changeEnableState()
        return binding.root
    }
    private fun initRecyclerView() {

        val recyclerView = binding.rvRecycler
        val manager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = manager
        subscribeAdapter = SubscribeAdapter(context as FragmentActivity)
        recyclerView.adapter = subscribeAdapter
        recyclerView.itemAnimator = null

    }

    private fun initViewModel() {
        with(subscripViewModel) {
            users.observe(viewLifecycleOwner) {
                val list = it.filter { !it.enabled }
                subscribeAdapter.modifyList(list)
            }
            searchText.observe(viewLifecycleOwner) {
                subscribeAdapter.filter(it)
            }
        }
    }

    private fun changeEnableState() {
        subscribeAdapter.onItemClickListener = {
            subscripViewModel.updateTask(it.copy(enabled = !it.enabled))
        }
    }
}