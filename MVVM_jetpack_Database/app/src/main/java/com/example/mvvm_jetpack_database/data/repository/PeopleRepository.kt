package com.example.mvvm_jetpack_database.data.repository


import androidx.lifecycle.LiveData
import com.example.mvvm_jetpack_database.data.db.PeopleDao
import com.example.mvvm_jetpack_database.data.model.People

class PeopleRepository(private val peopleDao: PeopleDao) {

    val getAllPeople: LiveData<List<People>> = peopleDao.getAll()

    fun getAllPeople(): LiveData<List<People>> {
        return peopleDao.getAll()
    }

    suspend fun insertPeople(people: People) {
        peopleDao.insert(people)
    }

    suspend fun insertPeopleList(people: List<People>) {
        peopleDao.insertAll(people)
    }

//    fun findPeople(id: Int):LiveData<People> {
//        //return peopleDao.find(id)
//    }


    fun findPeople(name: String): LiveData<List<People>>{
        return peopleDao.findBy(name)
    }

//    suspend fun deleteAllRecord() {
//        peopleDao.deleteAll()
//    }

}