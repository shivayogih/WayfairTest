package com.findmore.pokedex.data.remote.responses


import com.shivayogi.wayfairtest.data.models.Product

data class ProductsList(
    val results: List<Product>?= listOf()
)