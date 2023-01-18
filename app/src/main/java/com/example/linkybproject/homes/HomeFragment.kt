package com.example.linkybproject.homes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.linkybproject.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout

class HomeFragment:Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeAdapter

    val mDatas = mutableListOf<UserData>()

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root

        initDogRecyclerView()
        initializelist()

    }

    fun initDogRecyclerView() {
        val adapter = HomeAdapter() //어댑터 객체 만듦
        adapter.datalist = mDatas //데이터 넣어줌
        binding.rvHome.adapter = adapter //리사이클러뷰에 어댑터 연결
        binding.rvHome.layoutManager = LinearLayoutManager(activity) //레이아웃 매니저 연결
    }

    fun initializelist() { //임의로 데이터 넣어서 만들어봄
        with(mDatas) {
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))


        }
    }

}
