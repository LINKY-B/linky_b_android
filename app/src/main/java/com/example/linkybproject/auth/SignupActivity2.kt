package com.example.linkybproject.auth

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
import androidx.core.content.ContextCompat
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivitySignup2Binding
import java.util.*
import java.util.jar.Manifest
import java.util.regex.Pattern


class SignupActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivitySignup2Binding

    companion object {
        const val SMS_SEND_PERMISSION: Int = 1
    }
    private lateinit var checkNum: String // 생성한 인증번호를 담을 변수


    // SignupActivity3 로 가지고 넘어갈 값. 회원가입 끝에 서버에 넘길 데이터
    private lateinit var userName: String
    private lateinit var userNickName: String
    private lateinit var userPhone: String // api 수정되면 휴대폰 -> 이메일 전체 수정
    private lateinit var userPassword: String
    private lateinit var userBirth: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignup2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        val pref: SharedPreferences = getSharedPreferences("shared", 0)
//        val editor = pref.edit()

        binding.imageViewSignup2Back.setOnClickListener {
            finish()
        }

        // 버튼 비활성화 및 뷰 안 보이게 설정
        binding.textViewBtnGetAuthGrey.isEnabled = false
        binding.textViewBtnCheckAuthGrey.isEnabled = false
        binding.textViewBtnNickGrey.isEnabled = false
        binding.textViewBtnNext3Grey.isEnabled = false
        binding.textViewError1.visibility = View.INVISIBLE
        binding.textViewError2.visibility = View.INVISIBLE
        binding.textViewSignup2NameErrorLength.visibility = View.INVISIBLE
        binding.textViewSignup2NameErrorKr.visibility = View.INVISIBLE
        binding.textViewSignup2NickError.visibility = View.INVISIBLE
        binding.textViewSignup2PwError.visibility = View.INVISIBLE
        binding.textViewSignup2PwCheckError.visibility = View.INVISIBLE

        // 1. 이메일 유효성 검사 (editText 입력하는 순간마다 이벤트 처리)
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

        // 1-2. SMS 발송 권한 체크
//        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
//
//        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
//            // 문자 보내기 권한 거부
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
//                // Handle rationale for requesting SMS_SEND_PERMISSION
//                Toast.makeText(this@SignupActivity2, "SMS 권한이 필요합니다.", Toast.LENGTH_SHORT).show()
//            }
//
//            // 문자 보내기 권한 허용
//            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS),
//                Companion.SMS_SEND_PERMISSION
//            )
//        }

        // 1-3. 인증번호 받기 버튼
//        binding.textViewBtnGetAuthGreen.setOnClickListener {
//            checkNum = numberGen(6, 1)
//            editor.putString("checkNum", checkNum)
//            editor.apply()
//            sendSMS(binding.editTextSignupPhone.text.toString(), "인증번호 : $checkNum")
//
//            Log.d("shared checkNum", pref.getString("checkNum", "").toString())
//        }
//
//        // 1-4. 인증번호 확인 버튼
//        binding.textViewBtnCheckAuthGreen.setOnClickListener {
//            if (pref.getString("checkNum", "").equals(binding.editTextSignupAuth.text.toString())) {
//                Toast.makeText(this@SignupActivity2, "인증 완료 되었습니다.", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this@SignupActivity2, "인증번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
//            }
//        }
        // 여기 확인 완료되면, 이거 포함한 넘어가기 버튼 체크, 타이머 기능 추가해야함.


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
            Toast.makeText(this@SignupActivity2, "닉네임 중복확인", Toast.LENGTH_SHORT).show()
            // 서버 
            // error(false), true 문 textView 추가해야함
        }

        // 4. 생년월일
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

            Log.d("userName", userName)
            Log.d("userNickName", userNickName)
            Log.d("userPhone", userPhone)
            Log.d("userPassword", userPassword)
            Log.d("userBirth", userBirth)
            val intent = Intent(this, SignupActivity3::class.java)
            intent.putExtra("userName", userName)
            intent.putExtra("userNickName", userNickName)
            intent.putExtra("userPhone", userPhone)
            intent.putExtra("userPassword", userPassword)
            intent.putExtra("userBirth", userBirth)
            startActivity(intent)
        }

    }

    // 1. 이메일 유효성 검사 함수
    private fun checkEmailValid() {
        val email = binding.editTextSignupEmail.text.toString()

        // 길이 검증
//        if (email.length != 11) {
//            // phone number is not valid - it should be 10 digits long
//            binding.textViewBtnGetAuthGreen.visibility = View.INVISIBLE
//            binding.textViewError1.visibility = View.VISIBLE
//            binding.textViewBtnGetAuthGrey.visibility = View.VISIBLE
////            Toast.makeText(this@SignupActivity2, "Invalid phone number", Toast.LENGTH_SHORT).show()
//            return
//        }

        // 이메일 유효성 검증
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // email is not valid - it should contain only digits
            binding.textViewBtnGetAuthGreen.visibility = View.INVISIBLE
            binding.textViewError1.visibility = View.VISIBLE
            binding.textViewBtnGetAuthGrey.visibility = View.VISIBLE
//            Toast.makeText(this@SignupActivity2, "Invalid email", Toast.LENGTH_SHORT).show()
            return
        }

        // email is valid
        binding.textViewBtnGetAuthGrey.visibility = View.INVISIBLE
        binding.textViewError1.visibility = View.INVISIBLE
        binding.textViewBtnGetAuthGreen.visibility = View.VISIBLE
//        Toast.makeText(this@SignupActivity2, "Valid email", Toast.LENGTH_SHORT).show()

        userPhone = email
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

    // 7. SMS 발송 기능
    private fun sendSMS(phoneNumber: String, message: String) {
        val pendingIntent = PendingIntent.getActivity(this, 0, Intent(this, SignupActivity2::class.java), FLAG_MUTABLE)
        val sms = SmsManager.getDefault()
        sms.sendTextMessage(phoneNumber, null, message, pendingIntent, null)
        Toast.makeText(this@SignupActivity2, "메시지가 전송되었습니다.", Toast.LENGTH_SHORT).show()
    }

    // 8. 인증번호 생성 기능
    fun numberGen(len: Int, dupCd: Int): String {
        val rand = Random()
        var numStr = "" // 난수 저장 변수

        for (i in 0 until len) {
            // 0~9까지 난수 생성
            val ran = rand.nextInt(10).toString()

            if (dupCd == 1) {
                numStr += ran // 중복 허용 시 numStr에 append
            } else if (dupCd == 2) {
                if (!numStr.contains(ran)) { // 중복을 허용하지 않을 시 중복된 값이 있는지 검사
                    numStr += ran
                } else {
                    continue // equivalent to i -= 1 in the original code, 생성된 난수가 중복되면 루틴을 다시 실행
                }
            }
        }
        return numStr
    }



}