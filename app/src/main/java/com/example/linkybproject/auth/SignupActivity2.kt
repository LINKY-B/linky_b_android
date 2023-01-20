package com.example.linkybproject.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivitySignup2Binding

class SignupActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivitySignup2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignup2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼 비활성화 및 뷰 안 보이게
        binding.textViewBtnGetAuthGrey.isEnabled = false
        binding.textViewBtnCheckAuthGrey.isEnabled = false
        binding.textViewBtnNickGrey.isEnabled = false
        binding.textViewBtnNext3Grey.isEnabled = false
        binding.textViewError1.visibility = View.INVISIBLE
        binding.textViewError2.visibility = View.INVISIBLE
        binding.textViewSignup2NameError.visibility = View.INVISIBLE
        binding.textViewSignup2PwError.visibility = View.INVISIBLE
        binding.textViewSignup2PwCheckError.visibility = View.INVISIBLE

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

        // 사용자 선택에 응답 -> 년,월,일 각각 작성해야함

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
        
        // 휴대폰 번호 -> 뷰 처리는 했는데 지금은 이벤트 처리가 엔터키로만 되어 있음. 이벤트 처리 리스너 다시
        binding.editTextSignupPhone.setOnKeyListener(View.OnKeyListener { view, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val phoneNumber = binding.editTextSignupPhone.text.toString()

                if (phoneNumber.length != 11) {
                    // phone number is not valid - it should be 10 digits long
                    binding.textViewBtnGetAuthGreen.visibility = View.INVISIBLE
                    binding.textViewError1.visibility = View.VISIBLE
                    binding.textViewBtnGetAuthGrey.visibility = View.VISIBLE
                    Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show()
                    return@OnKeyListener true
                }

                for (i in 0 until phoneNumber.length) {
                    if (!phoneNumber[i].isDigit()) {
                        // phone number is not valid - it should contain only digits
                        binding.textViewBtnGetAuthGreen.visibility = View.INVISIBLE
                        binding.textViewError1.visibility = View.VISIBLE
                        binding.textViewBtnGetAuthGrey.visibility = View.VISIBLE
                        Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show()
                        return@OnKeyListener true
                    }
                }

                // phone number is valid
                binding.textViewBtnGetAuthGrey.visibility = View.INVISIBLE
                binding.textViewError1.visibility = View.INVISIBLE
                binding.textViewBtnGetAuthGreen.visibility = View.VISIBLE
                Toast.makeText(this, "Valid phone number", Toast.LENGTH_SHORT).show()
            }
            false
        })

    }
}