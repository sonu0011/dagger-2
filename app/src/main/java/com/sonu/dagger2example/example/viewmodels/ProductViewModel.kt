package com.sonu.dagger2example.example.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonu.dagger2example.example.models.FakeApiResponseItem
import com.sonu.dagger2example.example.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: ProductRepository
) : ViewModel() {
    val productsLiveData: LiveData<List<FakeApiResponseItem>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}