package com.exampleone.testingapp.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exampleone.testingapp.databinding.ItemsMomentsBinding

class MomentsAdapter : RecyclerView.Adapter<MomentsAdapter.MomentViewHolder>() {

    private var listMoments = listOf(1, 2, 3, 4, 5, 6)

    class MomentViewHolder(binding: ItemsMomentsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemsMomentsBinding.inflate(layoutInflater, parent, false)
        return MomentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MomentViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return listMoments.size
    }
}

