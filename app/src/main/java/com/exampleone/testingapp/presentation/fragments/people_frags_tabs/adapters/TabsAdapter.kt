package com.exampleone.testingapp.presentation.fragments.people_frags_tabs.adapters

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
import com.exampleone.testingapp.domain.UserItem
import com.exampleone.testingapp.presentation.adapters.utils.PeopleItemDiffCallback
import java.util.*

class TabsAdapter(val context: Context) :
    ListAdapter<UserItem, TabsAdapter.TempAdapterHolder>(PeopleItemDiffCallback()) {

    private var unfilteredlist = listOf<UserItem>()


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
            Log.d("MyLog","${userItem.enabled}")

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

    private fun launchGlide (holder: TempAdapterHolder, picUrl:String): ViewTarget<ImageView, Drawable> {
        return  Glide.with(holder.view.context).load(picUrl).into(holder.roundImage)
    }

    fun modifyList(list: List<UserItem>) {
        unfilteredlist = list
        submitList(list)
    }
    fun filter(query: CharSequence?) {
        val list = mutableListOf<UserItem>()

        if (!query.isNullOrEmpty()) {
            list.addAll(unfilteredlist.filter {
                it.name.lowercase(Locale.getDefault()).contains(query.toString().lowercase(Locale.getDefault())) })
        } else {
            list.addAll(unfilteredlist)
        }
        submitList(list)
    }

    override fun onViewRecycled(holder: TempAdapterHolder) {
        super.onViewRecycled(holder)
        holder.tvSubscribe.text = context.resources.getText(R.string.subscribe)
        holder.tvSubscribe.setTextColor(context.resources.getColor(R.color.purple))
    }
}

