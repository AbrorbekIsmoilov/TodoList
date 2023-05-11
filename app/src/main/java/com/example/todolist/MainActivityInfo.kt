package com.example.todolist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.catche.MySharedPreference
import com.example.todolist.databinding.ActivityMainInfoBinding

class MainActivityInfo : AppCompatActivity() {
    private lateinit var binding: ActivityMainInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        binding.apply {
            MySharedPreference.init(this@MainActivityInfo)
            var list=MySharedPreference.obektString
            val name=intent.getStringExtra("name")
            var index=-1
            for (i in 0 until list.size){
                if (list[i].name==name){
                    index=i
                    when(list[index].checkboxId.toInt()){
                        0->radOpen.isChecked=true
                        1->radDevelopment.isChecked=true
                        2->radUploading.isChecked=true
                        3->radReject.isChecked=true
                        4->radClosed.isChecked=true
                    }
                    description.text="${description.text} \n ${list[i].description}"
                    createDate.text="${createDate.text}: \n ${list[i].createDate}"
                    deadline.text="${deadline.text}: \n ${list[i].deadline}"
                    degreeImg.setImageResource(list[i].degreePicture.toInt())
                    degree.text=list[index].degree
                }
            }
            btn1.setOnClickListener {
                var chIndex=""
                if(radOpen.isChecked) chIndex="0"
                if(radDevelopment.isChecked) chIndex="1"
                if(radUploading.isChecked) chIndex="2"
                if(radReject.isChecked) chIndex="3"
                if(radClosed.isChecked) chIndex="4"
                finish()
                list[index].checkboxId=chIndex
                MySharedPreference.obektString=list
            }
        }
    }
}