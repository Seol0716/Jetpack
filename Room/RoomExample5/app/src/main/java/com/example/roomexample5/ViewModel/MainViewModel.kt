package com.example.roomexample5.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomexample5.DB.TestDB
import com.example.roomexample5.DataEntity.TextEntity
import com.example.roomexample5.DataEntity.WordEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val db = TestDB.getDatabase(context)

    private var _textList = MutableLiveData<List<TextEntity>>()
    val textList : LiveData<List<TextEntity>>
        get() = _textList

    private var _wordList = MutableLiveData<List<WordEntity>>()
    val wordList : LiveData<List<WordEntity>>
        get() = _wordList

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        Log.d("MainViewModel", db.textDao().getAllData().toString())
        Log.d("MainViewModel", db.wordDao().getAllData().toString())
        _textList.postValue(db.textDao().getAllData())
        _wordList.postValue(db.wordDao().getAllData())
    }

    fun insertData(text : String) = viewModelScope.launch(Dispatchers.IO) {
        db.textDao().insert(TextEntity(0, text))
        db.wordDao().insert(WordEntity(0, text))
    }


    fun delete() = viewModelScope.launch(Dispatchers.IO) {
        db.textDao().deleteAllData()
        db.wordDao().deleteAllData()
    }
}