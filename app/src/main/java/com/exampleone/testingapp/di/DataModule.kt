package com.exampleone.testingapp.di

import com.exampleone.testingapp.data.RepositoryImpl
import com.exampleone.testingapp.domain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindRepositoryImpl(repositoryImpl: RepositoryImpl): UserRepository
}