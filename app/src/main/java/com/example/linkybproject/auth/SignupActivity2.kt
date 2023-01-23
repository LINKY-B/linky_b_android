package com.example.linkybproject.auth

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
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

        // 휴대폰 번호
//        binding.editTextSignupPhone.setOnKeyListener(View.OnKeyListener { view, keyCode, event ->
//            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
//                val phoneNumber = binding.editTextSignupPhone.text.toString()
//
//                if (phoneNumber.length != 11) {
//                    // phone number is not valid - it should be 10 digits long
//                    binding.textViewBtnGetAuthGreen.visibility = View.INVISIBLE
//                    binding.textViewError1.visibility = View.VISIBLE
//                    binding.textViewBtnGetAuthGrey.visibility = View.VISIBLE
//                    Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show()
//                    return@OnKeyListener true
//                }
//
//                for (i in 0 until phoneNumber.length) {
//                    if (!phoneNumber[i].isDigit()) {
//                        // phone number is not valid - it should contain only digits
//                        binding.textViewBtnGetAuthGreen.visibility = View.INVISIBLE
//                        binding.textViewError1.visibility = View.VISIBLE
//                        binding.textViewBtnGetAuthGrey.visibility = View.VISIBLE
//                        Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show()
//                        return@OnKeyListener true
//                    }
//                }
//
//                // phone number is valid
//                binding.textViewBtnGetAuthGrey.visibility = View.INVISIBLE
//                binding.textViewError1.visibility = View.INVISIBLE
//                binding.textViewBtnGetAuthGreen.visibility = View.VISIBLE
//                Toast.makeText(this, "Valid phone number", Toast.LENGTH_SHORT).show()
//            }
//            false
//        })

        // 안 먹음
//        val controlManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        val softKeyboard = SoftKeyboard(binding.constLayoutSignup2, controlManager)
//        softKeyboard.setSoftKeyboardCallback(object : SoftKeyboard.SoftKeyboardChanged {
//            override fun onSoftKeyboardHide() {
//                Handler(Looper.getMainLooper()).post {
//                    // desired action
//                    Toast.makeText(this@SignupActivity2, "키보드 내려감", Toast.LENGTH_SHORT).show()
//                    checkPhoneValid()
//                }
//            }
//
//            override fun onSoftKeyboardShow() {
//                Handler(Looper.getMainLooper()).post {
//                    // desired action
//                    Toast.makeText(this@SignupActivity2, "키보드 올라감", Toast.LENGTH_SHORT).show()
//                    checkPhoneValid()
//                }
//            }
//        })
//        softKeyboard.openSoftKeyboard();
//        softKeyboard.closeSoftKeyboard();

        // 휴대폰 번호 editText 입력하는 순간마다 이벤트 처리
        binding.editTextSignupPhone.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkPhoneValid()
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkPhoneValid()
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkPhoneValid()
                }
            })
    }

    // 휴대폰 번호 유효성 검사
    private fun checkPhoneValid() {
        val phoneNumber = binding.editTextSignupPhone.text.toString()

        if (phoneNumber.length != 11) {
            // phone number is not valid - it should be 10 digits long
            binding.textViewBtnGetAuthGreen.visibility = View.INVISIBLE
            binding.textViewError1.visibility = View.VISIBLE
            binding.textViewBtnGetAuthGrey.visibility = View.VISIBLE
            Toast.makeText(this@SignupActivity2, "Invalid phone number", Toast.LENGTH_SHORT).show()
            return
        }

        for (i in 0 until phoneNumber.length) {
            if (!phoneNumber[i].isDigit()) {
                // phone number is not valid - it should contain only digits
                binding.textViewBtnGetAuthGreen.visibility = View.INVISIBLE
                binding.textViewError1.visibility = View.VISIBLE
                binding.textViewBtnGetAuthGrey.visibility = View.VISIBLE
                Toast.makeText(this@SignupActivity2, "Invalid phone number", Toast.LENGTH_SHORT).show()
                return
            }
        }

        // phone number is valid
        binding.textViewBtnGetAuthGrey.visibility = View.INVISIBLE
        binding.textViewError1.visibility = View.INVISIBLE
        binding.textViewBtnGetAuthGreen.visibility = View.VISIBLE
        Toast.makeText(this@SignupActivity2, "Valid phone number", Toast.LENGTH_SHORT).show()
    }

}