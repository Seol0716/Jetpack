package com.example.workmanger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf

//WorkManger로 값 주고받기

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//
//        val workManagerA = OneTimeWorkRequestBuilder<WorManagerA>().build()
//        WorkManager.getInstance(this).enqueue(workManagerA)

        //WorkMangerB 클래스로 데이터 보낼 셋 설정
        val myData : Data = workDataOf(
            "a" to 10,
            "b" to 20
        )

        //인스턴스 생성하고 데이터 보냄
        val workMangerB = OneTimeWorkRequestBuilder<WorkMangerB>().setInputData(myData).build()
        WorkManager.getInstance(this).enqueue(workMangerB)

        //WorkMangerB의 보낸 데이터 받음
        //WorkManger로 관찰하여 보낸 데이터가 있는지 확인
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workMangerB.id)
            .observe(this, Observer { info ->
                if(info != null && info.state.isFinished){

                    val result = info.outputData.getInt("result",1000)
                    val result2 = info.outputData.getInt("result2",1000)
                    Log.d("test",result.toString())
                    Log.d("test2",result2.toString())
                }
            })

    }
}


