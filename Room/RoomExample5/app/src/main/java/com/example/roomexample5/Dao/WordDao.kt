package com.example.roomexample5.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomexample5.DataEntity.WordEntity


@Dao
interface WordDao {

    @Query("SELECT * FROM word_table")
    fun getAllData() : List<WordEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text : WordEntity)

    @Query("DELETE FROM word_table")
    fun deleteAllData()
}