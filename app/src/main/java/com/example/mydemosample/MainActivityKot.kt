package com.example.mydemosample

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivityKot : AppCompatActivity() {
    lateinit var adapter: HeroesAdapterKot
    val myViewModel: HeroesViewModelKot by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.setLayoutManager(LinearLayoutManager(this))

//        myViewModel = ViewModelProviders.of(this).get(HeroesViewModelKot::class.java)

        requestButton.setOnClickListener {
            it.visibility = View.GONE
            myViewModel.fetchData()
        }

        setupObservers()
    }

    private fun setupObservers() {

        myViewModel.heroes.observe(this, Observer {
            it?.let {
                adapter = HeroesAdapterKot(this@MainActivityKot, myViewModel, it)
                recyclerview.setAdapter(adapter)
            }
        })

        myViewModel.myPosition.observe(this, Observer {
         Toast.makeText(this,"Name ::"+it,Toast.LENGTH_SHORT).show()
        })
    }
}