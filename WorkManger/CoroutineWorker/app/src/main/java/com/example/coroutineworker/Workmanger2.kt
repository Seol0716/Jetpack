package com.example.coroutineworker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.lang.reflect.Parameter


//coroutine worker는 CoroutineWorker를 상속받아 context와 WorkerParameters를 넘겨줌
class Workmanger2(context: Context, workerParameter: WorkerParameters) : CoroutineWorker(context,workerParameter) {
    override suspend fun doWork(): Result {

        //Coroutine Worker 변경방법

        withContext(Dispatchers.IO){
        test1()
        test2()
        }

        return Result.success()
    }

    suspend fun test1(){
        for(i in 1..3){
            delay(1000)
            Log.d("test1",i.toString())
        }
    }


    suspend fun test2(){
        for(i in 1..3){
            delay(1000)
            Log.d("test2",i.toString())
        }
    }
}