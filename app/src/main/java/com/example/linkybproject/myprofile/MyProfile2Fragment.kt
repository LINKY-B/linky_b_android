package com.example.linkybproject.myprofile

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.linkybproject.common.MainActivity
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentMyprofile2Binding

class MyProfile2Fragment : Fragment() {
    private lateinit var binding: FragmentMyprofile2Binding

    private lateinit var mainActivity : MainActivity

    // api 통신
    private lateinit var userMBTI : String
    private var userPersonalities : ArrayList<String> = arrayListOf()
    private  var userInterests : ArrayList<String> = arrayListOf()
    private lateinit var userSelfIntroduction : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMyprofile2Binding.inflate(inflater, container, false)

        // 뷰 안 보이게 설정
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

        // 수정 버튼
        binding.textViewBtnUpdate.setOnClickListener {

            userMBTI = binding.spinnerMbtiUpdate.selectedItem.toString()
            if (binding.personal1Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal1Green.text.toString())
            }
            if (binding.personal2Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal2Green.text.toString())
            }
            if (binding.personal3Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal3Green.text.toString())
            }
            if (binding.personal4Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal4Green.text.toString())
            }
            if (binding.personal5Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal5Green.text.toString())
            }
            if (binding.personal6Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal6Green.text.toString())
            }
            if (binding.personal7Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal7Green.text.toString())
            }
            if (binding.personal8Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal8Green.text.toString())
            }
            if (binding.personal9Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal9Green.text.toString())
            }
            if (binding.personal10Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal10Green.text.toString())
            }
            if (binding.personal11Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal11Green.text.toString())
            }
            if (binding.personal12Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal12Green.text.toString())
            }
            if (binding.personal13Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal13Green.text.toString())
            }
            if (binding.personal14Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal14Green.text.toString())
            }
            if (binding.personal15Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal15Green.text.toString())
            }
            if (binding.personal16Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal16Green.text.toString())
            }
            if (binding.personal17Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal17Green.text.toString())
            }
            if (binding.personal18Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal18Green.text.toString())
            }
            if (binding.personal19Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal19Green.text.toString())
            }
            if (binding.personal20Green.visibility == View.VISIBLE) {
                userPersonalities.add(binding.personal20Green.text.toString())
            }
            if (binding.interest1Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest1Green.text.toString())
            }
            if (binding.interest2Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest2Green.text.toString())
            }
            if (binding.interest3Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest3Green.text.toString())
            }
            if (binding.interest4Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest4Green.text.toString())
            }
            if (binding.interest5Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest5Green.text.toString())
            }
            if (binding.interest6Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest6Green.text.toString())
            }
            if (binding.interest7Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest7Green.text.toString())
            }
            if (binding.interest8Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest8Green.text.toString())
            }
            if (binding.interest9Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest9Green.text.toString())
            }
            if (binding.interest10Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest10Green.text.toString())
            }
            if (binding.interest11Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest11Green.text.toString())
            }
            if (binding.interest12Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest12Green.text.toString())
            }
            if (binding.interest13Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest13Green.text.toString())
            }
            if (binding.interest14Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest14Green.text.toString())
            }
            if (binding.interest15Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest15Green.text.toString())
            }
            if (binding.interest16Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest16Green.text.toString())
            }
            if (binding.interest17Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest17Green.text.toString())
            }
            if (binding.interest18Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest18Green.text.toString())
            }
            if (binding.interest19Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest19Green.text.toString())
            }
            if (binding.interest20Green.visibility == View.VISIBLE) {
                userInterests.add(binding.interest20Green.text.toString())
            }
            userSelfIntroduction = binding.editTextMyProfile2Intro.text.toString()

            Log.d("userMBTI", userMBTI)
            Log.d("userPersonalities", userPersonalities.toString())
            Log.d("userInterests", userInterests.toString())
            Log.d("userSelfIntroduction", userSelfIntroduction)

            mainActivity.myprofile2Tomyprofil1() // 수정 반영돼서 나와야 함.
        }

        // 수정 1. 소개 글
        binding.editTextMyProfile2Intro.addTextChangedListener(
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

        // 수정 2. MBTI 드롭다운
        val spinnerMbti: Spinner = binding.spinnerMbtiUpdate
        ArrayAdapter.createFromResource(
            mainActivity,
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

        // 수정 3. 성격
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

        // 수정 4. 관심사
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

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    private fun checkOptions() {

    }
    
}