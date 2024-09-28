package com.example.nsda_job_1

import retrofit2.http.GET

interface apiService {
    @GET("products")
    suspend fun  getProducts(): List<Product>

}