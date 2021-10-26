package com.example.mvvm_jetpack_database.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class People(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "metAt")
    var metAt: String = "",

    @ColumnInfo(name = "contact")
    var contact: String = "",

    @ColumnInfo(name = "email")
    var email: String = "",

)
