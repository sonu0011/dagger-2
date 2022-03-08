package com.sonu.dagger2example.example.viewmodels

import androidx.lifecycle.ViewModel
import com.sonu.dagger2example.example.repository.ProductRepository
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

}