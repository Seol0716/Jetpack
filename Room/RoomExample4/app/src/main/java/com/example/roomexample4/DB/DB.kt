package com.example.roomexample4.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomexample4.Dao.TextDao
import com.example.roomexample4.Dao.WordDao
import com.example.roomexample4.Entitiy.TextEntity
import com.example.roomexample4.Entitiy.WordEntity


@Database(entities = [TextEntity::class, WordEntity::class], version = 2)
abstract class DB : RoomDatabase() {

    abstract fun wordDao() : WordDao
    abstract fun textDao() : TextDao

    companion object {
        @Volatile
        private var INSTANCE : DB? = null

        fun getDatabase(
            context : Context
        ) : DB {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DB::class.java,
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