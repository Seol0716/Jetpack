package com.example.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

//앱의 생명주기 확인
//ViewModel이 나온이유
//상태가 변환할때 데이터가 유지하게 도와준다

class MainActivity : AppCompatActivity() {
    private var countValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        val plusBtn : Button = findViewById(R.id.plus)
        val minusBtn : Button = findViewById(R.id.minus)

        val resultArea : TextView = findViewById(R.id.result)

        plusBtn.setOnClickListener{
            countValue++
            resultArea.text= countValue.toString()
        }

        minusBtn.setOnClickListener{
            countValue--
            resultArea.text= countValue.toString()
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