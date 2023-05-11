package com.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.todolist.databinding.ItmeChildBinding
import com.example.todolist.databinding.ItmeGrupBinding
import com.models.Todo

class MyExpandibleAdapter(private val map:HashMap<String, ArrayList<Todo>>, private val groupList:ArrayList<String>)
    : BaseExpandableListAdapter(){
    override fun getGroupCount(): Int {
        return groupList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[groupList[groupPosition]]?.size!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return groupList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[groupList[groupPosition]]?.get(childPosition)!!
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemGroup=ItmeGrupBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        itemGroup.tvGrup.text=groupList[groupPosition]
        return itemGroup.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemChild=ItmeChildBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        itemChild.tvChild.text=map[groupList[groupPosition]]?.get(childPosition)?.name.toString()
        return itemChild.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

}