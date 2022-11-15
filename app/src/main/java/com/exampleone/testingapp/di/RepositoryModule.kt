package com.exampleone.testingapp.di

import com.exampleone.testingapp.data.RepositoryImpl
import com.exampleone.testingapp.domain.user.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindRepositoryImpl(repositoryImpl: RepositoryImpl): UserRepository
}