package com.exampleone.testingapp.di

import android.content.Context
import com.exampleone.testingapp.data.DataBase
import com.exampleone.testingapp.data.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
      fun provideUserDao(@ApplicationContext application: Context): UserDao {
        return DataBase.getInstance(application).userDAO
    }
}