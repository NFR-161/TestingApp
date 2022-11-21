package com.exampleone.testingapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.exampleone.testingapp.databinding.FragmentPharmacyBinding
import com.exampleone.testingapp.presentation.fragments.product_fragments.adapter.ActionAdapter
import com.exampleone.testingapp.presentation.fragments.product_fragments.adapter.ProductStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.relex.circleindicator.CircleIndicator3


class PharmacyFragment : Fragment() {

    private val actionAdapter = ActionAdapter()

    var isAutoScroll = true

    var coroutineScope = CoroutineScope(Dispatchers.Main)
    private val binding by lazy {
        FragmentPharmacyBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPager()
        initCircleIndicator()
        initAdapters()

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
        binding.rcAction.layoutManager = MyLinearLayoutManager(
            requireContext(),
            HORIZONTAL,
            false
        )

        binding.rcAction.adapter = actionAdapter
        launchAutoscroll()
    }

    private fun launchAutoscroll() {
        val interval = 2000
        var count = 0
        val layoutManager = MyLinearLayoutManager(requireContext(), 0, false)
        binding.apply {
            coroutineScope.launch {
                while (isAutoScroll) {
                    for (i in count until actionAdapter.itemCount + 3) {
                        rcAction.smoothScrollToPosition(count)
                        Log.d("MyLog", "1 count: $count")
                        count++
                        delay(interval.toLong())

                        if (count >= actionAdapter.itemCount + 3) {
                            while (count > 0) {
                                rcAction.smoothScrollToPosition(layoutManager.findLastCompletelyVisibleItemPosition() + 1)
                                Log.d("MyLog", "2 count: $count")
                                count--
                                delay(interval.toLong())
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        isAutoScroll = false
    }
}


