package com.example.mvvm_jetpack_database.ui.contact_add

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.findNavController
import com.example.mvvm_jetpack_database.R
import com.example.mvvm_jetpack_database.data.ViewModel.ContactViewModel
import com.example.mvvm_jetpack_database.data.ViewModel.ContactViewModelFactory
import com.example.mvvm_jetpack_database.data.model.People
import com.example.mvvm_jetpack_database.ui.components.AppBar
import com.example.mvvm_jetpack_database.ui.components.submitButton
import com.example.mvvm_jetpack_database.ui.components.textInput
import com.example.mvvm_jetpack_database.ui.theme.MVVM_jetpack_DatabaseTheme


class ContactAddFragment : Fragment() {

    @ExperimentalComposeUiApi
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

                val name: MutableState<String> = mutableStateOf("")
                val metAt: MutableState<String> = mutableStateOf("")
                val contact: MutableState<String> = mutableStateOf("")
                val email: MutableState<String> = mutableStateOf("")

                MVVM_jetpack_DatabaseTheme(darkTheme = false) {
                    Column(
                        modifier = Modifier.background(MaterialTheme.colors.background)

                    ) {
                        AppBar(header = "Add Contact")
                        Image(
                            painter = painterResource(id = R.drawable.persion),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)

                        )

                        val focusRequester = remember { FocusRequester() }

                        textInput(
                            inputName = "Name",
                            value = name.value,
                            onValueChange = { name.value = it },
                            focusRequester = focusRequester,
                            imeAction = ImeAction.Next
                        ) {
                            Icon(Icons.Filled.Person, contentDescription = null)
                        }
                        textInput(
                            inputName = "Met At",
                            value = metAt.value,
                            onValueChange = { metAt.value = it },
                            focusRequester = focusRequester,
                            imeAction = ImeAction.Next
                        ) {
                            Icon(Icons.Filled.Place, contentDescription = null)
                        }
                        textInput(
                            inputName = "Contact",
                            value = contact.value,
                            onValueChange = { contact.value = it },
                            keyboardType = KeyboardType.Phone,
                            focusRequester = focusRequester,
                            imeAction = ImeAction.Next
                        ) {
                            Icon(Icons.Filled.Phone, contentDescription = null)
                        }
                        textInput(
                            inputName = "Email",
                            value = email.value,
                            onValueChange = { email.value = it },
                            keyboardType = KeyboardType.Email,
                            focusRequester = focusRequester,
                            imeAction = ImeAction.Done
                        ) {
                            Icon(Icons.Filled.Email, contentDescription = null)
                        }
                        submitButton(
                            people = People(
                                name = name.value,
                                metAt = metAt.value,
                                contact = contact.value,
                                email = email.value
                            ),
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            onClick = {
                                peopleViewModel.addPeople(it)
                            },
                            validator = name.value.isNotEmpty() && metAt.value.isNotEmpty() && contact.value.isNotEmpty() && email.value.isNotEmpty(),
                            navController = findNavController()
                        )

                    }
                }


            }
        }
    }
}

