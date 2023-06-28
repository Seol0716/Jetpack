package com.example.workmanagerobserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.workmanagerobserver.WorkManagerTest.Companion.HowMuch

//WorkManager -> 진행상태 검토
//WorkManager -> 오래 걸리는 작업(60초 6 12 18 24) -> 몇 퍼센트 진행되었다 확인


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //인스턴스 생성
        val workManagerTest = OneTimeWorkRequestBuilder<WorkManagerTest>().build()
        WorkManager.getInstance(this).enqueue(workManagerTest)

        //보낸 데이터 받기
        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workManagerTest.id)
            .observe(this, Observer { info ->
                val progress = info?.progress
                val value = progress?.getInt(HowMuch,0)

                if(value !=0 ){
                    Log.d("Test",value.toString())
                }

                if(value == 100){
                    Log.d("Test","끝끝")
                }
            })
    }
}