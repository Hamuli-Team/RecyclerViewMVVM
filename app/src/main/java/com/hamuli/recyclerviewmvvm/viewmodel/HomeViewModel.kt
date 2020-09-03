package com.hamuli.recyclerviewmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hamuli.recyclerviewmvvm.model.MData

class HomeViewModel : ViewModel() {

    private val _list = MutableLiveData<List<MData>>()

    val list: LiveData<List<MData>> get() = _list

    init {
        loadData()
    }

    private fun loadData() {

        val mlist: MutableList<MData> = arrayListOf()
        mlist.add(MData("Simple RecyclerView with List Adapter and DiffUtil"))
        mlist.add(MData("Implement Click Listener"))

        _list.value = mlist
    }

}