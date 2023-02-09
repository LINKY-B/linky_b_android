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
        // 버튼 view가 왜 화면 상에서 안 보이는지 모르겠음. 우선 성격 textView 눌렀을 때 선택지 다이얼로그 띄워보기
        binding.textViewSignup4PersonalTitle.setOnClickListener {
            val dialog = PersonalDialog(this)
            dialog.quitInitViews()
            dialog.setOnClickListener(object: PersonalDialog.OnDialogClickListener {
                override fun onClicked(flag: Boolean) {
                    if (flag) {
                        // 원하는 동작 (버튼 누르고 다시 돌아왔을 때인가? -> 맞음)
//                        Toast.makeText(this@SignupActivity4, "돌아옴", Toast.LENGTH_SHORT).show()
                    }
                }

            })
        }

        // activity와 연결하기
//        val personalList = ArrayList<Personal>()
//        // 이 list 값들이 선택한 값들이 되어야 함 (list 값 수정하기)
//        personalList.add(Personal(0, "외향적"))
//        personalList.add(Personal(1, "내향적"))
//        personalList.add(Personal(2, "이성적"))
//        personalList.add(Personal(3, "감성적"))
//        personalList.add(Personal(4, "사교적"))
//        personalList.add(Personal(5, "계획적"))
//        personalList.add(Personal(6, "자유분방"))
//        personalList.add(Personal(7, "독립적"))
//        personalList.add(Personal(8, "주도적"))
//
//        val personalAdapter = SignupPersonalRVAdapter(personalList)
//        binding.recyclerViewSignupPersonal.layoutManager = LinearLayoutManager(this, GridLayoutManager.HORIZONTAL, false)
//        personalAdapter.setPersonalItemClickListener(object : SignupPersonalRVAdapter.PersonalItemClickListener{
//            override fun onItemClick(personal: Personal) {
//                // 클릭했을 때 무엇을 할 지 내용 작성
//            }
//        })
//        binding.recyclerViewSignupPersonal.adapter = personalAdapter
//
//
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