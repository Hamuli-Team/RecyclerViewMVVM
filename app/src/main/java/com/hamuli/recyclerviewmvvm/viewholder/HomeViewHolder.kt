package com.hamuli.recyclerviewmvvm.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.hamuli.recyclerviewmvvm.databinding.ItemMainBinding
import com.hamuli.recyclerviewmvvm.model.MData

class HomeViewHolder(private val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(main: MData?) {
        binding.mainData = main
        binding.executePendingBindings()
    }

}