package com.example.workmanger1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class WorkMangerA(context: Context,workerparameters : WorkerParameters) :
Worker(context,workerparameters){

    override fun doWork(): Result {

        for(i in 1..10){
            sleep(1000)
            Log.d("WorktestA",i.toString())
        }
        return Result.success()

     }

}