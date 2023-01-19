package com.example.linkybproject.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivitySignup2Binding

class SignupActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivitySignup2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignup2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 사용자 선택 항목으로 스피너 채우기
        val spinnerYear: Spinner = binding.spinnerBirthYear
        ArrayAdapter.createFromResource(
            this,
            R.array.signup_birth_year,
            R.layout.spinner_signup_item
            //android.R.layout.simple_spinner_item
        ).also { adapter ->
            //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            adapter.setDropDownViewResource(R.layout.spinner_signup_dropdown)
            spinnerYear.adapter = adapter
        }

        // 사용자 선택에 응답

        val spinnerMonth: Spinner = binding.spinnerBirthMonth
        ArrayAdapter.createFromResource(
            this,
            R.array.signup_birth_month,
            R.layout.spinner_signup_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_signup_dropdown)
            spinnerMonth.adapter = adapter
        }

        val spinnerDay: Spinner = binding.spinnerBirthDay
        ArrayAdapter.createFromResource(
            this,
            R.array.signup_birth_day,
            R.layout.spinner_signup_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_signup_dropdown)
            spinnerDay.adapter = adapter
        }
    }
}