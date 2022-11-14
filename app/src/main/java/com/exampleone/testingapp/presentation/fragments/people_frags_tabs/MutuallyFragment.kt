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
import com.exampleone.testingapp.databinding.FragmentMutuallyBinding
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.adapters.TabsAdapter
import com.exampleone.testingapp.presentation.viewmodel.SubViewModel


class MutuallyFragment : Fragment() {

    private val binding by lazy {
        FragmentMutuallyBinding.inflate(layoutInflater)
    }

    lateinit var tabsAdapter: TabsAdapter
//    private val mutuallyViewModel:MutuallyViewModel by activityViewModels()
private val subViewModel: SubViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("MyLog","MutuallyFragment")
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
        tabsAdapter = TabsAdapter(context as FragmentActivity)
        recyclerView.adapter = tabsAdapter
        recyclerView.itemAnimator = null

    }

    private fun initViewModel() {
        with(subViewModel) {
            users.observe(viewLifecycleOwner) {
                tabsAdapter.modifyList(it)
            }
            searchText.observe(viewLifecycleOwner) {
                tabsAdapter.filter(it)
            }
        }
    }
    private fun changeEnableState() {
        tabsAdapter.onItemClickListener = {
            subViewModel.updateTask(it.copy(enabled = !it.enabled))

        }
    }
}