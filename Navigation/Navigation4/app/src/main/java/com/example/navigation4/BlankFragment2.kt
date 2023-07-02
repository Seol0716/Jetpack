package com.example.navigation4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

class BlankFragment2 : Fragment() {

    val args : BlankFragment2Args by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_blank2, container, false)

        //보낸 데이터 받기

        //보낸 데이터가 없으면 null값
        //null값 방지로 Safe Arguments 사용
        val getString = arguments?.getString("key")
        Log.d("test",getString.toString())

        view.findViewById<Button>(R.id.btn2).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_blankFragment2_to_blankFragment1)
        }

        //safe args 받은 데이터
        Log.d("test",args.key)
        return view
         }
}