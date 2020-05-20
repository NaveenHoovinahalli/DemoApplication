package com.example.mydemosample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityKotbkp1 : AppCompatActivity() {
    var adapter: HeroesAdapterKot? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.setLayoutManager(LinearLayoutManager(this))
        val model = ViewModelProviders.of(this).get(
            HeroesViewModelKot::class.java
        )
        model.heroes.observe(
            this,
            Observer{ it?.let {
                adapter = HeroesAdapterKot(this@MainActivityKotbkp1, model ,it)
                recyclerview.setAdapter(adapter) }
            })
    }
}