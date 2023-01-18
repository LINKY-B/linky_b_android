package com.example.linkybproject.homes

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityFilterBinding

class FilterActivity :AppCompatActivity() {
    private lateinit var binding: ActivityFilterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFilterBinding.inflate(layoutInflater)

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