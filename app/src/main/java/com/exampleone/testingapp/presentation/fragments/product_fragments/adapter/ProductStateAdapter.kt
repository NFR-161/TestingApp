package com.exampleone.testingapp.presentation.fragments.product_fragments.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.exampleone.testingapp.presentation.fragments.product_fragments.FirstFragment
import com.exampleone.testingapp.presentation.fragments.product_fragments.SecondFragment
import com.exampleone.testingapp.presentation.fragments.product_fragments.ThirdFragment

class ProductStateAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> {
                    FirstFragment()
                }
                1 -> {
                    SecondFragment()
                }
                2 -> {
                    ThirdFragment()
                }
                else -> {
                    FirstFragment()
                }
            }
        }

    }