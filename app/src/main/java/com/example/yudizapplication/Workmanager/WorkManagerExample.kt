package com.example.yudizapplication.Workmanager

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.MotionEffect.TAG
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.yudizapplication.R

class WorkManagerExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_work_manager_example)

        val statusTxt_view = findViewById<TextView>(R.id.statusTextView)
        val btn_upload = findViewById<TextView>(R.id.uploadButton)
        btn_upload.setOnClickListener {

            val uploadWorkRequest = OneTimeWorkRequest.Builder(logUpworker::class.java).build()

            WorkManager.getInstance(this).enqueue(uploadWorkRequest)

            WorkManager.getInstance(this).getWorkInfoByIdLiveData(uploadWorkRequest.id)
                .observe(this, Observer { workInfo ->
                    if (workInfo != null) {
                        when (workInfo.state) {
                            WorkInfo.State.ENQUEUED ->{
                                Log.d(TAG, "Worker Log Enqueued")
                                statusTxt_view.text = "Worker log enqueued"
                            }

                            WorkInfo.State.SUCCEEDED -> {
                                Log.d(TAG, "Worker Log Upload Completed")

                                statusTxt_view.text = "Log upload completed!"
                            }

                            WorkInfo.State.FAILED -> {
                                Log.d(TAG, "Worker Log Upload failed")

                                statusTxt_view.text = "Log upload failed!"
                            }

                            WorkInfo.State.CANCELLED ->{

                                statusTxt_view.text = "Log worker Cancelled"
                                Log.d(TAG, "Worker CANCELLED")
                                }
                            WorkInfo.State.RUNNING -> {
                                Log.d(TAG, "Worker Log Uploading...")

                                statusTxt_view.text = "Log uploading..."
                            }
                            else -> {
                                Log.d(TAG, "Waiting to upl")
                                statusTxt_view.text = "Waiting to upload logs..."
                            }
                        }
                    }
                })
        }
    }
}
