package com.example.linkybproject.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.linkybproject.MainActivity
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivitySignup4Binding

class SignupActivity4 : AppCompatActivity() {

    private lateinit var binding: ActivitySignup4Binding

    // api 통신
    private lateinit var userProfileInfo : String
    private lateinit var userSex : String
    private lateinit var userMBTI : String
    private lateinit var userPersonality : String
    private lateinit var userInterest : String
    private lateinit var userSelfIntroduction : String

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignup4Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // back 버튼
        binding.imageViewSignup4Back.setOnClickListener {
            finish()
        }

        // 버튼 비활성화 및 뷰 안 보이게 설정
        binding.textViewBtnNext5Grey.isEnabled = false
        // 프로필
        binding.imageViewSignup4Profile1Green.visibility = View.INVISIBLE
        binding.imageViewSignup4Profile2Green.visibility = View.INVISIBLE
        binding.imageViewSignup4Profile3Green.visibility = View.INVISIBLE
        binding.imageViewSignup4Profile4Green.visibility = View.INVISIBLE
        // 성별
        binding.textViewBtnFemaleGreen.visibility = View.INVISIBLE
        binding.textViewBtnMaleGreen.visibility = View.INVISIBLE

        // 1. 프로필
        binding.imageViewSignup4Profile1.setOnClickListener {
            if (binding.imageViewSignup4Profile1Green.visibility == View.INVISIBLE) {
                if (binding.imageViewSignup4Profile2Green.visibility == View.VISIBLE) {
                    binding.imageViewSignup4Profile2Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewSignup4Profile3Green.visibility == View.VISIBLE) {
                    binding.imageViewSignup4Profile3Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewSignup4Profile4Green.visibility == View.VISIBLE) {
                    binding.imageViewSignup4Profile4Grey.visibility = android.view.View.VISIBLE
                }
                binding.imageViewSignup4Profile1Green.visibility = View.VISIBLE
                binding.imageViewSignup4Profile2Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile3Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile4Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile1Grey.visibility = View.INVISIBLE
            } else if (binding.imageViewSignup4Profile1Green.visibility == View.VISIBLE){
                binding.imageViewSignup4Profile1Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile1Grey.visibility = View.VISIBLE
                binding.imageViewSignup4Profile2Grey.visibility = View.VISIBLE
                binding.imageViewSignup4Profile3Grey.visibility = View.VISIBLE
                binding.imageViewSignup4Profile4Grey.visibility = View.VISIBLE
            }
        }
        binding.imageViewSignup4Profile2.setOnClickListener {
            if (binding.imageViewSignup4Profile2Green.visibility == View.INVISIBLE) {
                if (binding.imageViewSignup4Profile1Green.visibility == View.VISIBLE) {
                    binding.imageViewSignup4Profile1Grey.visibility = View.VISIBLE
                } else if (binding.imageViewSignup4Profile4Green.visibility == View.VISIBLE) {
                    binding.imageViewSignup4Profile4Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewSignup4Profile3Green.visibility == View.VISIBLE) {
                    binding.imageViewSignup4Profile3Grey.visibility = android.view.View.VISIBLE
                }
                binding.imageViewSignup4Profile2Green.visibility = View.VISIBLE
                binding.imageViewSignup4Profile1Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile3Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile4Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile2Grey.visibility = View.INVISIBLE
            } else if (binding.imageViewSignup4Profile2Green.visibility == View.VISIBLE){
                binding.imageViewSignup4Profile2Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile2Grey.visibility = View.VISIBLE
                binding.imageViewSignup4Profile1Grey.visibility = View.VISIBLE
                binding.imageViewSignup4Profile3Grey.visibility = View.VISIBLE
                binding.imageViewSignup4Profile4Grey.visibility = View.VISIBLE
            }
        }
        binding.imageViewSignup4Profile3.setOnClickListener {
            if (binding.imageViewSignup4Profile3Green.visibility == View.INVISIBLE) {
                if (binding.imageViewSignup4Profile1Green.visibility == View.VISIBLE) {
                    binding.imageViewSignup4Profile1Grey.visibility = View.VISIBLE
                } else if (binding.imageViewSignup4Profile2Green.visibility == View.VISIBLE) {
                    binding.imageViewSignup4Profile2Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewSignup4Profile4Green.visibility == View.VISIBLE) {
                    binding.imageViewSignup4Profile4Grey.visibility = android.view.View.VISIBLE
                }
                binding.imageViewSignup4Profile3Green.visibility = View.VISIBLE
                binding.imageViewSignup4Profile2Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile1Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile4Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile3Grey.visibility = View.INVISIBLE
            } else if (binding.imageViewSignup4Profile3Green.visibility == View.VISIBLE){
                binding.imageViewSignup4Profile3Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile3Grey.visibility = View.VISIBLE
                binding.imageViewSignup4Profile2Grey.visibility = View.VISIBLE
                binding.imageViewSignup4Profile1Grey.visibility = View.VISIBLE
                binding.imageViewSignup4Profile4Grey.visibility = View.VISIBLE
            }
        }
        binding.imageViewSignup4Profile4.setOnClickListener {
            if (binding.imageViewSignup4Profile4Green.visibility == View.INVISIBLE) {
                if (binding.imageViewSignup4Profile1Green.visibility == View.VISIBLE) {
                    binding.imageViewSignup4Profile1Grey.visibility = View.VISIBLE
                } else if (binding.imageViewSignup4Profile2Green.visibility == View.VISIBLE) {
                    binding.imageViewSignup4Profile2Grey.visibility = android.view.View.VISIBLE
                } else if (binding.imageViewSignup4Profile3Green.visibility == View.VISIBLE) {
                    binding.imageViewSignup4Profile3Grey.visibility = android.view.View.VISIBLE
                }
                binding.imageViewSignup4Profile4Green.visibility = View.VISIBLE
                binding.imageViewSignup4Profile2Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile3Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile1Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile4Grey.visibility = View.INVISIBLE
            } else if (binding.imageViewSignup4Profile4Green.visibility == View.VISIBLE){
                binding.imageViewSignup4Profile4Green.visibility = View.INVISIBLE
                binding.imageViewSignup4Profile4Grey.visibility = View.VISIBLE
                binding.imageViewSignup4Profile2Grey.visibility = View.VISIBLE
                binding.imageViewSignup4Profile3Grey.visibility = View.VISIBLE
                binding.imageViewSignup4Profile1Grey.visibility = View.VISIBLE
            }
        }

        // 2. 성별
        binding.textViewBtnMaleGrey.setOnClickListener {
            if (binding.textViewBtnFemaleGreen.visibility == View.VISIBLE) {
                binding.textViewBtnFemaleGreen.visibility = View.INVISIBLE
                binding.textViewBtnFemaleGrey.visibility = View.VISIBLE
                binding.textViewBtnMaleGrey.visibility = View.INVISIBLE
                binding.textViewBtnMaleGreen.visibility = View.VISIBLE
            } else {
                binding.textViewBtnMaleGrey.visibility = View.INVISIBLE
                binding.textViewBtnMaleGreen.visibility = View.VISIBLE
            }
        }
        binding.textViewBtnMaleGreen.setOnClickListener {
            if (binding.textViewBtnFemaleGreen.visibility == View.INVISIBLE) {
                binding.textViewBtnMaleGrey.visibility = View.VISIBLE
                binding.textViewBtnMaleGreen.visibility = View.INVISIBLE
            } else {
                binding.textViewBtnFemaleGreen.visibility = View.INVISIBLE
                binding.textViewBtnFemaleGrey.visibility = View.VISIBLE
                binding.textViewBtnMaleGreen.visibility = View.VISIBLE
                binding.textViewBtnMaleGrey.visibility = View.INVISIBLE
            }
        }
        binding.textViewBtnFemaleGrey.setOnClickListener {
            if (binding.textViewBtnMaleGreen.visibility == View.VISIBLE) {
                binding.textViewBtnMaleGreen.visibility = View.INVISIBLE
                binding.textViewBtnMaleGrey.visibility = View.VISIBLE
                binding.textViewBtnFemaleGrey.visibility = View.INVISIBLE
                binding.textViewBtnFemaleGreen.visibility = View.VISIBLE
            } else {
                binding.textViewBtnFemaleGrey.visibility = View.INVISIBLE
                binding.textViewBtnFemaleGreen.visibility = View.VISIBLE
            }
        }
        binding.textViewBtnFemaleGreen.setOnClickListener {
            if (binding.textViewBtnMaleGreen.visibility == View.INVISIBLE) {
                binding.textViewBtnFemaleGrey.visibility = View.VISIBLE
                binding.textViewBtnFemaleGreen.visibility = View.INVISIBLE
            } else {
                binding.textViewBtnMaleGreen.visibility = View.INVISIBLE
                binding.textViewBtnMaleGrey.visibility = View.VISIBLE
                binding.textViewBtnFemaleGreen.visibility = View.VISIBLE
                binding.textViewBtnFemaleGrey.visibility = View.INVISIBLE
            }
        }

        // 3. MBTI 드롭다운
        val spinnerMbti: Spinner = binding.spinnerMbti
        ArrayAdapter.createFromResource(
            this,
            R.array.signup_mbti,
            R.layout.spinner_signup_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_signup_dropdown)
            spinnerMbti.adapter = adapter
        }

        spinnerMbti.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long
            ) {
                checkOptions()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                checkOptions()
            }
        }

        // 4. 성격
        // 일단 dialog 안 띄우고 이 activity에서 동작하도록 하고 후에 디벨롭시키기


        //
        binding.textViewBtnNext5Green.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    // . 기본 정보 입력 완료 확인 함수
    private fun checkOptions() {
        // textViewBtnCheckAuthGrey 추가 (여기 다시 검토 - 임시)
        if(binding.spinnerMbti.selectedItem.toString().length != 4 ) {

        } else {

        }
    }
}