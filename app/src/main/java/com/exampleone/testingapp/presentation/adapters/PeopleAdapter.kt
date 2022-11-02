package com.exampleone.testingapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exampleone.testingapp.R
import com.exampleone.testingapp.data.User
import com.exampleone.testingapp.databinding.ItemsPeopleBinding


class PeopleAdapter(private var userList: List<User>, val context: Context) :
    RecyclerView.Adapter<PeopleAdapter.TempAdapterHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempAdapterHolder {
        val layout = R.layout.items_people
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

        private val binding = ItemsPeopleBinding.bind(view)

        fun bind(user: User) {
            binding.apply {
                Glide
                    .with(itemView.context)
                    .load(user.picUrl)
                    .into(roundImage)

                nameOfUser.text = user.name
                subscribe.setOnClickListener {

                    if (subscribe.text == SUBSCRIBE) {
                        subscribe.text = context.getText(R.string.unsubscribe)
                        subscribe.setTextColor(context.resources.getColor(R.color.light_grey))

                    } else {
                        subscribe.text = context.getText(R.string.subscribe)
                        subscribe.setTextColor(context.resources.getColor(R.color.purple))
                    }
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




