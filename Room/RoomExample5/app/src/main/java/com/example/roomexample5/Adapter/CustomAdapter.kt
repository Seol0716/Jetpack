package com.example.roomexample5.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomexample5.DataEntity.TextEntity
import com.example.roomexample5.R

class CustomAdapter(private val dataSet : List<TextEntity>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val textView : TextView = view.findViewById(R.id.text_test)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.test_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].text
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}