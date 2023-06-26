package com.example.roomexample5.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomexample5.Dao.TextDao
import com.example.roomexample5.Dao.WordDao
import com.example.roomexample5.DataEntity.TextEntity
import com.example.roomexample5.DataEntity.WordEntity


@Database(entities = [TextEntity::class, WordEntity::class], version = 2)
abstract class TestDB : RoomDatabase() {

    abstract fun wordDao() : WordDao
    abstract fun textDao() : TextDao

    companion object {
        @Volatile
        private var INSTANCE : TestDB? = null

        fun getDatabase(
            context : Context
        ) : TestDB {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TestDB::class.java,
                    "text_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }

}