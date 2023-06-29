package com.example.navigation3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class BlankFragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_blank1,container,false)
        view.findViewById<Button>(R.id.btn1).setOnClickListener {
//
//            //view를 연결해주고 action에 있는 id를 연결
//            Navigation.findNavController(view).navigate(R.id.action_blankFragment1_to_blankFragment2)
//
            view.findNavController().navigate(R.id.action_blankFragment1_to_blankFragment2)
}
        return view
    }
    }
