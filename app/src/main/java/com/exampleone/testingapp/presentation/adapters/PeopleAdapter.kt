package com.exampleone.testingapp.presentation.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.ViewTarget
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.User
import com.exampleone.testingapp.databinding.ItemsPeopleBinding


class PeopleAdapter(val context: Context) :
    ListAdapter<User, PeopleAdapter.TempAdapterHolder>(PeopleItemDiffCallback()) {


    var onItemClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempAdapterHolder {
        val layout = R.layout.items_people
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return TempAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: TempAdapterHolder, position: Int) {
        val userItem = getItem(position)

        holder.tvSubscribe.setOnClickListener {
            onItemClickListener?.invoke(position)

        }
        if (userItem.enabled) {
            holder.tvSubscribe.text = context.resources.getText(R.string.subscribe)
            holder.tvSubscribe.setTextColor(context.resources.getColor(R.color.purple))
        } else {
            holder.tvSubscribe.text = context.resources.getText(R.string.unsubscribe)
            holder.tvSubscribe.setTextColor(context.resources.getColor(R.color.light_grey))
        }

        launchGlide(holder,userItem.picUrl)
        holder.tvNameOfUser.text = userItem.name

    }

    class TempAdapterHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvSubscribe = view.findViewById<TextView>(R.id.subscribe)
        var tvNameOfUser = view.findViewById<TextView>(R.id.nameOfUser)
        val roundImage = view.findViewById<ImageView>(R.id.round_image)
    }

    fun launchGlide (holder: TempAdapterHolder, picUrl:String): ViewTarget<ImageView, Drawable> {
       return  Glide.with(holder.view.context).load(picUrl).into(holder.roundImage)

    }

}




