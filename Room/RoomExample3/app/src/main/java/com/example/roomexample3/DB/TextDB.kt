package com.example.roomexample3.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomexample3.Dao.TextDao
import com.example.roomexample3.Dao.WordDao
import com.example.roomexample3.Data.TextEntity
import com.example.roomexample3.Data.WordEntity

@Database(entities = [TextEntity::class, WordEntity::class], version = 2)
abstract class TextDB : RoomDatabase() {

    abstract fun wordDao() : WordDao
    abstract fun textDao() : TextDao

    companion object {
        @Volatile
        private var INSTANCE : TextDB? = null

        fun getDatabase(
            context : Context
        ) : TextDB {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TextDB::class.java,
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