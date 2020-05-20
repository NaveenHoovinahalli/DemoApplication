package com.example.mydemosample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroesViewModelKotbkp1 : ViewModel() {
    //this is the data that we will fetch asynchronously
    private var heroList: MutableLiveData<List<Hero>>? = null
    var requestServer = RequestServer ()


    //we will call this method to get the data
    val heroes: LiveData<List<Hero>>
        get() { //if the list is null
            if (heroList == null) {
                heroList = MutableLiveData()
//                loadHeroes()
                requestServer.loadHeroes {
                    heroList!!.value = it
                }


            }
            //finally we will return the list
            return heroList!!
        }

    //This method is using Retrofit to get the JSON data from URL
    private fun loadHeroes() {
        val retrofit = RetrofitClientInstance.getRetrofitInstance()
        val api = retrofit.create(ApiKot::class.java)
        val call = api.getHeros()
        call.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(
                call: Call<List<Hero>>,
                response: Response<List<Hero>>
            ) { //finally we are setting the list to our MutableLiveData
                heroList!!.value = response.body()
            }

            override fun onFailure(
                call: Call<List<Hero>>,
                t: Throwable
            ) {
            }
        })
    }
}