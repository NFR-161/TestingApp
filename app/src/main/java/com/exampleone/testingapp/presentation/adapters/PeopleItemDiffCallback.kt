package com.exampleone.testingapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.exampleone.testingapp.data.User

class PeopleItemDiffCallback : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
