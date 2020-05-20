package com.example.mydemosample

import android.content.Context
import android.media.AudioManager
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { RequestServer () }

    viewModel { HeroesViewModelKot(get()) }
}