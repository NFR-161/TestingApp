package com.exampleone.testingapp.di

import android.app.Application
import androidx.room.Database
import com.exampleone.testingapp.data.DataBase
import com.exampleone.testingapp.data.DataBase.Companion.getInstance
import com.exampleone.testingapp.data.RepositoryImpl
import com.exampleone.testingapp.data.UserDao
import com.exampleone.testingapp.domain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindUserRepository(impl: RepositoryImpl): UserRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideUserDao(application: Application): UserDao {
            return getInstance(application).userDAO
        }
    }
}