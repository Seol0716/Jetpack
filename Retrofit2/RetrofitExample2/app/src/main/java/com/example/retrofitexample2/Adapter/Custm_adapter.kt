package com.example.retrofitexample2.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexample2.R
import com.example.retrofitexample2.model.Post

class Custm_adapter(private val dataSet : ArrayList<Post>) : RecyclerView.Adapter<Custm_adapter.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val textView : TextView
        init {
            textView = view.findViewById(R.id.text)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].title
    }
}