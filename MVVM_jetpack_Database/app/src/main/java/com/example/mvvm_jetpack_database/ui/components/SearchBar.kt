package com.example.mvvm_jetpack_database.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
fun SearchBar(
    query: String,
    onValueChange: (String) -> Unit,
    onExecuteSearch: () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current


    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.secondary,
        elevation = 10.dp,

        ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(9.dp)
                    .background(color = MaterialTheme.colors.surface),

                value = query,
                onValueChange = { onValueChange(it)},
                label = {
                    Text(text = "Search")
                },
                leadingIcon = {
                    Icon(Icons.Filled.Search, contentDescription = "Localized description")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onExecuteSearch()
                        keyboardController?.hide()
                    }
                )



            )

        }

    }
}
