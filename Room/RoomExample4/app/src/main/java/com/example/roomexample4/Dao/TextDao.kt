package com.example.roomexample4.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomexample4.Entitiy.TextEntity


@Dao
interface TextDao {

    @Query("SELECT * FROM text_table")
    fun getAllData() : List<TextEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: TextEntity)

    @Query("DELETE FROM text_table")
    fun deleteAllData()
}