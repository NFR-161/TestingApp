package com.exampleone.testingapp.di

import android.app.Application
import com.github.javafaker.App

class UserApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

}