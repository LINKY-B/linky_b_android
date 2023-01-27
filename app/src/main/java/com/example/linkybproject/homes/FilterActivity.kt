package com.example.linkybproject.homes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityFilterBinding

class FilterActivity :AppCompatActivity() {
    private lateinit var binding: ActivityFilterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFilterBinding.inflate(layoutInflater)



//        //필터 넘어가는 버튼
//        val btn: Button = binding.btnFliterApplication
//        btn.setOnClickListener {
//            val intent = Intent(this,HomeFragment::class.java)
//            startActivity(intent)
//        }

        setContentView(binding.root)
        setupSpinnerDepartment()
        setupSpinnerMbti()
    }

    @SuppressLint("ResourceType")
    private fun setupSpinnerDepartment() {
        val department = resources.getStringArray(R.array.department_list_item)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, department)
        binding.departmentSpinner.adapter = adapter
    }

    @SuppressLint("ResourceType")
    private fun setupSpinnerMbti() {
        val mbti = resources.getStringArray(R.array.mbti_list_item)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mbti)
        binding.mbtiSpinner.adapter = adapter
    }

}