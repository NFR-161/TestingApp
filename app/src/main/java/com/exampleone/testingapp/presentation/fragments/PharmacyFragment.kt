package com.exampleone.testingapp.presentation.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL

import com.exampleone.testingapp.databinding.FragmentPharmacyBinding
import com.exampleone.testingapp.presentation.fragments.product_fragments.adapter.ActionAdapter
import com.exampleone.testingapp.presentation.fragments.product_fragments.adapter.ProductStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import me.relex.circleindicator.CircleIndicator3


class PharmacyFragment : Fragment() {

    //    private val actionAdapter = ActionAdapter()
    lateinit var actionAdapter: ActionAdapter

//    var isAutoScroll = true

    //    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    private val binding by lazy {
        FragmentPharmacyBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val toolbar = binding.fragmentPharmToolbar
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)

        Log.d("MyLog", "onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPager()
        initCircleIndicator()
        initAdapters()
        Log.d("MyLog", "onViewCreated")

    }

    private fun initPager() {
        binding.viewPager.adapter = ProductStateAdapter(requireActivity())

        val tabLayoutMediator = binding.tabLayout.let {
            binding.viewPager.let { it1 ->
                TabLayoutMediator(it,
                    it1,
                    TabLayoutMediator.TabConfigurationStrategy { tab, position -> })
            }
        }
        tabLayoutMediator.attach()
    }

    private fun initCircleIndicator() {

        val indicator: CircleIndicator3 = binding.indicator
        indicator.setViewPager(binding.viewPager)
    }

    private fun initAdapters() {
        actionAdapter = ActionAdapter(initList())
        binding.rcAction.adapter = actionAdapter
//        val manager = MyLinearLayoutManager(requireContext(), HORIZONTAL,false)
        val manager = LinearLayoutManager(requireContext())
        manager.orientation = HORIZONTAL
        binding.rcAction.layoutManager = manager
        binding.rcAction.animation = null

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.rcAction)

        binding.rcAction.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (manager.findFirstCompletelyVisibleItemPosition() == 0
                    || manager.findLastCompletelyVisibleItemPosition() == 5
                ) {
                    snapHelper.attachToRecyclerView(null)
                } else {
                    snapHelper.attachToRecyclerView(binding.rcAction)
                }
            }
        })
    }


    override fun onResume() {
        super.onResume()
        Log.d("MyLog", "onResume")
//        isAutoScroll = true
//        launchAutoscroll()
    }

    override fun onPause() {
        super.onPause()
        Log.d("MyLog", "onPause")
//        isAutoScroll = false
    }


    private fun initList(): List<Int> {
        return listOf(
            com.exampleone.testingapp.R.drawable.three,
            com.exampleone.testingapp.R.drawable.one,
            com.exampleone.testingapp.R.drawable.two,
            com.exampleone.testingapp.R.drawable.abstrakciya,
            com.exampleone.testingapp.R.drawable.user_image,
            com.exampleone.testingapp.R.drawable.turtle
        )
    }

//    private fun launchAutoscroll() {
//        val interval = 2000
//        var count = 0
//        binding.apply {
//            coroutineScope.launch {
//                while (isAutoScroll) {
//                    for (i in count until actionAdapter.itemCount) {
//                        rcAction.smoothScrollToPosition(count)
//                        Log.d("MyLog", "1 count: $count")
//                        count++
//                        delay(interval.toLong())
//
//                        if (count >= actionAdapter.itemCount) {
//                            while (count > 0) {
//                                rcAction.smoothScrollToPosition(count)
//                                Log.d("MyLog", "2 count: $count")
//                                count--
//                                delay(interval.toLong())
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
}
//}


