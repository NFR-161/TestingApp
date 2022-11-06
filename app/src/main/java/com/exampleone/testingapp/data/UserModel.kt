package com.exampleone.testingapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_data_table")
data class UserModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var id: Int,

    @ColumnInfo(name = "user_enabled")
    var enabled: Boolean,

    @ColumnInfo(name = "user_name")
    var name: String,

    @ColumnInfo(name = "user_image")
    var picUrl: String
)





