package com.example.mydemosample

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplicayion : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoinInstance()
    }

    private fun startKoinInstance() {

        startKoin {
            androidContext(this@MyApplicayion)
            modules(appModule)

        }
    }

}