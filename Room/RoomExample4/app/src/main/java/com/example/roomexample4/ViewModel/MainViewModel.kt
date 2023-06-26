package com.example.roomexample4.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomexample4.DB.DB
import com.example.roomexample4.Entitiy.TextEntity
import com.example.roomexample4.Entitiy.WordEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    //context값 가져오기
    val context = getApplication<Application>().applicationContext
    val db = DB.getDatabase(context)

    //Dispatchers IO를 사용하는 이유 기본적으로 viewModel scope는 Dispatchers.Main를 사용
    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        Log.d("test",db.textDao().getAllData().toString())
        Log.d("test",db.wordDao().getAllData().toString())
        db.textDao().getAllData()
        db.wordDao().getAllData()
    }

    fun insertData(text : String) = viewModelScope.launch(Dispatchers.IO){
        db.textDao().insert(TextEntity(0,text))
        db.wordDao().insert(WordEntity(0,text))

    }

    fun delete() = viewModelScope.launch(Dispatchers.IO) {
        db.textDao().deleteAllData()
        db.wordDao().deleteAllData()
    }
}