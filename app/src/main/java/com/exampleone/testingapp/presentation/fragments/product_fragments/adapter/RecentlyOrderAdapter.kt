package com.exampleone.testingapp.presentation.fragments.product_fragments.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.exampleone.testingapp.R
import com.exampleone.testingapp.databinding.ItemRecentlyBinding

class RecentlyOrderAdapter(var list: List<Int>) : RecyclerView.Adapter<RecentlyOrderAdapter.RecentlyViewHolder>() {

//    var listMoments = listOf(1, 2, 3, 4, 5, 6)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentlyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRecentlyBinding.inflate(layoutInflater, parent, false)
        return RecentlyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecentlyViewHolder, position: Int) {
        var item =  list[position]
        var isFavorite = true
        holder.fav_bt.setOnClickListener {
            Log.d("MyLog", "fav_bt.setOnClickListener ")
            if(isFavorite) {
                holder.fav_iv.setImageResource(R.drawable.ic_favorite_pressed)
                isFavorite = false
            }else{
                holder.fav_iv.setImageResource(R.drawable.ic_favorite_normal)
                isFavorite = true
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size

    }

    class RecentlyViewHolder(var binding: ItemRecentlyBinding) : RecyclerView.ViewHolder(binding.root){
     val fav_bt  = binding.btImageFav
     val fav_iv  = binding.imageFavorite


    }
}