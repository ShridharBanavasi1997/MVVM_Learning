package com.example.mvvm_jetpack_database.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_jetpack_database.data.model.People

@Dao
interface PeopleDao {

    // 1: Select All
    @Query("SELECT * FROM Contact ORDER BY id DESC")
    fun getAll(): LiveData<List<People>>

    // 2: Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(people: People)

    // 2.1: Insert All
    @Insert(onConflict = OnConflictStrategy.REPLACE) //conflict the data
    suspend fun insertAll(people: List<People>)

    // 3: Delete
    @Query("DELETE FROM Contact")
    suspend fun deleteAll()

    // 4: Select by id
    @Query("SELECT * FROM Contact WHERE id = :id")
    fun find(id: Int): LiveData<People>

    @Query("SELECT * FROM Contact WHERE name LIKE '%' || :name || '%'")
    fun findBy(name: String): LiveData<List<People>>

}