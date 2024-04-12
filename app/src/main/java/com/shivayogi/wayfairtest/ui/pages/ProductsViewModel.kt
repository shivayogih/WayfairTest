package com.shivayogi.wayfairtest.ui.pages


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shivayogi.wayfairtest.data.response.ProductsState
import com.shivayogi.wayfairtest.repository.ProductsRepository
import com.shivayogi.wayfairtest.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repository: ProductsRepository
) : ViewModel() {

    var state by mutableStateOf(ProductsState())

    fun loadProducts() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true, error = null
            )
            state = when (val result =
                repository.getProductsList()) {
                is Resource.Success -> {
                    state.copy(
                        productsList = result.data, isLoading = false, error = null
                    )
                }

                is Resource.Error -> {
                    state.copy(
                        productsList = null, isLoading = false, error = result.message
                    )
                }

                else -> {
                    state.copy(
                        productsList = null, isLoading = false, error = result.message
                    )
                }
            }
        }

    }
}