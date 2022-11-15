package com.exampleone.testingapp.di

import android.app.Application
import com.github.javafaker.App

class UserApp : Application() {

    companion object {
        fun getApp() = Application()
    }

}