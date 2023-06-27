package com.example.workmanger2

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class WorkMangerB(context : Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {

        //Mainactivity에서 보낸 데이터 확인
        val a = inputData.getInt("a",1000)
        val b = inputData.getInt("b",2000)
        val c = inputData.getInt("c",30000)

        Log.d("testB",a.toString())
        Log.d("testB",b.toString())
        Log.d("testB",c.toString())

        //MainActivity로 데이터 전송
        val output: Data = workDataOf("result" to 10)
        return Result.success(output)
    }
}