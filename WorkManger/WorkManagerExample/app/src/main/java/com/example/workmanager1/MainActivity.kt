package com.example.workmanager1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

//주기적 실행
//15분마다 / 30분마다 /1시간마다 실행되게

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //시간확인

        val workmanager = PeriodicWorkRequestBuilder<WorkManager1>(1,TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(workmanager)
    }
}