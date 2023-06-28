package com.example.workmanagerobserver

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.delay

class WorkManagerTest(context: Context, parameter: WorkerParameters) : CoroutineWorker(context,parameter){

    companion object {
        const val HowMuch = "progress"
    }

    override suspend fun doWork(): Result {

        //MainActivity로 작업의 진행률을 보낸다
        //i가 1 ~ 10까지 반복 / 퍼센트로 10 20 30 ...100
        //1 ~ 10까지 프로그래스 형태로 반복
        for( i in 1..10){
            val result = workDataOf(HowMuch to i * 10)
            setProgress(result)
            delay(1000)
        }
        return Result.success()
    }

}