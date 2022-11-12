package com.exampleone.testingapp.presentation.fragments.people_frags_tabs

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.exampleone.testingapp.data.DataRepository
import com.exampleone.testingapp.databinding.FragmentSubscribersBinding
import com.exampleone.testingapp.domain.UserItem
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
        Log.d("MyLog", "SubscribersFragment")
        setHasOptionsMenu(true)

        initRecyclerView()
        initViewModel()
//        changeEnableState()
        initAdapterItem()

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

    //    private fun changeEnableState() {
//       tabsAdapter.onItemClickListener = {
//            subViewModel.updateTask(it.copy(enabled = !it.enabled))
//           Log.d("MyLog"," from subscribe $it")
//        }
//    }
    private fun initAdapterItem() {
        tabsAdapter.onItemClickListener = { position ->
            val listOfPeople = tabsAdapter.currentList.toMutableList()
            val userItem = listOfPeople[position]
            listOfPeople[position] = UserItem(
                id = userItem.id,
                name = userItem.name,
                enabled = !userItem.enabled,
                picUrl = userItem.picUrl
            )
            tabsAdapter.submitList(listOfPeople)
        }

    }

}