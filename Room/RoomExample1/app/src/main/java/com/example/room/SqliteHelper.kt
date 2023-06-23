package com.example.room

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class SqliteHelper(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {

    companion object{

        //연결
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "myTestDB.db"
        private const val TBL_NAME = "my_Table"

        //ID ,TITLE 정의
        private const val ID = "id"
        private const val TITLE = "title"
    }

    fun insert(str : String){

        val db = this.writableDatabase

        val values = ContentValues().apply{
            put(TITLE,str)
        }

        db.insert(TBL_NAME,null,values)
    }

    fun getAllData() : ArrayList<String> {

        val db = this.readableDatabase

        val query = "SELECT * FROM $TBL_NAME"
        val cursor = db.rawQuery(query,null)

        val arr = ArrayList<String>()

        //title 데이터를 가져온다
        with(cursor) {
            while (moveToNext()){
                arr.add((getString(1)))
            }
        }

        return arr
    }

    fun deleteAll(){

        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TBL_NAME")
    }

    //id는 DB에 값을 불러올때 Integer 타입 getInt()를 Title값은 getString()으로 불러온다
    override fun onCreate(db: SQLiteDatabase?) {
        val SQL_CREATE_ENTRIES =
            "CREATE TABLE $TBL_NAME (" +
                    "$ID INTEGER PRIMARY KEY," +
                    "$TITLE TEXT)"

        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TBL_NAME")
        onCreate(db)
    }
}