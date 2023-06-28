package com.example.navigation1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//Navigation 개념
//Navigation을 사용하여 프래그먼트 데이터 전달

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //기존의 fragment 사용하던 방법
        val btn1 : Button = findViewById(R.id.btn1)

        val manager = supportFragmentManager
        btn1.setOnClickListener {
            val transaction = manager.beginTransaction()
            val fragment1 = BlankFragment1()
            transaction.replace(R.id.frame,fragment1)
            transaction.commit()
        }

        val btn2 : Button = findViewById(R.id.btn2)
        btn2.setOnClickListener {
            val transaction = manager.beginTransaction()
            val fragment2 = BlankFragment2()
            transaction.replace(R.id.frame,fragment2)
            transaction.commit()
        }
    }
}