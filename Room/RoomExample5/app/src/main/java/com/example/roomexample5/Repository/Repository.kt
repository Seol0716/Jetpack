package com.example.roomexample5.Repository

import android.content.Context
import com.example.roomexample5.DB.TestDB
import com.example.roomexample5.DataEntity.TextEntity


class Repository(context: Context) {
    val db = TestDB.getDatabase(context)

    fun getTextList() = db.textDao().getAllData()

    fun getWordList() = db.wordDao().getAllData()

    fun insert(text: String) = db.textDao().insert(TextEntity(0,text))

    fun delete() = db.textDao().deleteAllData()



}