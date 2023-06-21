package com.example.viewmodelactivity

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel  : ViewModel() {

    var countValue = 0

    init {
        Log.d("MainViewModel", "init")
    }

    fun plus(){
        countValue++
        Log.d("MainViewModel", countValue.toString())
    }

    fun minus(){
        countValue--
        Log.d("MainViewModel", countValue.toString())
    }

    fun getCount() : Int {
        return countValue
    }

}