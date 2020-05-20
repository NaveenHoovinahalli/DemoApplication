package com.example.mydemosample

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestServer {

     fun loadHeroes(onSuccess: (List<Hero>?) -> Unit) {
        val retrofit = RetrofitClientInstance.getRetrofitInstance()
        val api = retrofit.create(ApiKot::class.java)
        val call = api.getHeros()
        call.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) { //finally we are setting the list to our MutableLiveData
                onSuccess(response.body())
            }

            override fun onFailure(
                call: Call<List<Hero>>,
                t: Throwable
            ) {
            }
        })
    }
}