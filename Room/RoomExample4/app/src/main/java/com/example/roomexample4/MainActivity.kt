package com.example.roomexample4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.roomexample4.DB.DB
import com.example.roomexample4.Entitiy.TextEntity
import com.example.roomexample4.Entitiy.WordEntity
import com.example.roomexample4.ViewModel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getData()

        val db = DB.getDatabase(this)

        val inputArea = findViewById<EditText>(R.id.textInputArea)
        val insertBtn = findViewById<Button>(R.id.insert)
        val getAllBtn = findViewById<Button>(R.id.getData)
        val deleteBtn = findViewById<Button>(R.id.delete)

        insertBtn.setOnClickListener {

            viewModel.insertData(inputArea.text.toString())
            inputArea.setText("")

        }

        getAllBtn.setOnClickListener {
            viewModel.getData()

        }

        deleteBtn.setOnClickListener {
          viewModel.delete()
        }
    }
}