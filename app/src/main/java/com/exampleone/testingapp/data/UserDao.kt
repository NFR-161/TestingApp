package com.exampleone.testingapp.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UserDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userModel: UserModel)

    @Insert
    suspend fun insertUserList(userModel: List<UserModel>)

    @Update
    suspend fun updateUser(userModel: UserModel)

    @Query("SELECT * FROM user_data_table")
    fun getAllUsers(): LiveData<List<UserModel>>

}