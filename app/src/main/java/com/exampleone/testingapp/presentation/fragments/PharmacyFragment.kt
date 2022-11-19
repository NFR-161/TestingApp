package com.exampleone.testingapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.exampleone.testingapp.R
import com.exampleone.testingapp.databinding.FragmentPeopleBinding
import com.exampleone.testingapp.databinding.FragmentPharmacyBinding
import com.exampleone.testingapp.presentation.fragments.product_fragments.adapter.ProductStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import me.relex.circleindicator.CircleIndicator3


class PharmacyFragment : Fragment() {


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


}
