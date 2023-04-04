package com.example.linkybproject.auth.signup

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
import com.example.linkybproject.common.MainActivity
import com.example.linkybproject.databinding.ActivitySignup4Binding
import java.io.File

// 1단계: View Interface를 상속받는다.
class SignupActivity4 : AppCompatActivity(), SignupView {

    private lateinit var binding: ActivitySignup4Binding

    // api 통신
    private lateinit var authCode: String
    private lateinit var userBirth: String
    private lateinit var userEmail: String
    private lateinit var userName: String
    private lateinit var userNickName: String
    private lateinit var userPassword: String

    private var gradeStatus : Boolean = false
    private lateinit var userMajorName : String
    private lateinit var userSchoolName : String
    private lateinit var userStudentNum : String
    private lateinit var schoolImg: File

    private lateinit var profileImg : String
    private  var userInterests : ArrayList<String> = arrayListOf()
    private lateinit var userMBTI : String
    private var userPersonalities : ArrayList<String> = arrayListOf()
    private lateinit var userSelfIntroduction : String
    private lateinit var userSex : String

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignup4Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // back 버튼 (대체 왜 안 뜨는 걸까?)
//        binding.imageViewSignup4Back.setOnClickListener {
//            finish()
//        }
        binding.imageViewSignup4BackBtn.setOnClickListener {
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
        // 성격
        binding.personal1Green.visibility = View.INVISIBLE
        binding.personal2Green.visibility = View.INVISIBLE
        binding.personal3Green.visibility = View.INVISIBLE
        binding.personal4Green.visibility = View.INVISIBLE
        binding.personal5Green.visibility = View.INVISIBLE
        binding.personal6Green.visibility = View.INVISIBLE
        binding.personal7Green.visibility = View.INVISIBLE
        binding.personal8Green.visibility = View.INVISIBLE
        binding.personal9Green.visibility = View.INVISIBLE
        binding.personal10Green.visibility = View.INVISIBLE
        binding.personal11Green.visibility = View.INVISIBLE
        binding.personal12Green.visibility = View.INVISIBLE
        binding.personal13Green.visibility = View.INVISIBLE
        binding.personal14Green.visibility = View.INVISIBLE
        binding.personal15Green.visibility = View.INVISIBLE
        binding.personal16Green.visibility = View.INVISIBLE
        binding.personal17Green.visibility = View.INVISIBLE
        binding.personal18Green.visibility = View.INVISIBLE
        binding.personal19Green.visibility = View.INVISIBLE
        binding.personal20Green.visibility = View.INVISIBLE
        // 관심사
        binding.interest1Green.visibility = View.INVISIBLE
        binding.interest2Green.visibility = View.INVISIBLE
        binding.interest3Green.visibility = View.INVISIBLE
        binding.interest4Green.visibility = View.INVISIBLE
        binding.interest5Green.visibility = View.INVISIBLE
        binding.interest6Green.visibility = View.INVISIBLE
        binding.interest7Green.visibility = View.INVISIBLE
        binding.interest8Green.visibility = View.INVISIBLE
        binding.interest9Green.visibility = View.INVISIBLE
        binding.interest10Green.visibility = View.INVISIBLE
        binding.interest11Green.visibility = View.INVISIBLE
        binding.interest12Green.visibility = View.INVISIBLE
        binding.interest13Green.visibility = View.INVISIBLE
        binding.interest14Green.visibility = View.INVISIBLE
        binding.interest15Green.visibility = View.INVISIBLE
        binding.interest16Green.visibility = View.INVISIBLE
        binding.interest17Green.visibility = View.INVISIBLE
        binding.interest18Green.visibility = View.INVISIBLE
        binding.interest19Green.visibility = View.INVISIBLE
        binding.interest20Green.visibility = View.INVISIBLE


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
            checkOptions()
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
            checkOptions()
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
            checkOptions()
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
            checkOptions()
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
            checkOptions()
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
            checkOptions()

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
            checkOptions()
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
            checkOptions()
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
        binding.personal1Grey.setOnClickListener {
            binding.personal1Grey.visibility = View.INVISIBLE
            binding.personal1Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal1Green.setOnClickListener {
            binding.personal1Grey.visibility = View.VISIBLE
            binding.personal1Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal2Grey.setOnClickListener {
            binding.personal2Grey.visibility = View.INVISIBLE
            binding.personal2Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal2Green.setOnClickListener {
            binding.personal2Grey.visibility = View.VISIBLE
            binding.personal2Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal3Grey.setOnClickListener {
            binding.personal3Grey.visibility = View.INVISIBLE
            binding.personal3Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal3Green.setOnClickListener {
            binding.personal3Grey.visibility = View.VISIBLE
            binding.personal3Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal4Grey.setOnClickListener {
            binding.personal4Grey.visibility = View.INVISIBLE
            binding.personal4Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal4Green.setOnClickListener {
            binding.personal4Grey.visibility = View.VISIBLE
            binding.personal4Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal5Grey.setOnClickListener {
            binding.personal5Grey.visibility = View.INVISIBLE
            binding.personal5Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal5Green.setOnClickListener {
            binding.personal5Grey.visibility = View.VISIBLE
            binding.personal5Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal6Grey.setOnClickListener {
            binding.personal6Grey.visibility = View.INVISIBLE
            binding.personal6Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal6Green.setOnClickListener {
            binding.personal6Grey.visibility = View.VISIBLE
            binding.personal6Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal7Grey.setOnClickListener {
            binding.personal7Grey.visibility = View.INVISIBLE
            binding.personal7Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal7Green.setOnClickListener {
            binding.personal7Grey.visibility = View.VISIBLE
            binding.personal7Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal8Grey.setOnClickListener {
            binding.personal8Grey.visibility = View.INVISIBLE
            binding.personal8Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal8Green.setOnClickListener {
            binding.personal8Grey.visibility = View.VISIBLE
            binding.personal8Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal9Grey.setOnClickListener {
            binding.personal9Grey.visibility = View.INVISIBLE
            binding.personal9Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal9Green.setOnClickListener {
            binding.personal9Grey.visibility = View.VISIBLE
            binding.personal9Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal10Grey.setOnClickListener {
            binding.personal10Grey.visibility = View.INVISIBLE
            binding.personal10Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal10Green.setOnClickListener {
            binding.personal10Grey.visibility = View.VISIBLE
            binding.personal10Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal11Grey.setOnClickListener {
            binding.personal11Grey.visibility = View.INVISIBLE
            binding.personal11Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal11Green.setOnClickListener {
            binding.personal11Grey.visibility = View.VISIBLE
            binding.personal11Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal12Grey.setOnClickListener {
            binding.personal12Grey.visibility = View.INVISIBLE
            binding.personal12Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal12Green.setOnClickListener {
            binding.personal12Grey.visibility = View.VISIBLE
            binding.personal12Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal13Grey.setOnClickListener {
            binding.personal13Grey.visibility = View.INVISIBLE
            binding.personal13Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal13Green.setOnClickListener {
            binding.personal13Grey.visibility = View.VISIBLE
            binding.personal13Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal14Grey.setOnClickListener {
            binding.personal14Grey.visibility = View.INVISIBLE
            binding.personal14Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal14Green.setOnClickListener {
            binding.personal14Grey.visibility = View.VISIBLE
            binding.personal14Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal15Grey.setOnClickListener {
            binding.personal15Grey.visibility = View.INVISIBLE
            binding.personal15Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal15Green.setOnClickListener {
            binding.personal15Grey.visibility = View.VISIBLE
            binding.personal15Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal16Grey.setOnClickListener {
            binding.personal16Grey.visibility = View.INVISIBLE
            binding.personal16Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal16Green.setOnClickListener {
            binding.personal16Grey.visibility = View.VISIBLE
            binding.personal16Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal17Grey.setOnClickListener {
            binding.personal17Grey.visibility = View.INVISIBLE
            binding.personal17Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal17Green.setOnClickListener {
            binding.personal17Grey.visibility = View.VISIBLE
            binding.personal17Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal18Grey.setOnClickListener {
            binding.personal18Grey.visibility = View.INVISIBLE
            binding.personal18Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal18Green.setOnClickListener {
            binding.personal18Grey.visibility = View.VISIBLE
            binding.personal18Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal19Grey.setOnClickListener {
            binding.personal19Grey.visibility = View.INVISIBLE
            binding.personal19Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal19Green.setOnClickListener {
            binding.personal19Grey.visibility = View.VISIBLE
            binding.personal19Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.personal20Grey.setOnClickListener {
            binding.personal20Grey.visibility = View.INVISIBLE
            binding.personal20Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.personal20Green.setOnClickListener {
            binding.personal20Grey.visibility = View.VISIBLE
            binding.personal20Green.visibility = View.INVISIBLE
            checkOptions()
        }

        // 5. 관심사
        binding.interest1Grey.setOnClickListener {
            binding.interest1Grey.visibility = View.INVISIBLE
            binding.interest1Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest1Green.setOnClickListener {
            binding.interest1Grey.visibility = View.VISIBLE
            binding.interest1Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest2Grey.setOnClickListener {
            binding.interest2Grey.visibility = View.INVISIBLE
            binding.interest2Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest2Green.setOnClickListener {
            binding.interest2Grey.visibility = View.VISIBLE
            binding.interest2Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest3Grey.setOnClickListener {
            binding.interest3Grey.visibility = View.INVISIBLE
            binding.interest3Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest3Green.setOnClickListener {
            binding.interest3Grey.visibility = View.VISIBLE
            binding.interest3Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest4Grey.setOnClickListener {
            binding.interest4Grey.visibility = View.INVISIBLE
            binding.interest4Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest4Green.setOnClickListener {
            binding.interest4Grey.visibility = View.VISIBLE
            binding.interest4Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest5Grey.setOnClickListener {
            binding.interest5Grey.visibility = View.INVISIBLE
            binding.interest5Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest5Green.setOnClickListener {
            binding.interest5Grey.visibility = View.VISIBLE
            binding.interest5Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest6Grey.setOnClickListener {
            binding.interest6Grey.visibility = View.INVISIBLE
            binding.interest6Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest6Green.setOnClickListener {
            binding.interest6Grey.visibility = View.VISIBLE
            binding.interest6Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest7Grey.setOnClickListener {
            binding.interest7Grey.visibility = View.INVISIBLE
            binding.interest7Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest7Green.setOnClickListener {
            binding.interest7Grey.visibility = View.VISIBLE
            binding.interest7Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest8Grey.setOnClickListener {
            binding.interest8Grey.visibility = View.INVISIBLE
            binding.interest8Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest8Green.setOnClickListener {
            binding.interest8Grey.visibility = View.VISIBLE
            binding.interest8Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest9Grey.setOnClickListener {
            binding.interest9Grey.visibility = View.INVISIBLE
            binding.interest9Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest9Green.setOnClickListener {
            binding.interest9Grey.visibility = View.VISIBLE
            binding.interest9Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest10Grey.setOnClickListener {
            binding.interest10Grey.visibility = View.INVISIBLE
            binding.interest10Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest10Green.setOnClickListener {
            binding.interest10Grey.visibility = View.VISIBLE
            binding.interest10Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest11Grey.setOnClickListener {
            binding.interest11Grey.visibility = View.INVISIBLE
            binding.interest11Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest11Green.setOnClickListener {
            binding.interest11Grey.visibility = View.VISIBLE
            binding.interest11Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest12Grey.setOnClickListener {
            binding.interest12Grey.visibility = View.INVISIBLE
            binding.interest12Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest12Green.setOnClickListener {
            binding.interest12Grey.visibility = View.VISIBLE
            binding.interest12Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest13Grey.setOnClickListener {
            binding.interest13Grey.visibility = View.INVISIBLE
            binding.interest13Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest13Green.setOnClickListener {
            binding.interest13Grey.visibility = View.VISIBLE
            binding.interest13Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest14Grey.setOnClickListener {
            binding.interest14Grey.visibility = View.INVISIBLE
            binding.interest14Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest14Green.setOnClickListener {
            binding.interest14Grey.visibility = View.VISIBLE
            binding.interest14Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest15Grey.setOnClickListener {
            binding.interest15Grey.visibility = View.INVISIBLE
            binding.interest15Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest15Green.setOnClickListener {
            binding.interest15Grey.visibility = View.VISIBLE
            binding.interest15Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest16Grey.setOnClickListener {
            binding.interest16Grey.visibility = View.INVISIBLE
            binding.interest16Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest16Green.setOnClickListener {
            binding.interest16Grey.visibility = View.VISIBLE
            binding.interest16Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest17Grey.setOnClickListener {
            binding.interest17Grey.visibility = View.INVISIBLE
            binding.interest17Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest17Green.setOnClickListener {
            binding.interest17Grey.visibility = View.VISIBLE
            binding.interest17Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest18Grey.setOnClickListener {
            binding.interest18Grey.visibility = View.INVISIBLE
            binding.interest18Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest18Green.setOnClickListener {
            binding.interest18Grey.visibility = View.VISIBLE
            binding.interest18Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest19Grey.setOnClickListener {
            binding.interest19Grey.visibility = View.INVISIBLE
            binding.interest19Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest19Green.setOnClickListener {
            binding.interest19Grey.visibility = View.VISIBLE
            binding.interest19Green.visibility = View.INVISIBLE
            checkOptions()
        }

        binding.interest20Grey.setOnClickListener {
            binding.interest20Grey.visibility = View.INVISIBLE
            binding.interest20Green.visibility = View.VISIBLE
            checkOptions()
        }
        binding.interest20Green.setOnClickListener {
            binding.interest20Grey.visibility = View.VISIBLE
            binding.interest20Green.visibility = View.INVISIBLE
            checkOptions()
        }

        // 6. 소개
        binding.editTextSignupIntro.addTextChangedListener(
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


        // 7. 시작하기 버튼
        binding.textViewBtnNext5Green.setOnClickListener {
            if (binding.imageViewSignup4Profile1Green.visibility == View.VISIBLE) {
                profileImg = "https://linkyb-bucket.s3.ap-northeast-2.amazonaws.com/images/profileImg/W3.svg"
            } else if (binding.imageViewSignup4Profile2Green.visibility == View.VISIBLE) {
                profileImg = "https://linkyb-bucket.s3.ap-northeast-2.amazonaws.com/images/profileImg/M11.svg"
            } else if (binding.imageViewSignup4Profile3Green.visibility == View.VISIBLE) {
                profileImg = "https://linkyb-bucket.s3.ap-northeast-2.amazonaws.com/images/profileImg/M21.svg"
            } else if (binding.imageViewSignup4Profile4Green.visibility == View.VISIBLE) {
                profileImg = "https://linkyb-bucket.s3.ap-northeast-2.amazonaws.com/images/profileImg/W41.svg"
            }
            if (binding.textViewBtnMaleGreen.visibility == View.VISIBLE) {
                userSex = binding.textViewBtnMaleGreen.text.toString()
            } else if (binding.textViewBtnFemaleGreen.visibility == View.VISIBLE) {
                userSex = binding.textViewBtnFemaleGreen.text.toString()
            }
            userMBTI = binding.spinnerMbti.selectedItem.toString()
            if (binding.personal1Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal1Green.text.toString()))
                userPersonalities.add(binding.personal1Green.text.toString())
            }
            if (binding.personal2Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal2Green.text.toString())
//                userPersonalities.add(UserPersonality(binding.personal2Green.text.toString()))
            }
            if (binding.personal3Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal12Green.text.toString()))
                userPersonalities.add(binding.personal3Green.text.toString())
            }
            if (binding.personal4Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal4Green.text.toString()))
                userPersonalities.add(binding.personal4Green.text.toString())
            }
            if (binding.personal5Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal5Green.text.toString()))
                userPersonalities.add(binding.personal5Green.text.toString())
            }
            if (binding.personal6Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal6Green.text.toString()))
                userPersonalities.add(binding.personal6Green.text.toString())
            }
            if (binding.personal7Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal7Green.text.toString()))
                userPersonalities.add(binding.personal7Green.text.toString())
            }
            if (binding.personal8Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal8Green.text.toString()))
                userPersonalities.add(binding.personal8Green.text.toString())
            }
            if (binding.personal9Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal9Green.text.toString()))
                userPersonalities.add(binding.personal9Green.text.toString())
            }
            if (binding.personal10Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal10Green.text.toString()))
                userPersonalities.add(binding.personal10Green.text.toString())
            }
            if (binding.personal11Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal11Green.text.toString()))
                userPersonalities.add(binding.personal11Green.text.toString())
            }
            if (binding.personal12Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal12Green.text.toString()))
                userPersonalities.add(binding.personal12Green.text.toString())
            }
            if (binding.personal13Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal13Green.text.toString()))
                userPersonalities.add(binding.personal13Green.text.toString())
            }
            if (binding.personal14Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal14Green.text.toString()))
                userPersonalities.add(binding.personal14Green.text.toString())
            }
            if (binding.personal15Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal15Green.text.toString()))
                userPersonalities.add(binding.personal15Green.text.toString())
            }
            if (binding.personal16Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal16Green.text.toString()))
                userPersonalities.add(binding.personal16Green.text.toString())
            }
            if (binding.personal17Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal17Green.text.toString()))
                userPersonalities.add(binding.personal17Green.text.toString())
            }
            if (binding.personal18Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal18Green.text.toString()))
                userPersonalities.add(binding.personal18Green.text.toString())
            }
            if (binding.personal19Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal19Green.text.toString()))
                userPersonalities.add(binding.personal19Green.text.toString())
            }
            if (binding.personal20Green.visibility == View.VISIBLE) {
//                userPersonalities.add(UserPersonality(binding.personal20Green.text.toString()))
                userPersonalities.add(binding.personal20Green.text.toString())
            }
            if (binding.interest1Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest1Green.text.toString()))
                userInterests.add(binding.interest1Green.text.toString())
            }
            if (binding.interest2Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest2Green.text.toString()))
                userInterests.add(binding.interest2Green.text.toString())
            }
            if (binding.interest3Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest3Green.text.toString()))
                userInterests.add(binding.interest3Green.text.toString())
            }
            if (binding.interest4Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest4Green.text.toString()))
                userInterests.add(binding.interest4Green.text.toString())
            }
            if (binding.interest5Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest5Green.text.toString()))
                userInterests.add(binding.interest5Green.text.toString())
            }
            if (binding.interest6Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest6Green.text.toString()))
                userInterests.add(binding.interest6Green.text.toString())
            }
            if (binding.interest7Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest7Green.text.toString()))
                userInterests.add(binding.interest7Green.text.toString())
            }
            if (binding.interest8Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest8Green.text.toString()))
                userInterests.add(binding.interest8Green.text.toString())
            }
            if (binding.interest9Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest9Green.text.toString()))
                userInterests.add(binding.interest9Green.text.toString())
            }
            if (binding.interest10Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest10Green.text.toString()))
                userInterests.add(binding.interest10Green.text.toString())
            }
            if (binding.interest11Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest11Green.text.toString()))
                userInterests.add(binding.interest11Green.text.toString())
            }
            if (binding.interest12Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest12Green.text.toString()))
                userInterests.add(binding.interest12Green.text.toString())
            }
            if (binding.interest13Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest13Green.text.toString()))
                userInterests.add(binding.interest13Green.text.toString())
            }
            if (binding.interest14Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest14Green.text.toString()))
                userInterests.add(binding.interest14Green.text.toString())
            }
            if (binding.interest15Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest15Green.text.toString()))
                userInterests.add(binding.interest15Green.text.toString())
            }
            if (binding.interest16Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest16Green.text.toString()))
                userInterests.add(binding.interest16Green.text.toString())
            }
            if (binding.interest17Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest17Green.text.toString()))
                userInterests.add(binding.interest17Green.text.toString())
            }
            if (binding.interest18Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest18Green.text.toString()))
                userInterests.add(binding.interest18Green.text.toString())
            }
            if (binding.interest19Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest19Green.text.toString()))
                userInterests.add(binding.interest19Green.text.toString())
            }
            if (binding.interest20Green.visibility == View.VISIBLE) {
//                userInterests.add(UserInterest(binding.interest20Green.text.toString()))
                userInterests.add(binding.interest20Green.text.toString())
            }
            userSelfIntroduction = binding.editTextSignupIntro.text.toString()

            val extras = intent.extras
            authCode = extras?.get("authCode") as String
            userBirth = extras?.get("userBirth") as String
            userEmail = extras?.get("userEmail") as String
            userName = extras?.get("userName") as String
            userNickName = extras?.get("userNickName") as String
            userPassword = extras?.get("userPassword") as String

            gradeStatus = extras?.get("gradeStatus") as Boolean
            userMajorName = extras?.get("userMajorName") as String
            userSchoolName = extras?.get("userSchoolName") as String
            userStudentNum = extras?.get("userStudentNum") as String
            schoolImg = extras?.get("schoolImg") as File


            Log.d("authCode", authCode)
            Log.d("userBirth", userBirth)
            Log.d("userEmail", userEmail)
            Log.d("userName", userName)
            Log.d("userNickName", userNickName)
            Log.d("userPassword", userPassword)

            Log.d("gradeStatus", gradeStatus.toString())
            Log.d("userMajorName", userMajorName)
            Log.d("userSchoolName", userSchoolName)
            Log.d("userStudentNum", userStudentNum)
            Log.d("schoolImg", schoolImg.toString())

            Log.d("userInterests", userInterests.toString())
            Log.d("userMBTI", userMBTI)
            Log.d("userPersonalities", userPersonalities.toString())
            Log.d("userSelfIntroduction", userSelfIntroduction)
            Log.d("userSex", userSex)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("authCode", authCode)
            intent.putExtra("userBirth", userBirth)
            intent.putExtra("userEmail", userEmail)
            intent.putExtra("userName", userName)
            intent.putExtra("userNickName", userNickName)
            intent.putExtra("userPassword", userPassword)
            intent.putExtra("gradeStatus", gradeStatus)
            intent.putExtra("userMajorName", userMajorName)
            intent.putExtra("userSchoolName", userSchoolName)
            intent.putExtra("userStudentNum", userStudentNum)
            intent.putExtra("schoolImg", schoolImg)

            intent.putExtra("userInterests", userInterests)
            intent.putExtra("userMBTI", userMBTI)
            intent.putExtra("userPersonalities", userPersonalities)
            intent.putExtra("userSelfIntroduction", userSelfIntroduction)
            intent.putExtra("userSex", userSex)
            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
//            startActivity(intent)


            signup()
        }
    }

    // 8. 기본 정보 입력 완료 확인 함수
    private fun checkOptions() {
        // textViewBtnCheckAuthGrey 추가 (여기 다시 검토 - 임시)
        if((binding.imageViewSignup4Profile1Green.visibility == View.VISIBLE ||
                    binding.imageViewSignup4Profile2Green.visibility == View.VISIBLE ||
                    binding.imageViewSignup4Profile3Green.visibility == View.VISIBLE ||
                    binding.imageViewSignup4Profile4Green.visibility == View.VISIBLE) &&
            (binding.textViewBtnFemaleGreen.visibility == View.VISIBLE ||
                    binding.textViewBtnMaleGreen.visibility == View.VISIBLE) &&
            binding.spinnerMbti.selectedItem.toString().length < 10 &&
            (binding.personal1Green.visibility == View.VISIBLE || binding.personal2Green.visibility == View.VISIBLE ||
                    binding.personal3Green.visibility == View.VISIBLE || binding.personal4Green.visibility == View.VISIBLE ||
                    binding.personal5Green.visibility == View.VISIBLE || binding.personal6Green.visibility == View.VISIBLE ||
                    binding.personal7Green.visibility == View.VISIBLE || binding.personal8Green.visibility == View.VISIBLE ||
                    binding.personal9Green.visibility == View.VISIBLE || binding.personal10Green.visibility == View.VISIBLE ||
                    binding.personal11Green.visibility == View.VISIBLE || binding.personal12Green.visibility == View.VISIBLE ||
                    binding.personal13Green.visibility == View.VISIBLE || binding.personal14Green.visibility == View.VISIBLE ||
                    binding.personal15Green.visibility == View.VISIBLE || binding.personal16Green.visibility == View.VISIBLE ||
                    binding.personal17Green.visibility == View.VISIBLE || binding.personal18Green.visibility == View.VISIBLE ||
                    binding.personal19Green.visibility == View.VISIBLE || binding.personal20Green.visibility == View.VISIBLE) &&
            (binding.interest1Green.visibility == View.VISIBLE || binding.interest2Green.visibility == View.VISIBLE ||
                    binding.interest3Green.visibility == View.VISIBLE || binding.interest1Green.visibility == View.VISIBLE ||
                    binding.interest1Green.visibility == View.VISIBLE || binding.interest4Green.visibility == View.VISIBLE ||
                    binding.interest5Green.visibility == View.VISIBLE || binding.interest6Green.visibility == View.VISIBLE ||
                    binding.interest7Green.visibility == View.VISIBLE || binding.interest8Green.visibility == View.VISIBLE ||
                    binding.interest9Green.visibility == View.VISIBLE || binding.interest10Green.visibility == View.VISIBLE ||
                    binding.interest11Green.visibility == View.VISIBLE || binding.interest12Green.visibility == View.VISIBLE ||
                    binding.interest13Green.visibility == View.VISIBLE || binding.interest14Green.visibility == View.VISIBLE ||
                    binding.interest15Green.visibility == View.VISIBLE || binding.interest16Green.visibility == View.VISIBLE ||
                    binding.interest17Green.visibility == View.VISIBLE || binding.interest18Green.visibility == View.VISIBLE ||
                    binding.interest19Green.visibility == View.VISIBLE || binding.interest20Green.visibility == View.VISIBLE) &&
            binding.editTextSignupIntro.text.toString() != "") {

            binding.textViewBtnNext5Grey.visibility = View.INVISIBLE
            binding.textViewBtnNext5Green.visibility = View.VISIBLE
        } else {
            binding.textViewBtnNext5Green.visibility = View.INVISIBLE
            binding.textViewBtnNext5Grey.visibility = View.VISIBLE
        }
    }

    private fun getSignupRequest(): SignupRequest {

        return SignupRequest(
            UserSignupReq(authCode, gradeStatus, profileImg, userBirth, userEmail, userInterests, userMBTI, userMajorName, userName, userNickName, userPassword, userPersonalities, userSchoolName, userSelfIntroduction, userSex, userStudentNum),
            SchoolImg(schoolImg))
    }

    private fun signup() {
        // 2단계
        val signupService = SignupService()
        signupService.setSignUpView(this)
        signupService.signup(getSignupRequest())
    }

    // 1단계: 상속받은거 정의
    override fun onSignupSuccess() {
        Toast.makeText(this, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show()
    }

    override fun onSignupFailure() {
        TODO("Not yet implemented")
    }
}