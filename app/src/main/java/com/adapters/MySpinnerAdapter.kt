package com.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Spinner
import com.example.todolist.databinding.ItmeSpinnerBinding
import com.models.SpinnerItem

class MySpinnerAdapter(val list:ArrayList<SpinnerItem>):BaseAdapter() {
    override fun getCount(): Int {
       return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       val itmeSpinnerBinding : ItmeSpinnerBinding
       itmeSpinnerBinding = ItmeSpinnerBinding.inflate(LayoutInflater.from(parent?.context))
        if (list[position].image!=-1){
            itmeSpinnerBinding.image.setImageResource(list[position].image)
        }
        itmeSpinnerBinding.tvName.text = list[position].degree
        return itmeSpinnerBinding.root
    }
}