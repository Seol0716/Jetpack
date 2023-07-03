package com.example.navigationanimaton

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BlankFragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view  = inflater.inflate(R.layout.fragment_blank1,container,false)
        val btn1 = view.findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_blankFragment1_to_blankFragment2)
        }
        return view
    }
}