package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//로컬 데이터베이스
//Room의 장점 반복적인 코드제거 효율증가

//SQLite

class MainActivity : AppCompatActivity() {

    lateinit var db : SqliteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = SqliteHelper(this)

        val insert = findViewById< Button>(R.id.insert)
        val edit = findViewById<EditText>(R.id.edit)
        val getAll = findViewById<Button>(R.id.getAll)
        val delete = findViewById<Button>(R.id.delete)
        val result = findViewById<TextView>(R.id.result)

        insert.setOnClickListener{
            val input_Text = edit.text.toString();
            db.insert(input_Text)
            edit.setText(" ")
        }

        getAll.setOnClickListener {
            val arr = db.getAllData()
            result.text = arr.toString()
        }

        delete.setOnClickListener{
            db.deleteAll()
        }
    }
}