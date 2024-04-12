package com.shivayogi.wayfairtest.di



import com.shivayogi.wayfairtest.data.remote.WayfairApi
import com.shivayogi.wayfairtest.repository.ProductsRepository
import com.shivayogi.wayfairtest.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: WayfairApi
    ) = ProductsRepository(api)


    @Singleton
    @Provides
    fun providePokeApi(): WayfairApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create(WayfairApi::class.java)
    }
}