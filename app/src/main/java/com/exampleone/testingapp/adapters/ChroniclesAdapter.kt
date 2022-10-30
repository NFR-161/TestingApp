package com.exampleone.testingapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exampleone.testingapp.databinding.ItemsChroniclesBinding

class ChroniclesAdapter : RecyclerView.Adapter<ChroniclesAdapter.ChroniclesViewHolder>() {
    private var listChronicles = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

    class ChroniclesViewHolder(binding: ItemsChroniclesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChroniclesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemsChroniclesBinding.inflate(layoutInflater, parent, false)
        return ChroniclesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChroniclesViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return listChronicles.size
    }
}