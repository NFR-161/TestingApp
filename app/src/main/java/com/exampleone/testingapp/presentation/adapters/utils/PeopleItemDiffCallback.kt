package com.exampleone.testingapp.presentation.adapters.utils

import androidx.recyclerview.widget.DiffUtil
import com.exampleone.testingapp.domain.UserItem

class PeopleItemDiffCallback : DiffUtil.ItemCallback<UserItem>() {

    override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
        return oldItem == newItem
    }
}