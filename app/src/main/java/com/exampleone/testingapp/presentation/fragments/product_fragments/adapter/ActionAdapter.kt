package com.exampleone.testingapp.presentation.fragments.product_fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exampleone.testingapp.databinding.ItemActionBinding
import com.exampleone.testingapp.databinding.ItemsMomentsBinding

class ActionAdapter : RecyclerView.Adapter<ActionAdapter.ActionViewHolder>() {

     var listMoments = listOf(1, 2, 3, 4, 5, 6)

    class ActionViewHolder(binding: ItemActionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemActionBinding.inflate(layoutInflater, parent, false)
        return ActionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActionViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return listMoments.size
    }
}