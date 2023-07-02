package com.example.navigation4

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

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bundle = Bundle()

        //만약 보낸 데이터가 없다면
//        bundle.putString("key","value")

        val view = inflater.inflate(R.layout.fragment_blank1, container, false)

        //sfae srgs
//        val action  = BlankFragment1Directions.actionBlankFragment1ToBlankFragment2("abcdef")

        //만약 데이터를 넘기지 않는다면 = 디폴트값이 넘어감
        val action  = BlankFragment1Directions.actionBlankFragment1ToBlankFragment2()

        
        view.findViewById<Button>(R.id.btn1).setOnClickListener {
//            Navigation.findNavController(view).navigate(R.id.action_blankFragment1_to_blankFragment2)

            //데이터 전달
            Navigation.findNavController(view).navigate(action)
        }

        return view
        }

}