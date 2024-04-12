package com.shivayogi.wayfairtest.repository



import com.findmore.pokedex.data.remote.responses.ProductsList
import com.shivayogi.wayfairtest.data.remote.WayfairApi
import com.shivayogi.wayfairtest.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ProductsRepository @Inject constructor(
    private val api: WayfairApi
) {

    suspend fun getProductsList(): Resource<ProductsList> {
        val response = try {
            api.getProductsList()
        } catch(e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }



}