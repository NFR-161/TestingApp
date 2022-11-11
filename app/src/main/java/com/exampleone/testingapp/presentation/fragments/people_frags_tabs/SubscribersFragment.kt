package com.exampleone.testingapp.presentation.fragments.people_frags_tabs

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.exampleone.testingapp.data.DataRepository
import com.exampleone.testingapp.databinding.FragmentSubscribersBinding
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.adapters.TabsAdapter
import com.exampleone.testingapp.presentation.viewmodel.SubViewModel


class SubscribersFragment : Fragment() {

    private val dataRepository = DataRepository()

    private val binding by lazy {
        FragmentSubscribersBinding.inflate(layoutInflater)
    }

    lateinit var tabsAdapter: TabsAdapter
    private val subViewModel: SubViewModel by activityViewModels()


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
        tabsAdapter = TabsAdapter(context as FragmentActivity)
        recyclerView.adapter = tabsAdapter
        recyclerView.itemAnimator = null

    }

    private fun initViewModel() {
        with(subViewModel) {
            clear()
            insertUserList(dataRepository.getSubList())
            users.observe(viewLifecycleOwner) {
                tabsAdapter.modifyList(it)
            }
            searchText.observe(viewLifecycleOwner) {
                tabsAdapter.filter(it)
            }
        }
    }
}