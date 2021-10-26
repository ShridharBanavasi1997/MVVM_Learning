package com.example.mvvm_jetpack_database.ui.contact_list

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.Fragment
import com.example.mvvm_jetpack_database.ui.components.SearchBar
import com.example.mvvm_jetpack_database.ui.theme.MVVM_jetpack_DatabaseTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.findNavController
import com.example.mvvm_jetpack_database.data.ViewModel.ContactViewModel
import com.example.mvvm_jetpack_database.data.ViewModel.ContactViewModelFactory
import com.example.mvvm_jetpack_database.data.test.PeopleInfoProvider
import com.example.mvvm_jetpack_database.ui.components.addButton
import com.example.mvvm_jetpack_database.ui.components.contactList

class ContactListFragment : Fragment() {


    @ExperimentalComposeUiApi
    @ExperimentalMaterialApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {

            setContent {
                val context = LocalContext.current
                val peopleViewModel: ContactViewModel = viewModel(
                    factory = ContactViewModelFactory(context.applicationContext as Application)
                )

                peopleViewModel.addPeopleList(PeopleInfoProvider.peopleList)

                val query: String = peopleViewModel.query.value

                val peopleList = peopleViewModel.peopleList.observeAsState(listOf()).value

                MVVM_jetpack_DatabaseTheme(darkTheme = false) {
                    Column(
                        modifier = Modifier.background(MaterialTheme.colors.background)

                    ) {
                        SearchBar(
                            query = query,
                            onValueChange = peopleViewModel::onQueryChange,
                            onExecuteSearch = peopleViewModel::onExecuteSearch
                        )

                        Scaffold(
                            floatingActionButton = { addButton(navController = findNavController()) }
                        ) {
                            contactList(
                                peopleList,
                            )
                        }
                    }
                }
            }

        }
    }
}


