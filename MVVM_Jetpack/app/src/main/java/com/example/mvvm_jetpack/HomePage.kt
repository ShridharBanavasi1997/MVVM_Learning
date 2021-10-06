package com.example.mvvm_jetpack

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Preview(showSystemUi = true)
@Composable
fun HomePage(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Home Page")
    }
    
}