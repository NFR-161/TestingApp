package com.exampleone.testingapp.adapters

import android.app.Activity
import android.app.Application
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.User
import com.exampleone.testingapp.databinding.ItemsPeopleEnabledBinding

class PeopleAdapter(private val userList: Array<User>) : RecyclerView.Adapter<PeopleAdapter.TempAdapterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempAdapterHolder {
        val layout = R.layout.items_people_enabled
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return TempAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: TempAdapterHolder, position: Int) {
        holder.bind(userList[position] )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class TempAdapterHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemsPeopleEnabledBinding.bind(view)
        private var subscribe: TextView = view.findViewById(R.id.subscribe)
        fun bind(item: User) {
            Glide
                .with(itemView.context)
                .load(item.imageView)
                .into(binding.roundImage)

                subscribe.setOnClickListener {
                    if (subscribe.text.toString() == "Subscribe") {
                        subscribe.text = "Unsubscribe"
                        subscribe.setTextColor(Color.parseColor("#99FFFFFF"))
                    } else {
                        subscribe.text = "Subscribe"
                        subscribe.setTextColor(Color.parseColor("#9575CD"))
                    }
                }
        }
    }
    override fun getItemViewType(position: Int): Int {
         return position
    }
}




