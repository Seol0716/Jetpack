package com.example.workmangerchaining

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkMangerB(context: Context, workerParameters: WorkerParameters) : Worker(context,workerParameters) {
    override fun doWork(): Result {

        for (i in 0..3) {
            Thread.sleep(1000)
            Log.d("B", i.toString())
        }
        return Result.success()
    }
}
