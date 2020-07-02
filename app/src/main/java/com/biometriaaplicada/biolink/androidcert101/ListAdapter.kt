package com.biometriaaplicada.biolink.androidcert101

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*
import kotlin.properties.Delegates

class ListAdapter() : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    var dataSource: MutableList<Pair<String, String>>
            by Delegates.observable(mutableListOf()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(dataSource[position])
    }

    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: Pair<String, String>) {
            itemView.tvListTitle.text = data.first
            itemView.tvListContent.text = data.second
        }
    }

}
