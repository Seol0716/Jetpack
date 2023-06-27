package com.example.workmangerchaining

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

//workmanger를 사용할려면 context, workerParameters가 상속받아야함

//workmanger 스레드에서 비동기적 실행
class WorkMangerA(context: Context, workerParameters: WorkerParameters) : Worker(context,workerParameters) {
    override fun doWork(): Result {

        for(i in 0..3){
            sleep(1000)
            Log.d("A",i.toString())
        }

        //작업에 성공
        return Result.success()
    }
}