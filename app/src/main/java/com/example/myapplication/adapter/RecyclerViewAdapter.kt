package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.myapplication.R
import com.example.myapplication.data.Item
import com.example.myapplication.databinding.ViewHolderItemBinding

/**
 * Recycler view class for showing the list of items
 */
class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ListItemViewHolder>() {

    private var itemList = listOf<Item>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
      return ListItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        (holder).onBind(itemList[position])
    }

    fun submitList(newItems: List<Item>) {
        itemList = newItems
        notifyDataSetChanged()
    }

    inner class ListItemViewHolder(parent: ViewGroup) : ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_item, parent, false)
    ) {
        private val binding = ViewHolderItemBinding.bind(itemView)

        fun onBind(
            item: Item
        ) {
            item.listId.also {
                if (it != null) {
                    binding.listId = it
                }
            }
            binding.name = item.name
            binding.executePendingBindings()
        }
    }
}