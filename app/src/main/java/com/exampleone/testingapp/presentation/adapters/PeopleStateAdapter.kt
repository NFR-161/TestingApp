package com.exampleone.testingapp.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.Mutually
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.Subscribers
import com.exampleone.testingapp.presentation.fragments.people_frags_tabs.Subscriptions

class PeopleStateAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                Subscribers()
            }
            1 -> {
                Subscriptions()
            }
            2 -> {
                Mutually()
            }
            else -> {
                Subscribers()
            }
        }
    }
}