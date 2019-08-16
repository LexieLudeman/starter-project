package com.possible.demo.features.followers

import androidx.recyclerview.widget.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.possible.demo.databinding.ListItemFollowerBinding

class FollowersAdapter : ListAdapter<Follower, FollowersAdapter.ViewHolder>(FollowerDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListItemFollowerBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Follower) {
            binding.follower = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemFollowerBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class FollowerDiffCallback : DiffUtil.ItemCallback<Follower>() {
    override fun areItemsTheSame(p0: Follower, p1: Follower): Boolean {
        return p0.login == p1.login
    }

    override fun areContentsTheSame(p0: Follower, p1: Follower): Boolean {
        return p0 == p1
    }
}