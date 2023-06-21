package com.example.viewmodelactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        Log.d("MainActivity", "onCreate")

        val plusBtn : Button = findViewById(R.id.plus)
        val minusBtn : Button = findViewById(R.id.minus)

        val resultArea : TextView = findViewById(R.id.result)

        resultArea.text= viewModel.countValue.toString()

        plusBtn.setOnClickListener{
            viewModel.plus()
            resultArea.text= viewModel.countValue.toString()
//            countValue++
//            resultArea.text = countValue.toString()
        }

        minusBtn.setOnClickListener{
            viewModel.minus()
            resultArea.text= viewModel.countValue.toString()
//            countValue--
//            resultArea.text = countValue.toString()
        }


    }

    override fun onStart() {
        super.onStart()

        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("MainActivity", "onDestroy")
    }
}