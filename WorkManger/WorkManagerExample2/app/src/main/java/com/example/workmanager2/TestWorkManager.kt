package com.example.workmanager2

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.delay


class TestWorkManager(context: Context, parameter: WorkerParameters) : CoroutineWorker(context,parameter){

    override suspend fun doWork(): Result {

        Log.d("Test","Start")

        for(i in 0..3){
            Log.d("Test",i.toString())
            delay(1000)
        }


        Log.d("Test","End")

        return Result.success()
    }

}