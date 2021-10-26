package com.example.mvvm_jetpack_database.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mvvm_jetpack_database.data.model.People

@Composable
fun contactList(peopleList: List<People>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(peopleList.size) { index ->
            ContactItem(people = peopleList[index])

        }
    }
}