package com.exampleone.testingapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserModel::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract val userDAO: UserDao

    companion object {
        @Volatile
        private var INSTANCE: com.exampleone.testingapp.data.DataBase? = null
        fun getInstance(context: Context): com.exampleone.testingapp.data.DataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        com.exampleone.testingapp.data.DataBase::class.java,
                        "database"
                    ).build()
                }
                return instance
            }
        }
    }
}