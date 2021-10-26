package com.example.mvvm_jetpack_database.ui.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mvvm_jetpack_database.R

@Composable
fun addButton(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    FloatingActionButton(
        backgroundColor = MaterialTheme.colors.primary,
        onClick = {
            print("Floating Action Button Clicked.")
            navController.navigate(R.id.addFragment)
        }
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Localized description")
    }
}