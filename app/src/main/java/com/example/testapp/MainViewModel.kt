package com.example.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    fun fetchData() {
        _data.value = "title updated"
    }

    private val _data: MutableLiveData<String> = MutableLiveData()
    val data: LiveData<String> = _data
}