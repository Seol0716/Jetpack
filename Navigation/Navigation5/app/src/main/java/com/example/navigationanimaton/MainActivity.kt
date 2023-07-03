package com.example.navigationanimaton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


//animation
//enterAnim 사용 A -> B가 갈때 B가 보이는 방식
//exitAnim A -> B로 갈 때 A가 사라지는 방식
//popenterAnim 뒤로가기로 B -> A로 올 때 A가 사라지는 방식
//popexitanim //뒤로가기로 B -> A로 올 때 B가 사라지는 방식


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}