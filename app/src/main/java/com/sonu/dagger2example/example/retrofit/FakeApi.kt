package com.sonu.dagger2example.example.retrofit

import com.sonu.dagger2example.example.models.FakeApiResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface FakeApi {
    @GET("products")
    suspend fun getProducts(): Response<List<FakeApiResponseItem>>
}