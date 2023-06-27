package com.example.workmangerchaining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

//WorkManger Chaining

// A -> 순서 상관없이 실행되도 괜찮음
// B -> 순서 상관없이 실행되도 괜찮음
// C -> 무조건 A와 B가 모두 실행 된 뒤에 실행되어야 한다


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workMangerA = OneTimeWorkRequestBuilder<WorkMangerA>().build()
        val workMangerB = OneTimeWorkRequestBuilder<WorkMangerB>().build()
        val workMangerC = OneTimeWorkRequestBuilder<WorkMangerC>().build()

//        WorkManager.getInstance(this).enqueue(workMangerA)
//        WorkManager.getInstance(this).enqueue(workMangerB)
//        WorkManager.getInstance(this).enqueue(workMangerC)

        //작업 체인잉
        WorkManager.getInstance(this)

                //beginWith 단순 작업이나 복잡한 작업할때 사용
                //A와 B가 작업이 끝난후 C가 실행
            .beginWith(listOf(workMangerA,workMangerB))
            .then(workMangerC)
            .enqueue()


    }
}