package com.example.room_example2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val arr : ArrayList<Text> = ArrayList()

        val db = TextDataBase.getDatabase(this)
        val inputEdit = findViewById<EditText>(R.id.textInput)
        val insert = findViewById<Button>(R.id.insert)
        val allData = findViewById<Button>(R.id.getData)
        val delete = findViewById<Button>(R.id.delete)
        val all = findViewById<TextView>(R.id.allText)

        insert.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().insert(Text(0, inputEdit.text.toString()))

                inputEdit.setText(" ")
            }
        }

        allData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {

                 Log.d("test",db.textDao().getAllData().toString())
            }
        }

        delete.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("delete",db.textDao().deleteAllData().toString())
            }
        }
    }
}
