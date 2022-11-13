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
import com.exampleone.testingapp.databinding.FragmentSubscribersBinding
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.adapters.SubscribeAdapter
import com.exampleone.testingapp.presentation.viewmodel.SubViewModel


class SubscribersFragment : Fragment() {


    private val binding by lazy {
        FragmentSubscribersBinding.inflate(layoutInflater)
    }

    lateinit var subscribeAdapter: SubscribeAdapter
    private val subViewModel: SubViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("MyLog", "SubscribersFragment")
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
        with(subViewModel) {
            users.observe(viewLifecycleOwner) {
            val list = it.filter { it.enabled }
                subscribeAdapter.modifyList(list)
            }
            searchText.observe(viewLifecycleOwner) {
                subscribeAdapter.filter(it)
            }
        }
    }
        private fun changeEnableState() {
       subscribeAdapter.onItemClickListener = {
            subViewModel.updateTask(it.copy(enabled = !it.enabled))
        }
    }

}