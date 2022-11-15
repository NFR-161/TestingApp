package com.exampleone.testingapp.presentation.fragments.people_frags_tabs.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.MutuallyFragment
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.SubscribersFragment
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.SubscriptionsFragment

class PeopleStateAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                SubscribersFragment()
            }
            1 -> {
                SubscriptionsFragment()
            }
            2 -> {
                MutuallyFragment()
            }
            else -> {
                SubscribersFragment()
            }
        }
    }
}