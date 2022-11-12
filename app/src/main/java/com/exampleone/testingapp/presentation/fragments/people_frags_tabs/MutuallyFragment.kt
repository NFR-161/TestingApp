package com.exampleone.testingapp.presentation.fragments.people_frags_tabs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.exampleone.testingapp.data.DataRepository
import com.exampleone.testingapp.databinding.FragmentMutuallyBinding
import com.exampleone.testingapp.domain.UserItemSubscribe
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.adapters.SubscribeAdapter
import com.exampleone.testingapp.presentation.viewmodel.MutuallyViewModel


class MutuallyFragment : Fragment() {

    val dataRepository = DataRepository()

    private val binding by lazy {
        FragmentMutuallyBinding.inflate(layoutInflater)
    }

    lateinit var subscribeAdapter: SubscribeAdapter
    private val mutuallyViewModel:MutuallyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("MyLog","MutuallyFragment")
        setHasOptionsMenu(true)
        initRecyclerView()
//        initViewModel()
//        changeEnableState()
//        initAdapterItem()
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

//    private fun initViewModel() {
//        with(mutuallyViewModel) {
//            clear()
//            insertUserList(dataRepository.getMutList())
//            users.observe(viewLifecycleOwner) {
//                subscribeAdapter.modifyList(it)
//            }
//            searchText.observe(viewLifecycleOwner) {
//                subscribeAdapter.filter(it)
//            }
//        }
//    }

//private fun initAdapterItem() {
//    subscribeAdapter.onItemClickListener = { position ->
//        val listOfPeople = subscribeAdapter.currentList.toMutableList()
//        val userItem = listOfPeople [position]
//        listOfPeople [position] = UserItemSubscribe(
//            id = userItem.id,
//            name = userItem.name,
//            enabled = !userItem.enabled,
//            picUrl = userItem.picUrl
//        )
//        mutuallyViewModel.updateTask(userItem.copy(enabled = !userItem.enabled))
//        subscribeAdapter.submitList(listOfPeople )
//    }
//}
}