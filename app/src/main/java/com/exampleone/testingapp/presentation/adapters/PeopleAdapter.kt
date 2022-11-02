package com.exampleone.testingapp.presentation.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.User
import com.exampleone.testingapp.databinding.ItemsPeopleEnabledBinding

class PeopleAdapter(private val userList: List<User>, val context: Context) :
    RecyclerView.Adapter<PeopleAdapter.TempAdapterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempAdapterHolder {
        val layout = R.layout.items_people_enabled
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return TempAdapterHolder(view, context)
    }

    override fun onBindViewHolder(holder: TempAdapterHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class TempAdapterHolder(private val view: View, val context: Context) :
        RecyclerView.ViewHolder(view) {

        private val binding = ItemsPeopleEnabledBinding.bind(view)
        private var subscribe: TextView = view.findViewById(R.id.subscribe)
        fun bind(item: User) {

            Glide
                .with(itemView.context)
                .load(item.picUrl)
                .into(binding.roundImage)

            binding.nameOfUser.text = item.name

            subscribe.setOnClickListener {
                if (subscribe.text.toString() == SUBSCRIBE) {
                    subscribe.text = context.getText(R.string.unsubscribe)
                    subscribe.setTextColor(context.resources.getColor(R.color.light_grey))
                } else {
                    subscribe.text = context.getText(R.string.subscribe)
                    subscribe.setTextColor(context.resources.getColor(R.color.purple))
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    companion object {
        const val SUBSCRIBE = "Subscribe"
    }


}




