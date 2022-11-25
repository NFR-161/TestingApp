package com.exampleone.testingapp.presentation.fragments.product_fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exampleone.testingapp.databinding.ItemActionBinding


class ActionAdapter(var list: List<Int>) : RecyclerView.Adapter<ActionAdapter.ActionViewHolder>() {

//    var listMoments = listOf(1, 2, 3, 4, 5, 6)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemActionBinding.inflate(layoutInflater, parent, false)
        return ActionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActionViewHolder, position: Int) {
        var item =  list[position]
        holder.image.setBackgroundResource(item)
    }

    override fun getItemCount(): Int {
        return list.size

    }

    class ActionViewHolder(var binding: ItemActionBinding) : RecyclerView.ViewHolder(binding.root){
        var image =  binding.imageAction
    }
}