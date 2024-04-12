package com.shivayogi.wayfairtest.data.remote


import com.findmore.pokedex.data.remote.responses.ProductsList
import retrofit2.http.GET


interface WayfairApi {

    @GET("interview-sandbox/android/json-to-list/products.vl.json")
    suspend fun getProductsList(): ProductsList

}