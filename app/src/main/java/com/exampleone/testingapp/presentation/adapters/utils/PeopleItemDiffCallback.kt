package com.exampleone.testingapp.presentation.adapters.utils

import androidx.recyclerview.widget.DiffUtil
import com.exampleone.testingapp.domain.UserItemSubscribe

class PeopleItemDiffCallback : DiffUtil.ItemCallback<UserItemSubscribe>() {

    override fun areItemsTheSame(oldItem: UserItemSubscribe, newItem: UserItemSubscribe): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserItemSubscribe, newItem: UserItemSubscribe): Boolean {
        return oldItem == newItem
    }
}