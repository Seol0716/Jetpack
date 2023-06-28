package com.example.workmanager1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.Date

class WorkManager1(context: Context, parameter : WorkerParameters) : Worker(context,parameter){
    override fun doWork(): Result {

        val format = SimpleDateFormat("hh:mm:ss")
        val currentTime = format.format(Date())
        Log.d("Test",currentTime)

        return Result.success()
    }

}