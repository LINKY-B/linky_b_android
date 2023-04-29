package com.example.linkybproject.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityFindPasswordBinding
import java.util.regex.Pattern

class FindPasswordActivity : AppCompatActivity(), FindPasswordEmailView {
    private lateinit var viewBinding: ActivityFindPasswordBinding
    private lateinit var email: String

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
        viewBinding.textViewFindPWGetAuthGreen.visibility = View.INVISIBLE
        viewBinding.textViewFindPWCheckAuthGreen.visibility = View.INVISIBLE
        viewBinding.textViewFindPWGreen.visibility = View.INVISIBLE

        viewBinding.textViewFindPWGetAuthGrey.isEnabled = false
        viewBinding.textViewFindPWCheckAuthGrey.isEnabled = false
        viewBinding.textViewFindPWGrey.isEnabled = false

        viewBinding.textViewFindPWNewPWError.visibility = View.INVISIBLE
        viewBinding.textViewFindPWNewPWCheckError.visibility = View.INVISIBLE
        viewBinding.textViewFindPWAuthFail.visibility = View.INVISIBLE
        viewBinding.textViewFindPWAuthSuccess.visibility = View.INVISIBLE



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
            email = viewBinding.editTextFindPWEmail.text.toString()
            getEmail()
            Toast.makeText(this@FindPasswordActivity, "인증번호가 전송되었습니다.", Toast.LENGTH_SHORT).show()
        }
        // 1-2. 이메일 인증번호 입력
        viewBinding.editTextFindPWEmailAuth.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkOptions()
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkOptions()
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkEmailValid()
                }
            }
        )
//        viewBinding.textViewBtnCheckAuthGreen.setOnClickListener {
//            authCode = binding.editTextSignupAuth.text.toString()
//            userEmail = binding.editTextSignupEmail.text.toString()
////            userNickName = binding. // 어차피 이거 안 해도 유효성 검증 함수 마지막에 다 들어가나. 그럴 듯. 코드 통일하자
//            emailAuthCheck()
//            Toast.makeText(this@SignupActivity2, "인증번호가 확인되었습니다.", Toast.LENGTH_SHORT).show()
//        }

        // 2-1. 새 비밀번호 유효성 검사
        viewBinding.editTextFindPWNewPW.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkPwValid()
                    checkOptions()
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkPwValid()
                    checkOptions()
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkPwValid()
                    checkOptions()
                }
            }
        )
        // 2-2. 새 비밀번호 확인
        viewBinding.editTextFindPWNewPWCheck.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkPwCheckValid()
                    checkOptions()
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkPwCheckValid()
                    checkOptions()
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkPwCheckValid()
                    checkOptions()
                }
            }
        )

        // 마지막 버튼 처리
        viewBinding.textViewFindPWGreen.setOnClickListener {
            Toast.makeText(this@FindPasswordActivity, "// !!", Toast.LENGTH_SHORT).show()
        }


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

    // 비밀번호 유효성 검사 함수
    private fun checkPwValid() {
        val pw = viewBinding.editTextFindPWNewPW.text.toString()

        // 길이 검증
        if (pw.length < 7) {
            viewBinding.textViewFindPWNewPWError.visibility = View.VISIBLE
            return
        }
        // 영문, 숫자, 특수문자 검증
        for (i in 0 until pw.length) {
            if(!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{7,20}$", pw)) {
                viewBinding.textViewFindPWNewPWError.visibility = View.VISIBLE
                return
            }
        }
        // PW is valid
        viewBinding.textViewFindPWNewPWError.visibility = View.INVISIBLE
    }

    // 비밀번호 확인 함수
    private fun checkPwCheckValid() {
        val pw = viewBinding.editTextFindPWNewPW.text.toString()
        val pwCheck = viewBinding.editTextFindPWNewPWCheck.text.toString()

        // 입력한 비밀번호와 같은지 확인 (kotlin 에서는 문자열 비교 == 연산자로 가능)
        if (pw == pwCheck) {
            viewBinding.textViewFindPWNewPWCheckError.visibility = View.INVISIBLE
        } else {
            viewBinding.textViewFindPWNewPWCheckError.visibility = View.VISIBLE
        }
    }

    // 기본 정보 입력 완료 확인 함수
    private fun checkOptions() {
        // 일단 인증번호 제외
        if (viewBinding.textViewFindPWGetAuthGrey.visibility == View.INVISIBLE &&
            viewBinding.editTextFindPWEmailAuth.text.toString() != "" &&
            viewBinding.editTextFindPWNewPW.text.toString() != "" &&
            viewBinding.editTextFindPWNewPWCheck.text.toString() != "" &&
            viewBinding.textViewFindPWNewPWError.visibility == View.INVISIBLE &&
            viewBinding.textViewFindPWNewPWCheckError.visibility == View.INVISIBLE) {

            viewBinding.textViewFindPWGreen.visibility = View.VISIBLE
            viewBinding.textViewFindPWGrey.visibility = View.INVISIBLE
        } else {
            viewBinding.textViewFindPWGreen.visibility = View.INVISIBLE
            viewBinding.textViewFindPWGrey.visibility = View.VISIBLE
        }
    }

    // FindPasswordEmail
    private fun getFindPasswordEmailRequest(): FindPasswordEmailRequest {
        return FindPasswordEmailRequest(email)
    }
    private fun getEmail() {
        val findPasswordEmailService = FindPasswordEmailService()
        findPasswordEmailService.setFindPasswordEmailView(this)
        findPasswordEmailService.getEmail(getFindPasswordEmailRequest())
    }

    override fun onFindPasswordEmailViewSuccess() {
        Toast.makeText(this, "비밀번호 변경 이메일 인증 번호 받기 성공했습니다", Toast.LENGTH_SHORT).show()
    }

    override fun onFindPasswordEmailViewFailure() {
        TODO("Not yet implemented")
    }
}