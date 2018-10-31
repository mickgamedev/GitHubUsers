package ru.yandex.dunaev.mick.githubusers

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

const val TAG = "MainViewModel"
const val LOCATION = "Simferopol"
const val LANGUAGE = "Android"

class MainViewModel : ViewModel() {
    val recyclerAdapter = ModelAdapter()
    val information = "$LOCATION $LANGUAGE"
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        uiScope.launch{
            withContext(Dispatchers.IO){
                delay(1000L)
                Log.v(TAG,"Hello form io")
            }
            Log.v(TAG,"Hello world")
        }
        Log.v(TAG,"Yahoo")
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}