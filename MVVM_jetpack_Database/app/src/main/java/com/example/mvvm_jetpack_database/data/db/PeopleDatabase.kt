package com.example.mvvm_jetpack_database.data.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_jetpack_database.data.model.People

@Database(entities = [People::class], version = 2, exportSchema = false)
abstract class PeopleDatabase : RoomDatabase() {

    abstract fun peopleDao(): PeopleDao

    // 2
    companion object {
        private val lock = Any()
        private const val DB_NAME = "People.db"
        private var INSTANCE: PeopleDatabase? = null

        // 3
        fun getInstance(context: Context): PeopleDatabase {
            val instance = INSTANCE
            if (instance != null) {
                return instance
            }
            synchronized(this) {

                    val instance  = Room.databaseBuilder(
                        context.applicationContext,
                        PeopleDatabase::class.java,
                        DB_NAME
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                    return instance

            }
        }

    }

}