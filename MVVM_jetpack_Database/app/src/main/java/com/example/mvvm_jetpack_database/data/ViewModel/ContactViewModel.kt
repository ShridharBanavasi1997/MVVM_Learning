package com.example.mvvm_jetpack_database.data.ViewModel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.mvvm_jetpack_database.data.db.PeopleDatabase
import com.example.mvvm_jetpack_database.data.model.People
import com.example.mvvm_jetpack_database.data.repository.PeopleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG: String? = "ContactViewModel"

    val query = mutableStateOf("")

    val people: MutableState<People> = mutableStateOf(People())

    val peopleList = MediatorLiveData<List<People>>()
    private val peopleRepository: PeopleRepository


    init {
        val peopleDao = PeopleDatabase.getInstance(application).peopleDao()
        peopleRepository = PeopleRepository(peopleDao = peopleDao)
        peopleList.addSource(peopleRepository.getAllPeople()) { peoples ->
            peopleList.postValue(peoples)
        }

    }

    fun searchPeople() {
        peopleList.addSource(peopleRepository.findPeople(query.value)) { peoples ->
            peopleList.postValue(peoples)
        }

    }

    fun addPeople(peopleInput:People) {
        viewModelScope.launch(Dispatchers.IO) {
            peopleRepository.insertPeople(people = peopleInput)
        }
    }

    fun addPeopleList(people: List<People>) {
        viewModelScope.launch(Dispatchers.IO) {
            peopleRepository.insertPeopleList(people = people)
        }
    }


    fun onQueryChange(query: String) {
        this.query.value = query
    }

    fun onExecuteSearch() {
        Log.d(TAG, "test $query")
        searchPeople()
    }
}

class ContactViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            return ContactViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}