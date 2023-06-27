package com.example.coroutineworker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

//Coroutine worker와 Workmanger 같이 사용해보기

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workmanger = OneTimeWorkRequestBuilder<Workmanger2>().build()
        WorkManager.getInstance(this).enqueue(workmanger)
    }
}