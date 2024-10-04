package com.example.yudizapplication.Workmanager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class logUpworker (context: Context, params: WorkerParameters) : CoroutineWorker(context, params){
        override suspend fun doWork(): Result {
            try {
                delay(5000)
                Log.d("LogUploadWorker", "Log upload operation complete.")
                return Result.success()
            } catch (e: InterruptedException) {
                e.printStackTrace()
                return Result.failure()
            }
        }
    }

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            return Result.failure()
        }

        return Result.success()
    }
}
