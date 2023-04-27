package com.example.linkybproject.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityFindPasswordBinding
import com.example.linkybproject.databinding.ActivityMemberLeaveBinding

class FindPasswordActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityFindPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityFindPasswordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        // back 버튼
        viewBinding.textViewFindPWBack.setOnClickListener {
            finish()
        }

        // 초기 뷰 설정
        viewBinding.textViewFindPasswordErrorMessage.visibility = View.INVISIBLE
        viewBinding.textViewFindPWGetAuthGreen.isEnabled = false
        viewBinding.textViewFindPWCheckAuthGreen.isEnabled = false
        viewBinding.textViewFindPWGreen.isEnabled = false


        // 1-1. 이메일 유효성 검사 (editText 입력하는 순간마다 이벤트 처리)
        viewBinding.editTextFindPWEmail.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkEmailValid()
                    checkOptions()
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkEmailValid()
                    checkOptions()
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkEmailValid()
                    checkOptions()
                }
            }
        )
        viewBinding.textViewFindPWGetAuthGreen.setOnClickListener {
//            userEmail = binding.editTextSignupEmail.text.toString()
//            emailAuth()
            Toast.makeText(this@FindPasswordActivity, "인증번호가 전송되었습니다.", Toast.LENGTH_SHORT).show()
        }
//        // 1-2. 이메일 인증번호 입력
//        viewBinding.editTextSignupAuth.addTextChangedListener(
//            object : TextWatcher {
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                    checkEmailValid()
//                    checkOptions()
//                }
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                    checkEmailValid()
//                    checkOptions()
//                }
//
//                override fun afterTextChanged(p0: Editable?) {
//                    checkEmailValid()
//                    checkEmailValid()
//                }
//            }
//        )
//        viewBinding.textViewBtnCheckAuthGreen.setOnClickListener {
//            authCode = binding.editTextSignupAuth.text.toString()
//            userEmail = binding.editTextSignupEmail.text.toString()
////            userNickName = binding. // 어차피 이거 안 해도 유효성 검증 함수 마지막에 다 들어가나. 그럴 듯. 코드 통일하자
//            emailAuthCheck()
//            Toast.makeText(this@SignupActivity2, "인증번호가 확인되었습니다.", Toast.LENGTH_SHORT).show()
//        }


    }

    // 이메일 유효성 검사 함수
    private fun checkEmailValid() {
        val email = viewBinding.editTextFindPWEmail.text.toString()

        // 이메일 유효성 검증
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // email is not valid - it should contain only digits
            viewBinding.textViewFindPWGetAuthGreen.visibility = View.INVISIBLE
            viewBinding.textViewFindPasswordErrorMessage.visibility = View.VISIBLE
            viewBinding.textViewFindPWGetAuthGrey.visibility = View.VISIBLE
            return
        }

        // email is valid
        viewBinding.textViewFindPWGetAuthGrey.visibility = View.INVISIBLE
        viewBinding.textViewFindPasswordErrorMessage.visibility = View.INVISIBLE
        viewBinding.textViewFindPWGetAuthGreen.visibility = View.VISIBLE
    }

    // 기본 정보 입력 완료 확인 함수
    private fun checkOptions() {

    }
}