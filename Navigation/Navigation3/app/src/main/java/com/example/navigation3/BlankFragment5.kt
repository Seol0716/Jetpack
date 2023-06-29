package com.example.navigation3

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation

//Fragment5에서 백버튼시 Fragment1로 이동
class BlankFragment5 : Fragment() {
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//
////        val callback : OnBackPressedCallback = object  : OnBackPressedCallback(true){
////            override fun handleOnBackPressed() {
////
////                Log.d("fragment5","pressed ")
////
////                //백 버튼시 fragment1로 이동은 하지만 1과 5가 반복되는 문제가 발생
////
////                view?.let {
////                    Navigation.findNavController(it).navigate(R.id.action_blankFragment5_to_blankFragment1)
////                }
////
////            }
////        }
////
////        requireActivity().onBackPressedDispatcher.addCallback(this,callback)
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_blank5, container, false)
    }
}