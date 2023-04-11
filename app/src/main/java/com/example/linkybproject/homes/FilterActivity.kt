package com.example.linkybproject.homes

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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

        val adapter = FilterDepartmentRecyclerViewAdapter()

        val adapter2 = FilterMbtiRecyclerViewAdapter()

        binding.rvFilterDepartment.adapter = adapter
        binding.rvFilterDepartment.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapter.datalist = mutableListOf(
            Department("정보시스템공학과"),
            Department("컴퓨터공학과"),
            Department("경영학과"), Department("체육학과"),
        )

        binding.rvFilterMbti.adapter = adapter2
        binding.rvFilterMbti.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapter2.datalist = mutableListOf(
            Mbti("ESFP"),
            Mbti("ENTP"), Mbti("ISTP"), Mbti("INFP"), Mbti("ESTJ"),
        )

        binding.btnFilterAll?.setOnClickListener {
            binding.btnFilterAll?.isSelected = binding.btnFilterAll?.isSelected != true
        }

        binding.btnFilterMan?.setOnClickListener {
            binding.btnFilterMan?.isSelected = binding.btnFilterMan?.isSelected != true
        }
        binding.btnFilterWoman?.setOnClickListener {
            binding.btnFilterWoman?.isSelected = binding.btnFilterWoman?.isSelected != true
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
        rangeSlider = binding.filterRangeSlider
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
        // 1. 제외할 학과
        val department: Spinner = binding.departmentSpinner
        ArrayAdapter.createFromResource(
            this,
            R.array.department_list_item,
            R.layout.spinner_signup_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_signup_dropdown)
            department.adapter = adapter
        }
    }

    @SuppressLint("ResourceType")
    private fun setupSpinnerMbti() {
        // 1. 제외할 Mbti
        val Mbti: Spinner = binding.mbtiSpinner
        ArrayAdapter.createFromResource(
            this,
            R.array.mbti_list_item,
            R.layout.spinner_signup_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_signup_dropdown)
            Mbti.adapter = adapter
        }


    }
}