package com.example.mvvm_jetpack_database.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mvvm_jetpack_database.data.model.People


@Composable
fun submitButton(
    people: People,
    modifier: Modifier = Modifier,
    onClick: (People) -> Unit,
    validator: Boolean,
    navController: NavController
) {
    Button(
        onClick = {
            if (validator) {
                onClick(people)
                Log.d("Tag", "done")
                navController.navigateUp()
            } else {
                Log.d("Tag", "missing")
            }
        },
        modifier = modifier
            .fillMaxWidth(0.5f)
            .background(color = MaterialTheme.colors.secondary)
    ) {
        Text(
            text ="Add",
            color = MaterialTheme.colors.onSecondary
        )
    }

}