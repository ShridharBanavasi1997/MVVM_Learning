package com.example.mvvm_jetpack_retrofit.data.network

import com.example.mvvm_jetpack_retrofit.data.model.MovieResponse
import retrofit2.http.GET

interface MovieFetchApi {
    @GET("trending/all/day?api_key=57ec817a04be27f196d3da087d6b1a28")
    suspend fun fetchTrendingMovieList() : MovieResponse
}