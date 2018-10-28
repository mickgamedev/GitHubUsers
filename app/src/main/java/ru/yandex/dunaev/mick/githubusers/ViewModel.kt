package ru.yandex.dunaev.mick.githubusers

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

const val TAG = "MainViewModel"
const val LOCATION = "Simferopol"
const val LANGUAGE = "Android"

class MainViewModel() : ViewModel() {
    private val repository = RepositotyProvider.provideSearchRepository()
    val recyclerAdapter = ModelAdapter()
    val information = "$LOCATION $LANGUAGE"

    init {
        val disp = repository
            .searchUsers(LOCATION, LANGUAGE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ v -> recyclerAdapter.setUsers(v.items)})
    }
}