package com.example.linkybproject.auth.signup

import android.app.PendingIntent
import android.app.PendingIntent.FLAG_MUTABLE
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivitySignup2Binding
import java.util.*
import java.util.regex.Pattern


class SignupActivity2 : AppCompatActivity(), EmailAuthView, EmailAuthCheckView, NicknameView {

    private lateinit var binding : ActivitySignup2Binding

    // SignupActivity3 로 가지고 넘어갈 값. 회원가입 끝에 서버에 넘길 데이터
    private lateinit var authCode: String
    private lateinit var userBirth: String
    private lateinit var userEmail: String
    private lateinit var userName: String
    private lateinit var userNickName: String
    private lateinit var userPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignup2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageViewSignup2Back.setOnClickListener {
            finish()
        }

        // 버튼 비활성화 및 뷰 안 보이게 설정
        binding.textViewBtnGetAuthGrey.isEnabled = false
        binding.textViewBtnCheckAuthGrey.isEnabled = false
        binding.textViewBtnNickGrey.isEnabled = false
        binding.textViewBtnNext3Grey.isEnabled = false
        binding.textViewError1.visibility = View.INVISIBLE
        binding.textViewSignup2AuthSuccess.visibility = View.INVISIBLE
        binding.textViewSignup2AuthFail.visibility = View.INVISIBLE
        binding.textViewSignup2NameErrorLength.visibility = View.INVISIBLE
        binding.textViewSignup2NameErrorKr.visibility = View.INVISIBLE
        binding.textViewSignup2NickError.visibility = View.INVISIBLE
        binding.textViewSignup2PwError.visibility = View.INVISIBLE
        binding.textViewSignup2PwCheckError.visibility = View.INVISIBLE
        binding.textViewSignup2NickSuccess.visibility = View.INVISIBLE // 닉네임 인증 성공하면 보이게 설정하기(완료)
        binding.textViewSignup2NickFail.visibility = View.INVISIBLE // 닉네임 인증 실패하면 보이게 설정하기(완료) -> 후순위로 재입력 처리 해보기.

        // 1-1. 이메일 유효성 검사 (editText 입력하는 순간마다 이벤트 처리)
        binding.editTextSignupEmail.addTextChangedListener(
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
        binding.textViewBtnGetAuthGreen.setOnClickListener {
            userEmail = binding.editTextSignupEmail.text.toString()
            emailAuth()
            Toast.makeText(this@SignupActivity2, "인증번호가 전송되었습니다.", Toast.LENGTH_SHORT).show()
        }
        // 1-2. 이메일 인증번호 입력
        binding.editTextSignupAuth.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkEmailAuthValid()
                    checkOptions()
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkEmailAuthValid()
                    checkOptions()
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkEmailValid()
                    checkEmailAuthValid()
                }
            }
        )
        binding.textViewBtnCheckAuthGreen.setOnClickListener {
            authCode = binding.editTextSignupAuth.text.toString()
            userEmail = binding.editTextSignupEmail.text.toString()
//            userNickName = binding. // 어차피 이거 안 해도 유효성 검증 함수 마지막에 다 들어가나. 그럴 듯. 코드 통일하자
            emailAuthCheck()
            Toast.makeText(this@SignupActivity2, "인증번호가 확인되었습니다.", Toast.LENGTH_SHORT).show()
        }

        // 2. 이름 유효성 검사
        binding.editTextSignupName.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkNameValid()
                    checkOptions()
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkNameValid()
                    checkOptions()
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkNameValid()
                    checkOptions()
                }
            }
        )

        // 3. 닉네임 유효성 검사
        binding.editTextSignupNick.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkNickValid()
                    checkOptions()
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkNickValid()
                    checkOptions()
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkNickValid()
                    checkOptions()
                }
            }
        )
        // 3-1. 닉네임 중복확인
        binding.textViewBtnNickGreen.setOnClickListener{
//            Toast.makeText(this@SignupActivity2, "닉네임 중복확인", Toast.LENGTH_SHORT).show()
            // 닉네임 중복확인 api
            nickName()
        }

        // 4. 생년월일
        // 사용자 선택 항목으로 스피너 채우기
        val spinnerYear: Spinner = binding.spinnerBirthYear
        ArrayAdapter.createFromResource(
            this,
            R.array.signup_birth_year,
            R.layout.spinner_signup_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_signup_dropdown)
            spinnerYear.adapter = adapter
        }

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

        spinnerYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long
            ) {
                checkOptions()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                checkOptions()
            }
        }
        spinnerMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long
            ) {
                checkOptions()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                checkOptions()
            }
        }
        spinnerDay.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long
            ) {
                checkOptions()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                checkOptions()
            }
        }

        // 5. 비밀번호 유효성 검사
        binding.editTextSignupPw.addTextChangedListener(
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
        // 5-1. 비밀번호 확인
        binding.editTextSignupPwCheck.addTextChangedListener(
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

        // 6. 기본 정보 입력 완료 -> SignupActivity3
        binding.textViewBtnNext3Green.setOnClickListener{
            // 생년월일 사용자 선택에 응답 -> 년,월,일 각각 작성해야함
            val year: String = binding.spinnerBirthYear.selectedItem.toString()
            var month: String = binding.spinnerBirthMonth.selectedItem.toString()
            var day: String = binding.spinnerBirthDay.selectedItem.toString()
            if (month.length == 1) {
                month = "0$month"
            }
            if (day.length == 1) {
                day = "0$day" // 2 선택하면 02로 추가되게
            }
            userBirth = year + month + day
            Toast.makeText(this@SignupActivity2, userBirth, Toast.LENGTH_SHORT).show()

            authCode = binding.editTextSignupAuth.text.toString()
            Log.d("authCode", authCode)
            Log.d("userBirth", userBirth)
            Log.d("userEmail", userEmail)
            Log.d("userName", userName)
            Log.d("userNickName", userNickName)
            Log.d("userPassword", userPassword)
            val intent = Intent(this, SignupActivity3::class.java)
            intent.putExtra("authCode", authCode)
            intent.putExtra("userBirth", userBirth)
            intent.putExtra("userEmail", userEmail)
            intent.putExtra("userName", userName)
            intent.putExtra("userNickName", userNickName)
            intent.putExtra("userPassword", userPassword)
            startActivity(intent)
        }

    }

    // 1-1. 이메일 유효성 검사 함수
    private fun checkEmailValid() {
        val email = binding.editTextSignupEmail.text.toString()

        // 이메일 유효성 검증
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // email is not valid - it should contain only digits
            binding.textViewBtnGetAuthGreen.visibility = View.INVISIBLE
            binding.textViewError1.visibility = View.VISIBLE
            binding.textViewBtnGetAuthGrey.visibility = View.VISIBLE
            return
        }

        // email is valid
        binding.textViewBtnGetAuthGrey.visibility = View.INVISIBLE
        binding.textViewError1.visibility = View.INVISIBLE
        binding.textViewBtnGetAuthGreen.visibility = View.VISIBLE

        userEmail = email
    }
    // 1-2. 이메일 인증번호 검사 함수
    private fun checkEmailAuthValid() {
        val code = binding.editTextSignupAuth.text.toString()

//        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(code).matches()) {
//            binding.textViewBtnGetAuthGreen.visibility = View.INVISIBLE
//            binding.textViewError1.visibility = View.VISIBLE
//            binding.textViewBtnGetAuthGrey.visibility = View.VISIBLE
//            return
//        }

        binding.textViewBtnCheckAuthGrey.visibility = View.INVISIBLE
//        binding.textViewError1.visibility = View.INVISIBLE
        binding.textViewBtnCheckAuthGreen.visibility = View.VISIBLE

        authCode = code
    }

    // 2. 이름 유효성 검사 함수
    private fun checkNameValid() {
        val name = binding.editTextSignupName.text.toString()

        // 길이 검증
        if (name.length > 7) {
            binding.textViewSignup2NameErrorLength.visibility = View.VISIBLE
            binding.textViewSignup2NameErrorKr.visibility = View.INVISIBLE
//            Toast.makeText(this@SignupActivity2, "Invalid Name", Toast.LENGTH_SHORT).show()
            return
        }

        // 한글 검증
        for (i in 0 until name.length) {
            if(!Pattern.matches("^[가-힣]*$", name) || name.length < 2) {
                binding.textViewSignup2NameErrorLength.visibility = View.INVISIBLE
                binding.textViewSignup2NameErrorKr.visibility = View.VISIBLE
//                Toast.makeText(this@SignupActivity2, "Invalid Name", Toast.LENGTH_SHORT).show()
                return
            }
        }

        // Name is valid
        binding.textViewSignup2NameErrorLength.visibility = View.INVISIBLE
        binding.textViewSignup2NameErrorKr.visibility = View.INVISIBLE
//        Toast.makeText(this@SignupActivity2, "Valid Name", Toast.LENGTH_SHORT).show()

        userName = name
    }

    // 3. 닉네임 유효성 검사 함수
    private fun checkNickValid() {
        val nick = binding.editTextSignupNick.text.toString()

        // 길이 검증 (일단 디자이너님 textview hint로)
        if (nick.length > 8) {
            binding.textViewSignup2NickError.visibility = View.VISIBLE
            binding.textViewBtnNickGrey.visibility = View.VISIBLE
            binding.textViewBtnNickGreen.visibility = View.INVISIBLE
//            Toast.makeText(this@SignupActivity2, "Invalid Nickname", Toast.LENGTH_SHORT).show()
            return
        }

        // 한글 검증 (<2 도 넣을 거면 오류 메시지 하나 더 추가하기)
        for (i in 0 until nick.length) {
            if(!Pattern.matches("^[가-힣]*$", nick) || nick.length < 2) {
                binding.textViewSignup2NickError.visibility = View.VISIBLE
                binding.textViewBtnNickGrey.visibility = View.VISIBLE
                binding.textViewBtnNickGreen.visibility = View.INVISIBLE
//                Toast.makeText(this@SignupActivity2, "Invalid Nickname", Toast.LENGTH_SHORT).show()
                return
            }
        }

        // Nickname is valid
        binding.textViewSignup2NickError.visibility = View.INVISIBLE
        binding.textViewBtnNickGrey.visibility = View.INVISIBLE
        binding.textViewBtnNickGreen.visibility = View.VISIBLE
//        Toast.makeText(this@SignupActivity2, "Valid Nickname", Toast.LENGTH_SHORT).show()

        userNickName = nick
    }

    // 5. 비밀번호 유효성 검사 함수
    private fun checkPwValid() {
        val pw = binding.editTextSignupPw.text.toString()

        // 길이 검증
        if (pw.length < 7) {
            binding.textViewSignup2PwError.visibility = View.VISIBLE
//            Toast.makeText(this@SignupActivity2, "Invalid pw", Toast.LENGTH_SHORT).show()
            return
        }

        // 영문, 숫자, 특수문자 검증
        for (i in 0 until pw.length) {
            if(!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{7,20}$", pw)) {
                binding.textViewSignup2PwError.visibility = View.VISIBLE
//                Toast.makeText(this@SignupActivity2, "Invalid pw", Toast.LENGTH_SHORT).show()
                return
            }
        }

        // PW is valid
        binding.textViewSignup2PwError.visibility = View.INVISIBLE
//        Toast.makeText(this@SignupActivity2, "Valid pw", Toast.LENGTH_SHORT).show()
    }

    // 5-1. 비밀번호 확인 함수
    private fun checkPwCheckValid() {
        val pw = binding.editTextSignupPw.text.toString()
        val pwCheck = binding.editTextSignupPwCheck.text.toString()

        // 입력한 비밀번호와 같은지 확인 (kotlin 에서는 문자열 비교 == 연산자로 가능)
        if (pw == pwCheck) {
            binding.textViewSignup2PwCheckError.visibility = View.INVISIBLE
            userPassword = pw
        } else {
            binding.textViewSignup2PwCheckError.visibility = View.VISIBLE
        }
    }

    // 6. 기본 정보 입력 완료 확인 함수
    private fun checkOptions() {
        // textViewBtnCheckAuthGrey 추가 (여기 다시 검토 - 임시)
        if (binding.textViewBtnGetAuthGrey.visibility == View.INVISIBLE &&
            binding.textViewSignup2NameErrorLength.visibility == View.INVISIBLE &&
            binding.textViewSignup2NameErrorKr.visibility == View.INVISIBLE &&
            binding.textViewBtnNickGrey.visibility == View.INVISIBLE &&
            binding.textViewSignup2NickError.visibility == View.INVISIBLE &&
            binding.spinnerBirthYear.selectedItem.toString() != "년" &&
            binding.spinnerBirthMonth.selectedItem.toString() != "월" &&
            binding.spinnerBirthDay.selectedItem.toString() != "일" &&
            binding.editTextSignupPw.text.toString() != "" &&
            binding.editTextSignupPwCheck.text.toString() != "" &&
            binding.textViewSignup2PwError.visibility == View.INVISIBLE &&
            binding.textViewSignup2PwCheckError.visibility == View.INVISIBLE) {

            binding.textViewBtnNext3Grey.visibility = View.INVISIBLE
            binding.textViewBtnNext3Green.visibility = View.VISIBLE
        } else {
            binding.textViewBtnNext3Green.visibility = View.INVISIBLE
            binding.textViewBtnNext3Grey.visibility = View.VISIBLE
        }
    }

    // 이메일 인증 번호 받기
    private fun getEmailAuthRequest(): EmailAuthRequest {
        return EmailAuthRequest(userEmail, userNickName)
    }
    private fun emailAuth() {
        val emailAuthService = EmailAuthService()
        emailAuthService.setEmailAuthView(this)
        emailAuthService.emailAuth(getEmailAuthRequest())
    }

    override fun onEmailAuthSuccess() {
        Toast.makeText(this, "이메일 인증 번호 받기 api 성공했습니다", Toast.LENGTH_SHORT).show()
    }
    override fun onEmailAuthFailure() {
        TODO("Not yet implemented")
    }


    // 이메일 인증 번호 검증
    private fun getEmailAuthCheckRequest(): EmailAuthCheckRequest {
        return EmailAuthCheckRequest(authCode, userEmail, userNickName)
    }
    private fun emailAuthCheck() {
        val emailAuthCheckService = EmailAuthCheckService()
        emailAuthCheckService.setEmailAuthCheckView(this)
        emailAuthCheckService.emailAuthCheck(getEmailAuthCheckRequest())
    }

    override fun onEmailAuthCheckSuccess() {
        Toast.makeText(this, "이메일 인증 번호 검증 api 성공했습니다", Toast.LENGTH_SHORT).show()
        binding.textViewSignup2AuthSuccess.visibility = View.VISIBLE
    }
    override fun onEmailAuthCheckFailure() {
        Toast.makeText(this, "이메일 인증 번호 검증 api 실패했습니다", Toast.LENGTH_SHORT).show()
        binding.textViewSignup2AuthFail.visibility = View.VISIBLE
    }

    // 닉네임 중복확인
    private fun getNicknameRequest(): NicknameRequest {
        return NicknameRequest(userNickName)
    }
    private fun nickName() {
        val nicknameService = NicknameService()
        nicknameService.setNicknameView(this)
        nicknameService.nickName(getNicknameRequest())
    }

    override fun onNicknameSuccess() {
        Toast.makeText(this, "닉네임 중복 확인 api 성공했습니다", Toast.LENGTH_SHORT).show()
        binding.textViewSignup2NickSuccess.visibility = View.VISIBLE
    }
    override fun onNicknameFailure() {
        Toast.makeText(this, "닉네임 중복 확인 api 실패했습니다", Toast.LENGTH_SHORT).show()
        binding.textViewSignup2NickFail.visibility = View.VISIBLE
    }

}