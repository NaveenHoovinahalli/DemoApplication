package com.example.mydemosample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroesViewModelKot(val requestServer: RequestServer) : ViewModel() {
    private var heroList = MutableLiveData<List<Hero>> ()
     var myPosition = MutableLiveData<String> ()
    val heroes: LiveData<List<Hero>>
        get() = this.heroList

    fun fetchData() {
        requestServer.loadHeroes {
            heroList.value = it
        }
    }

    fun setItemClick(hero: Hero) {
        Log.d("NaveenTesting", "MyPosition"+hero.name)
        myPosition.value = hero.name
    }
}