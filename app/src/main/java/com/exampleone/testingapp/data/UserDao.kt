package com.exampleone.testingapp.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userModel: UserModel)

    @Insert
    suspend fun insertUserList(userModel: List<UserModel>)

    @Update
    suspend fun updateUser(userModel: UserModel)

    @Query("DELETE FROM user_data_table")
    suspend fun clear()

    @Query("SELECT * FROM user_data_table")
    fun getAllUsersForSubscribe(): LiveData<List<UserModel>>

    @Query("SELECT * FROM user_data_table WHERE user_name LIKE :searchQuery ")
    fun searchDataBase(searchQuery:String): LiveData<List<UserModel>>

}