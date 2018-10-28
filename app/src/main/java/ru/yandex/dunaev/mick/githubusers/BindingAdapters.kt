package ru.yandex.dunaev.mick.githubusers

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

@BindingAdapter("adapter")
fun RecyclerView.recyclerAdapter(adp: ModelAdapter){
    adapter = adp
}

@BindingAdapter("manager")
fun RecyclerView.recyclerManager(manager: RecyclerView.LayoutManager){
    layoutManager = manager
}

@BindingAdapter("src")
fun ImageView.loadImage(url: String){
    Picasso.get().load(url).into(this)
}