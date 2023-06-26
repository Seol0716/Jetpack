package com.example.roomexample5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomexample5.Adapter.CustomAdapter
import com.example.roomexample5.DB.TestDB
import com.example.roomexample5.ViewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getData()

        val inputArea = findViewById<EditText>(R.id.textInputArea)
        val insertBtn = findViewById<Button>(R.id.insert)
        val getAllBtn = findViewById<Button>(R.id.getData)
        val deleteBtn = findViewById<Button>(R.id.delete)

        insertBtn.setOnClickListener {
            viewModel.insertData(inputArea.text.toString())
            inputArea.setText("")
        }

        val rv = findViewById<RecyclerView>(R.id.rv)

        viewModel.textList.observe(this, Observer {
            val customAdapter = CustomAdapter(it)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)
        })


        getAllBtn.setOnClickListener {
            viewModel.getData()
        }

        deleteBtn.setOnClickListener {
            viewModel.delete()
        }
    }
}