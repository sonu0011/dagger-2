package com.sonu.dagger2example.example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sonu.dagger2example.example.models.FakeApiResponseItem
import com.sonu.dagger2example.example.retrofit.FakeApi
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val fakeApi: FakeApi
) {
    private val _products = MutableLiveData<List<FakeApiResponseItem>>()
    val products: LiveData<List<FakeApiResponseItem>>
        get() = _products

    suspend fun getProducts() {
        val result = fakeApi.getProducts()
        if (result.isSuccessful && result.body() != null) {
            _products.postValue(result.body())
        }
    }
}