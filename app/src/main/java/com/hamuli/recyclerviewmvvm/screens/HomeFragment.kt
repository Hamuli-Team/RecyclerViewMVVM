package com.hamuli.recyclerviewmvvm.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.ListAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamuli.recyclerviewmvvm.databinding.FragmentHomeBinding
import com.hamuli.recyclerviewmvvm.databinding.ItemMainBinding
import com.hamuli.recyclerviewmvvm.model.MData
import com.hamuli.recyclerviewmvvm.viewholder.HomeViewHolder
import com.hamuli.recyclerviewmvvm.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setUpRecyclerView(binding)

        return binding.root
    }

    private fun setUpRecyclerView(binding: FragmentHomeBinding) {

        val madapter = HomeAdapter()
        val mlayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        binding.recyclerViewHome.apply {
            hasFixedSize()
            addItemDecoration(decoration)
            layoutManager = mlayoutManager
            adapter = madapter
        }

        viewModel.list.observe(viewLifecycleOwner) {
            madapter.submitList(it)
        }
    }
}

class HomeAdapter : ListAdapter<MData, HomeViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val main = getItem(position)

        holder.bind(main)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<MData>() {

        override fun areItemsTheSame(oldItem: MData, newItem: MData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MData, newItem: MData): Boolean {
            return oldItem.name == newItem.name
        }

    }
}