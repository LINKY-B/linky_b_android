package com.example.linkybproject.auth.signup

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivitySignup3Binding
import java.io.File

class SignupActivity3 : AppCompatActivity() {

    private lateinit var binding : ActivitySignup3Binding

    // SignupActivity4 로 가지고 넘어갈 값. 회원가입 끝에 서버에 넘길 데이터
    private lateinit var userSchoolName : String
    private lateinit var userMajorName : String
    private lateinit var userStudentNum : String
    private var gradeStatus : Boolean = false

    // 갤러리 이미지 업로드
    companion object {
        const val REVIEW_MIN_LENGTH = 10
        const val REQ_GALLERY = 1 // 갤러리 권한 요청

        // api 호출 시 parameter key 값
        const val PARAM_KEY_IMAGE = "image"
        const val PARAM_KEY_PRODUCT_ID = "product_id"
        const val PARAM_KEY_REVIEW = "review_content"
        const val PARAM_KEY_RATING = "rating"
    }

    private lateinit var imageFile: File // 자료형 틀릴 수도 있음
    // 이미지를 결과 값으로 받는 변수
    private val imageResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        result -> if(result.resultCode == RESULT_OK) {
            val imageUri = result.data?.data
            imageUri?.let {
                imageFile = File(getRealPathFromURI(it)) // 서버 업로드 위해 파일 형태로 변환
                Glide.with(this)
                    .load(imageUri)
                    .fitCenter()
                    .apply(RequestOptions().override(500,500))
                    .into(binding.imageViewUploaded) // 이미지 불러옴
            }
        }
    }

    // 이미지 실제 경로 반환
    fun getRealPathFromURI(uri: Uri): String {
        val buildName = Build.MANUFACTURER
        if(buildName.equals("Xiaomi")) {
            return uri.path!!
        }

        var columnIndex = 0
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(uri, proj, null, null, null)
        if (cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        val result = cursor.getString(columnIndex)
        cursor.close()
        binding.imageViewUploaded.visibility = View.VISIBLE
        return result
    }

    // 갤러리 부르는 메소드
    private fun selectGallery() {
        val writePermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val readPermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)

        if (writePermission == PackageManager.PERMISSION_DENIED || readPermission == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE), REQ_GALLERY)
        } else {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")

            imageResult.launch(intent)
        }
    }


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
//        binding.editTextSignup3Email.visibility = View.INVISIBLE
//        binding.textViewSignup3BtnGetAuthGreen.visibility = View.INVISIBLE
//        binding.textViewSignup3BtnGetAuthGrey.visibility = View.INVISIBLE
//        binding.textViewSignup3AuthEmailError.visibility = View.INVISIBLE
//        binding.editTextSignup3EmailAuth.visibility = View.INVISIBLE
//        binding.textViewSignupTimer.visibility = View.INVISIBLE
//        binding.textViewSignup3BtnCheckAuthGreen.visibility = View.INVISIBLE
//        binding.textViewSignup3BtnCheckAuthGrey.visibility = View.INVISIBLE
//        binding.textViewSignup3AuthCheckError.visibility = View.INVISIBLE
        // 졸업생
        binding.textViewSignup3AuthGrad.visibility = View.INVISIBLE
        binding.textViewSignup3AuthGradExplain.visibility = View.INVISIBLE
        // 공통
        binding.imageViewUploadImage.visibility = View.INVISIBLE
        binding.imageViewUploaded.visibility = View.INVISIBLE


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
//                    binding.editTextSignup3Email.visibility = View.VISIBLE
//                    binding.textViewSignup3BtnGetAuthGreen.visibility = View.VISIBLE
//                    binding.textViewSignup3BtnGetAuthGrey.visibility = View.VISIBLE
////                    binding.textViewSignup3AuthEmailError.visibility = View.VISIBLE
//                    binding.editTextSignup3EmailAuth.visibility = View.VISIBLE
//                    binding.textViewSignupTimer.visibility = View.VISIBLE
//                    binding.textViewSignup3BtnCheckAuthGreen.visibility = View.VISIBLE
//                    binding.textViewSignup3BtnCheckAuthGrey.visibility = View.VISIBLE
////                    binding.textViewSignup3AuthCheckError.visibility = View.VISIBLE

                    binding.textViewSignup3AuthGrad.visibility = View.INVISIBLE
                    binding.textViewSignup3AuthGradExplain.visibility = View.VISIBLE

                    binding.imageViewUploadImage.visibility = View.VISIBLE
//                    binding.imageViewUploaded.visibility = View.VISIBLE

                    gradeStatus = false
                } else if (flag == "졸업") {
                    binding.textViewSignup3AuthExplain.visibility = View.INVISIBLE
                    // 졸업생
                    binding.textViewSignup3AuthStu.visibility = View.INVISIBLE
//                    binding.editTextSignup3Email.visibility = View.INVISIBLE
//                    binding.textViewSignup3BtnGetAuthGreen.visibility = View.INVISIBLE
//                    binding.textViewSignup3BtnGetAuthGrey.visibility = View.INVISIBLE
//                    binding.textViewSignup3AuthEmailError.visibility = View.INVISIBLE
//                    binding.editTextSignup3EmailAuth.visibility = View.INVISIBLE
//                    binding.textViewSignupTimer.visibility = View.INVISIBLE
//                    binding.textViewSignup3BtnCheckAuthGreen.visibility = View.INVISIBLE
//                    binding.textViewSignup3BtnCheckAuthGrey.visibility = View.INVISIBLE
//                    binding.textViewSignup3AuthCheckError.visibility = View.INVISIBLE

                    binding.textViewSignup3AuthGrad.visibility = View.VISIBLE
                    binding.textViewSignup3AuthGradExplain.visibility = View.VISIBLE

                    binding.imageViewUploadImage.visibility = View.VISIBLE
//                    binding.imageViewUploaded.visibility = View.VISIBLE

                    gradeStatus = true
                } else {
                    binding.textViewSignup3AuthExplain.visibility = View.VISIBLE
                    // 재학생
                    binding.textViewSignup3AuthStu.visibility = View.INVISIBLE
//                    binding.editTextSignup3Email.visibility = View.INVISIBLE
//                    binding.textViewSignup3BtnGetAuthGreen.visibility = View.INVISIBLE
//                    binding.textViewSignup3BtnGetAuthGrey.visibility = View.INVISIBLE
//                    binding.textViewSignup3AuthEmailError.visibility = View.INVISIBLE
//                    binding.editTextSignup3EmailAuth.visibility = View.INVISIBLE
//                    binding.textViewSignupTimer.visibility = View.INVISIBLE
//                    binding.textViewSignup3BtnCheckAuthGreen.visibility = View.INVISIBLE
//                    binding.textViewSignup3BtnCheckAuthGrey.visibility = View.INVISIBLE
//                    binding.textViewSignup3AuthCheckError.visibility = View.INVISIBLE
                    // 졸업생
                    binding.textViewSignup3AuthGrad.visibility = View.INVISIBLE
                    binding.textViewSignup3AuthGradExplain.visibility = View.INVISIBLE

                    binding.imageViewUploadImage.visibility = View.INVISIBLE
                    binding.imageViewUploaded.visibility = View.INVISIBLE
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                checkOptions()
            }
        }

        // 4-1. 미졸업
        // 4-2. 졸업
        // 졸업 부분 인증하고 밑에 버튼 뷰 처리까지 해야 함.
        binding.imageViewUploadImage.setOnClickListener {
            selectGallery()
        }

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