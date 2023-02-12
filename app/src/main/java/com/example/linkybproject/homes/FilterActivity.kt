package com.example.linkybproject.homes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityFilterBinding
import com.google.android.material.slider.RangeSlider

class FilterActivity :AppCompatActivity() {
    private lateinit var binding: ActivityFilterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFilterBinding.inflate(layoutInflater)
        binding.ibtnFilterArrow.setOnClickListener {
            finish()
        }



        setContentView(binding.root)
        setupSpinnerDepartment()
        setupSpinnerMbti()
        rangeSliderInit()

    }
    //filteRagneSlider
    private lateinit var rangeSlider: RangeSlider

    //초기값 설정
    private fun rangeSliderInit() {
        rangeSlider =  binding.filterRangeSlider
        //최솟값
        rangeSlider.valueFrom = 10f
        //최댓값
        rangeSlider.valueTo = 23f
        //스탭사이즈
        rangeSlider.stepSize = 1f
        //바의 시작값을 ( , ) 으로 범위가 잡힘
        rangeSlider.setValues(15f, 19f)

        //rangeSlider 상태의 변화를 감지하는 리스너
        rangeSlider.addOnSliderTouchListener(rangeSliderTouchListener)
    }

    // rangeSlider 사용할 때 사용되는 리스너
    private val rangeSliderTouchListener = object : RangeSlider.OnSliderTouchListener {
        //바가 시작하면 동작하는 부분
        override fun onStartTrackingTouch(slider: RangeSlider) {
        }

        // 유저가 바에서 손을 떼었을 때 동작하는 함수
        //slider.values() 값이 [0.0,5.0]처럼 배열로 값이 들어있다
        override fun onStopTrackingTouch(slider: RangeSlider) {
            val minValue = slider.values[0].toInt().toString()
            val maxValue = slider.values[1].toInt().toString()
            Log.d("DualThumbSeekbar", "onStopTrackingTouch minPrice : $minValue")
            Log.d("DualThumbSeekbar", "onStopTrackingTouch maxPrice : $maxValue")
        }
    }



    @SuppressLint("ResourceType")
    private fun setupSpinnerDepartment() {
        val department = resources.getStringArray(R.array.department_list_item)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,department)
        binding.departmentSpinner.adapter = adapter
    }


    @SuppressLint("ResourceType")
    private fun setupSpinnerMbti() {
        val mbti = resources.getStringArray(R.array.mbti_list_item)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mbti)
        binding.mbtiSpinner.adapter = adapter
    }




}