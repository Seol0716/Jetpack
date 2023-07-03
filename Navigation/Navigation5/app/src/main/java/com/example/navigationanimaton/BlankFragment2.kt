package com.example.navigationanimaton

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class BlankFragment2 : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view  = inflater.inflate(R.layout.fragment_blank2,container,false)

        val btn2 = view.findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_blankFragment2_to_blankFragment1)
        }

        return view

        }
}