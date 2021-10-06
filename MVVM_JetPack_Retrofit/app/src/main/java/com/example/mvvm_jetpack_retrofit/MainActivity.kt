package com.example.mvvm_jetpack_retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm_jetpack_retrofit.ui.app.details.MovieDetails
import com.example.mvvm_jetpack_retrofit.ui.app.list.MainList
import com.example.mvvm_jetpack_retrofit.ui.theme.MVVM_JetPack_RetrofitTheme
import com.example.mvvm_jetpack_retrofit.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MVVM_JetPack_RetrofitTheme {
                NavHost(navController = navController, startDestination = "trendingMovieList") {
                    composable("trendingMovieList") {
                        Surface(color = MaterialTheme.colors.background) {
                            MainList(navController = navController, mainViewModel = mainViewModel)
                        }
                    }
                    composable("movieDetails") {
                        MovieDetails(mainViewModel.clickedItem)
                    }
                }

            }
        }
    }
}
