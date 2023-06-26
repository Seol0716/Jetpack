package com.example.workmanger1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

//WorkManger란 앱이 종료되더라도 "예약"을 하고 작업을 해주는 라이브러리
//백그라운드 작업
//Coroutine 지원
//작업 순서 설정 -> 작업 순서 지정
//상태지정도 가능
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thread().start()

        val workMangerA = OneTimeWorkRequestBuilder<WorkMangerA>().build()
        WorkManager.getInstance().enqueue(workMangerA)
    }
}

class thread : Thread() {

    override fun run() {
        super.run()

        for(i in 1..10){
            Log.d("test","$i")
            sleep(1000)

        }
    }
}