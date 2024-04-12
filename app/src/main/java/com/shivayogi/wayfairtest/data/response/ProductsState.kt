package com.shivayogi.wayfairtest.data.response

import com.findmore.pokedex.data.remote.responses.ProductsList


data class ProductsState(
    val productsList: ProductsList? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
