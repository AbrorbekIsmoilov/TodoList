package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adapters.MySpinnerAdapter
import com.example.todolist.databinding.ActivityMainBinding
import com.utils.MyData

class MainActivity : AppCompatActivity() {
private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {

            btnaddtodo.setOnClickListener {
                startActivity(Intent(this@MainActivity,AddToDo::class.java))
            }
            btntodo.setOnClickListener {
                startActivity(Intent(this@MainActivity,ToDoList::class.java))
            }
        }
    }
}