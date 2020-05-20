package com.example.mydemosample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_layout.view.*

class HeroesAdapterKot(
    var mCtx: Context,
    var myViewModel: HeroesViewModelKot,
    var heroList: List<Hero>
) : RecyclerView.Adapter<HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        holder.imageView.loadImage(hero.imageurl)
        holder.textView.text = hero.name
        holder.bind(heroList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    private val clickListener = { hero: Hero ->
        {
            myViewModel.setItemClick(hero)
        }
    }
}
class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView = itemView.imageViewlistitem
    var textView = itemView.textViewlistitem

    fun bind(hero: Hero, clickListener: (Hero) -> () -> Unit) {
        itemView.setOnClickListener {
            clickListener(hero).invoke()
        }
    }
}