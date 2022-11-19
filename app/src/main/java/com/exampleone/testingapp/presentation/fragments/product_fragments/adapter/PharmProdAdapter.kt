package com.exampleone.testingapp.presentation.fragments.product_fragments.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exampleone.testingapp.R
import com.google.android.material.imageview.ShapeableImageView

class PharmProdAdapter(val context: Context,private val listImages:MutableList<String>) : RecyclerView.Adapter<PharmProdAdapter.TempAdapterHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempAdapterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        return TempAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: TempAdapterHolder, position: Int) {
        Glide
            .with(context)
            .load(listImages[position])
            .into(holder.shapeImage)

    }

    override fun getItemCount(): Int {
        return 6
    }
    class TempAdapterHolder(item: View) : RecyclerView.ViewHolder(item) {
        var shapeImage = item.findViewById<ShapeableImageView>(R.id.round_image)


    }

}