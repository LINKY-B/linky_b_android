package com.example.linkybproject.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivitySignup2Binding
import com.example.linkybproject.databinding.ActivitySignup3Binding

class SignupActivity3 : AppCompatActivity() {

    private lateinit var binding : ActivitySignup3Binding

    // SignupActivity4 로 가지고 넘어갈 값. 회원가입 끝에 서버에 넘길 데이터
    private lateinit var userSchoolName : String
    private lateinit var userMajorName : String
    private lateinit var userStudentNum : String
    private lateinit var gradeStatus : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignup3Binding.inflate(layoutInflater)
        setContentView(binding.root)

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
        binding.editTextSignup3Major.setOnClickListener {

        }

        // 3. 학번 입력
        binding.editTextSignupUniNum.setOnClickListener {

        }

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

        // 5. 학교 정보 입력 완료 -> signupActivity4
        binding.textViewBtnNext4Green.setOnClickListener{
            userSchoolName = binding.spinnerUniv.selectedItem.toString()
            userMajorName = binding.editTextSignup3Major.text.toString()
            userStudentNum = binding.editTextSignupUniNum.text.toString()
            gradeStatus = binding.spinnerGrad.selectedItem.toString()
//            Toast.makeText(this@SignupActivity3, userSchoolName, Toast.LENGTH_SHORT).show()
            Toast.makeText(this@SignupActivity3, userMajorName, Toast.LENGTH_SHORT).show()
//            Toast.makeText(this@SignupActivity3, userStudentNum, Toast.LENGTH_SHORT).show()
//            Toast.makeText(this@SignupActivity3, gradeStatus, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SignupActivity4::class.java)
            // userBasicInfo 객체 만드는 건 의논 후 작성
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
        if(binding.spinnerUniv.selectedItem.toString().length <= 4 &&
                binding.editTextSignup3Major.text.toString() != "" &&
                binding.editTextSignupUniNum.text.toString() != "" &&
                binding.spinnerGrad.selectedItem.toString().length <= 3) {
            // if 문 하나 더 해서 재학생, 졸업생 확인하기
            binding.textViewBtnNext4Grey.visibility = View.INVISIBLE
            binding.textViewBtnNext4Green.visibility = View.VISIBLE
        } else {
            binding.textViewBtnNext4Grey.visibility = View.VISIBLE
            binding.textViewBtnNext4Green.visibility = View.INVISIBLE
        }
    }
}