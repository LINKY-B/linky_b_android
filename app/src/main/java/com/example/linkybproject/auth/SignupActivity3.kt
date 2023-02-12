package com.example.linkybproject.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivitySignup3Binding

class SignupActivity3 : AppCompatActivity() {

    private lateinit var binding : ActivitySignup3Binding

    // SignupActivity4 로 가지고 넘어갈 값. 회원가입 끝에 서버에 넘길 데이터
    private lateinit var userSchoolName : String
    private lateinit var userMajorName : String
    private lateinit var userStudentNum : String
    private var gradeStatus : Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignup3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // back 버튼
        binding.imageViewSignup3Back.setOnClickListener {
            finish()
        }

        // 버튼 비활성화 및 뷰 안 보이게 설정
        binding.textViewBtnNext4Grey.isEnabled = false
        // 재학생
        binding.textViewSignup3AuthStu.visibility = View.INVISIBLE
        binding.editTextSignup3Email.visibility = View.INVISIBLE
        binding.textViewSignup3BtnGetAuthGreen.visibility = View.INVISIBLE
        binding.textViewSignup3BtnGetAuthGrey.visibility = View.INVISIBLE
        binding.textViewSignup3AuthEmailError.visibility = View.INVISIBLE
        binding.editTextSignup3EmailAuth.visibility = View.INVISIBLE
        binding.textViewSignupTimer.visibility = View.INVISIBLE
        binding.textViewSignup3BtnCheckAuthGreen.visibility = View.INVISIBLE
        binding.textViewSignup3BtnCheckAuthGrey.visibility = View.INVISIBLE
        binding.textViewSignup3AuthCheckError.visibility = View.INVISIBLE
        // 졸업생
        binding.textViewSignup3AuthGrad.visibility = View.INVISIBLE
        binding.textViewSignup3AuthGradExplain.visibility = View.INVISIBLE


        // 1. 소속 학교 드롭다운
        val spinnerUniv: Spinner = binding.spinnerUniv
        ArrayAdapter.createFromResource(
            this,
            R.array.signup_univ,
            R.layout.spinner_signup_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_signup_dropdown)
            spinnerUniv.adapter = adapter
        }

        spinnerUniv.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long
            ) {
                checkOptions()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                checkOptions()
            }
        }

        // 2. 소속 학과 입력
        binding.editTextSignup3Major.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkOptions()
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkOptions()
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkOptions()
                }
            }
        )

        // 3. 학번 입력
        // 학번 유효성 검사, 에러 메시지 추가하기
        binding.editTextSignupUniNum.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkOptions()
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkOptions()
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkOptions()
                }
            }
        )

        // 4. 졸업 여부
        val spinnerGrad: Spinner = binding.spinnerGrad
        ArrayAdapter.createFromResource(
            this,
            R.array.signup_grad,
            R.layout.spinner_signup_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_signup_dropdown)
            spinnerGrad.adapter = adapter
        }

        spinnerGrad.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long
            ) {
                checkOptions()
                val flag : String = binding.spinnerGrad.selectedItem.toString()
                if (flag == "미졸업") {
                    binding.textViewSignup3AuthExplain.visibility = View.INVISIBLE
                    // 재학생
                    binding.textViewSignup3AuthStu.visibility = View.VISIBLE
                    binding.editTextSignup3Email.visibility = View.VISIBLE
                    binding.textViewSignup3BtnGetAuthGreen.visibility = View.VISIBLE
                    binding.textViewSignup3BtnGetAuthGrey.visibility = View.VISIBLE
//                    binding.textViewSignup3AuthEmailError.visibility = View.VISIBLE
                    binding.editTextSignup3EmailAuth.visibility = View.VISIBLE
                    binding.textViewSignupTimer.visibility = View.VISIBLE
                    binding.textViewSignup3BtnCheckAuthGreen.visibility = View.VISIBLE
                    binding.textViewSignup3BtnCheckAuthGrey.visibility = View.VISIBLE
//                    binding.textViewSignup3AuthCheckError.visibility = View.VISIBLE

                    binding.textViewSignup3AuthGrad.visibility = View.INVISIBLE
                    binding.textViewSignup3AuthGradExplain.visibility = View.INVISIBLE

                    gradeStatus = false
                } else if (flag == "졸업") {
                    binding.textViewSignup3AuthExplain.visibility = View.INVISIBLE
                    // 졸업생
                    binding.textViewSignup3AuthStu.visibility = View.INVISIBLE
                    binding.editTextSignup3Email.visibility = View.INVISIBLE
                    binding.textViewSignup3BtnGetAuthGreen.visibility = View.INVISIBLE
                    binding.textViewSignup3BtnGetAuthGrey.visibility = View.INVISIBLE
                    binding.textViewSignup3AuthEmailError.visibility = View.INVISIBLE
                    binding.editTextSignup3EmailAuth.visibility = View.INVISIBLE
                    binding.textViewSignupTimer.visibility = View.INVISIBLE
                    binding.textViewSignup3BtnCheckAuthGreen.visibility = View.INVISIBLE
                    binding.textViewSignup3BtnCheckAuthGrey.visibility = View.INVISIBLE
                    binding.textViewSignup3AuthCheckError.visibility = View.INVISIBLE

                    binding.textViewSignup3AuthGrad.visibility = View.VISIBLE
                    binding.textViewSignup3AuthGradExplain.visibility = View.VISIBLE

                    gradeStatus = true
                } else {
                    binding.textViewSignup3AuthExplain.visibility = View.VISIBLE
                    // 재학생
                    binding.textViewSignup3AuthStu.visibility = View.INVISIBLE
                    binding.editTextSignup3Email.visibility = View.INVISIBLE
                    binding.textViewSignup3BtnGetAuthGreen.visibility = View.INVISIBLE
                    binding.textViewSignup3BtnGetAuthGrey.visibility = View.INVISIBLE
                    binding.textViewSignup3AuthEmailError.visibility = View.INVISIBLE
                    binding.editTextSignup3EmailAuth.visibility = View.INVISIBLE
                    binding.textViewSignupTimer.visibility = View.INVISIBLE
                    binding.textViewSignup3BtnCheckAuthGreen.visibility = View.INVISIBLE
                    binding.textViewSignup3BtnCheckAuthGrey.visibility = View.INVISIBLE
                    binding.textViewSignup3AuthCheckError.visibility = View.INVISIBLE
                    // 졸업생
                    binding.textViewSignup3AuthGrad.visibility = View.INVISIBLE
                    binding.textViewSignup3AuthGradExplain.visibility = View.INVISIBLE
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                checkOptions()
            }
        }

        // 4-1. 미졸업
        // 4-2. 졸업
        // 졸업 부분 인증하고 밑에 버튼 뷰 처리까지 해야 함.

        // 5. 학교 정보 입력 완료 -> signupActivity4
        binding.textViewBtnNext4Green.setOnClickListener{
            userSchoolName = binding.spinnerUniv.selectedItem.toString()
            userMajorName = binding.editTextSignup3Major.text.toString()
            userStudentNum = binding.editTextSignupUniNum.text.toString()
//            Toast.makeText(this@SignupActivity3, userSchoolName, Toast.LENGTH_SHORT).show()
            Toast.makeText(this@SignupActivity3, userMajorName, Toast.LENGTH_SHORT).show()
//            Toast.makeText(this@SignupActivity3, userStudentNum, Toast.LENGTH_SHORT).show()
//            Toast.makeText(this@SignupActivity3, gradeStatus, Toast.LENGTH_SHORT).show()

            val extras = intent.extras
            val userName = extras?.get("userName") as String
            val userNickName = extras?.get("userNickName") as String
            val userPhone = extras?.get("userPhone") as String
            val userPassword = extras?.get("userPassword") as String
            val userBirth = extras?.get("userBirth") as String
            Log.d("userName", userName)
            Log.d("userNickName", userNickName)
            Log.d("userPhone", userPhone)
            Log.d("userPassword", userPassword)
            Log.d("userBirth", userBirth)
            Log.d("userSchoolName", userSchoolName)
            Log.d("userMajorName", userMajorName)
            Log.d("userStudentNum", userStudentNum)
            Log.d("gradeStatus", gradeStatus.toString())
            val intent = Intent(this, SignupActivity4::class.java)
            intent.putExtra("userName", userName)
            intent.putExtra("userNickName", userNickName)
            intent.putExtra("userPhone", userPhone)
            intent.putExtra("userPassword", userPassword)
            intent.putExtra("userBirth", userBirth)
            intent.putExtra("userSchoolName", userSchoolName)
            intent.putExtra("userMajorName", userMajorName)
            intent.putExtra("userStudentNum", userStudentNum)
            intent.putExtra("gradeStatus", gradeStatus)
            startActivity(intent)
        }

    }

    // 6. 기본 정보 입력 완료 확인 함수
    private fun checkOptions() {
        // textViewBtnCheckAuthGrey 추가 (여기 다시 검토 - 임시)
        if(binding.spinnerUniv.selectedItem.toString().length <= 7 &&
                binding.editTextSignup3Major.text.toString() != "" &&
                binding.editTextSignupUniNum.text.toString() != "" &&
                binding.spinnerGrad.selectedItem.toString().length <= 7) {
            // if 문 하나 더 해서 재학생, 졸업생 확인하기
            if (binding.spinnerGrad.selectedItem.toString() == "미졸업") {

            } else if (binding.spinnerGrad.selectedItem.toString() == "졸업") {

            }
            binding.textViewBtnNext4Grey.visibility = View.INVISIBLE
            binding.textViewBtnNext4Green.visibility = View.VISIBLE
        } else {
            binding.textViewBtnNext4Grey.visibility = View.VISIBLE
            binding.textViewBtnNext4Green.visibility = View.INVISIBLE
        }
    }
}