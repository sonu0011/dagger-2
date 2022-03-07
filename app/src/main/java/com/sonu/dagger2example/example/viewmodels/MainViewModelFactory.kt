package com.sonu.dagger2example.example.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sonu.dagger2example.example.repository.ProductRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository = productRepository) as T
    }
}