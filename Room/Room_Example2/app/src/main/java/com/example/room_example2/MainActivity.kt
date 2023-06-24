package com.example.room_example2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val db = TextDataBase.getDatabase(this)

        CoroutineScope(Dispatchers.IO).launch {
            db.textDao().insert(Text(0,"asdf"))

        }
    }
}