package com.example.room_example2


import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Text::class], version = 1)
abstract class TextDataBase : RoomDatabase() {

    //추상 메서드를 사용하여 DAO 인스턴스를 가져온다
    //DAO 인스턴스의 메서드를 사용하여 데이터베이스와 상호작용

    abstract fun textDao(): TextDao

    companion object {
        @Volatile
        private var DB: TextDataBase? = null

        fun getDatabase(
            context: Context
        ): TextDataBase {

            //데이터 베이스 인스턴스
            return DB ?: synchronized(this) {

                //추상 메서드를 사용하여 DAO의 인스턴스를 가져올 수 있다.
                //연결한 후 DAO의 인스턴스를 사용하여 데이터베이스와 상호작용
                val db = Room.databaseBuilder(
                    context.applicationContext,
                    TextDataBase::class.java,
                    "text_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                DB = db
                db
            }
        }
    }
}