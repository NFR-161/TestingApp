package com.exampleone.testingapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exampleone.testingapp.databinding.ItemsProfileBinding

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ProfileImageHolder>() {

    private val listImages = listOf(1, 2, 3, 4)

    class ProfileImageHolder(binding: ItemsProfileBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileImageHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemsProfileBinding.inflate(layoutInflater, parent, false)
        return ProfileImageHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileImageHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return listImages.size
    }
}