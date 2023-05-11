package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.adapters.MySpinnerAdapter
import com.catche.MySharedPreference
import com.example.todolist.databinding.ActivityAddToDoBinding
import com.models.SpinnerItem
import com.models.Todo
import com.models.TodoList
import com.utils.MyData
import com.utils.MyData.list

class AddToDo : AppCompatActivity() {
    private val binding by lazy { ActivityAddToDoBinding.inflate(layoutInflater) }
    private lateinit var listSpinner: ArrayList<SpinnerItem>
    private lateinit var spinnerAdapter: MySpinnerAdapter
    lateinit var mySpinnerAdapter: MySpinnerAdapter
    lateinit var mySharedPreference: MySharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listSpinner = ArrayList()
        listSpinner.add(SpinnerItem("To do degree", -1))
        listSpinner.add(SpinnerItem("Urgent", R.drawable.reg_flag))
        listSpinner.add(SpinnerItem("High", R.drawable.yellow_flag))
        listSpinner.add(SpinnerItem("Normal", R.drawable.blue_flag))
        listSpinner.add(SpinnerItem("Low", R.drawable.gray_flag))

        mySpinnerAdapter = MySpinnerAdapter(listSpinner)
        binding.spinner.adapter = mySpinnerAdapter

        val name = binding.edt1.text
        val description = binding.edt2.text
        val createDate = binding.edt3.text
        val deadline = binding.edt4.text
        val checkboxId = 0
        var degree = ""
        var degreeImg = 0

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                degree = listSpinner[position].degree
                degreeImg = listSpinner[position].image
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
        MySharedPreference.init(this)

        binding.movieSave.setOnClickListener {
            if (name.isEmpty() || createDate.isEmpty() || deadline.isEmpty() || degree.isEmpty() || description.isEmpty() || degreeImg == -1) {
                Toast.makeText(this, "Maydonni to'ldiring!", Toast.LENGTH_SHORT).show()
            } else {
                TodoList.todoList.add(
                    Todo(
                        "$name",
                        "$description",
                        "$degree",
                        "$degreeImg",
                        "$createDate",
                        "$deadline",
                        "$checkboxId"
                    )
                )
                MySharedPreference.obektString = TodoList.todoList
                finish()
            }
        }
    }
}