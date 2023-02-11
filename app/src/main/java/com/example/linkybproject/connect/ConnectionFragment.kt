package com.example.linkybproject.connect

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.FragmentConnectionBinding
import com.example.linkybproject.homes.UserData

class ConnectionFragment : Fragment() {
    private lateinit var binding: FragmentConnectionBinding
    var mainAppActivity: AppCompatActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AppCompatActivity) {
            mainAppActivity = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConnectionBinding.inflate(inflater, container, false)

        binding.btnFullConnectFrom.setOnClickListener {
            val intent = Intent(activity, ConnectFromMeActivity::class.java)
            startActivity(intent)
        }

        val adapter1 = mainAppActivity?.let { ConnectFromRecyclerViewAdapter(it) }


        adapter1?.datalist = mutableListOf(
            ConnectUserData("", "쿼티", 25, "컴퓨터학과", 20, 25, "여자", "MBTI"),
            ConnectUserData("", "에이치", 24, "컴퓨터학과", 20, 24, "여자", "MBTI"),
            ConnectUserData("", "얼리시", 23, "정보시스템공학과", 20, 23, "여자", "MBTI"),
            ConnectUserData("", "리나", 24, "물리학과", 19, 24, "여자", "ESFP"),
            ConnectUserData("", "홍시", 25, "시각디자인학과", 18, 25, "여자", "MBTI")
            )

        binding.connectionList1.adapter = adapter1
        binding.connectionList1.layoutManager = LinearLayoutManager(context)

        val adapter2 = mainAppActivity?.let { ConnectToRecyclerViewAdapter(it) }
        adapter2?.datalist = mutableListOf(
            ConnectUserData("", "퍼플", 26, "휴먼지능정보공학", 18, 26, "남자", "MBTI"),
            ConnectUserData("", "주이", 23, "컴퓨터소프트웨어", 20, 23, "여자", "MBTI"),
            ConnectUserData("", "케빈", 25, "컴퓨터과학", 17, 25, "남자", "MBTI"),
            ConnectUserData("", "마크", 28, "컴퓨터과학", 18, 28, "남자", "MBTI"),
            ConnectUserData("", "캐롤린", 24, "컴퓨터소프트웨어", 20, 24, "여자", "MBTI")
            )
        binding.connectionList2.adapter = adapter2
        binding.connectionList2.layoutManager = LinearLayoutManager(context)

        binding.btnFullConnectTo.setOnClickListener {
            val intent = Intent(context, ConnectToMeActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}