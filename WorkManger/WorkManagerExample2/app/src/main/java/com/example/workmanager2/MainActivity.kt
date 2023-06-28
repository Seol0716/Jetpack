package com.example.workmanager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

//고유작업
//WorkManager 충돌작업 방지

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.test_btn)
        btn.setOnClickListener {

            //인스턴스 생성
            //기존에 했던 방식
            val workManagerTest = OneTimeWorkRequestBuilder<TestWorkManager>().build()
//            WorkManager.getInstance(this).enqueue(workManagerTest)

            //고유작업
            //여러번 중복실행방지 //한번만 실행
//            WorkManager.getInstance(this).enqueueUniqueWork("test",ExistingWorkPolicy.KEEP,workManagerTest)
//
            //기존작업 취소하고 새로운 작업 실행
            WorkManager.getInstance(this).enqueueUniqueWork("test",ExistingWorkPolicy.REPLACE,workManagerTest)


        }
    }
}