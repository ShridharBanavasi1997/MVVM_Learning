package com.example.mvvm_jetpack_database.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppBar(
    header:String
){
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.secondary,
        elevation = 10.dp,

        ) {
        Text(
            text = header,
            modifier = Modifier.padding(
                start = 10.dp, top = 10.dp, bottom = 10.dp
            ),
            style = TextStyle(
                color = MaterialTheme.colors.onSecondary,
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp
            )

        )

    }
}