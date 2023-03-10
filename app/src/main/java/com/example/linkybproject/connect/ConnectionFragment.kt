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
import com.example.linkybproject.homes.Interest

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

        val adapter1 = mainAppActivity?.let { ConnectToRecyclerViewAdapter(it) }


        adapter1?.datalist = mutableListOf(
            ConnectToUserData("", "퍼플", 0, "휴먼지능정보공학", 18, 26, "남자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"))),
            ConnectToUserData("", "쿼티", 1, "컴퓨터학과", 20, 25, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"))),
            ConnectToUserData("", "주이", 2, "컴퓨터소프트웨어", 20, 23, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            ConnectToUserData("", "에이치", 3, "컴퓨터학과", 20, 24, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"))),
            )

        binding.connectionList1.adapter = adapter1
        binding.connectionList1.layoutManager = LinearLayoutManager(context)

        val adapter2 = mainAppActivity?.let { ConnectFromRecyclerViewAdapter(it) }
        adapter2?.datalist = mutableListOf(
            ConnectFromUserData("", "케빈", 4, "컴퓨터과학", 18, 25, "남자", "ESFP"),
            ConnectFromUserData("", "홍시", 5, "시각디자인학과", 19, 25, "여자", "ENFP"),
            ConnectFromUserData("", "얼리시", 6, "정보시스템공학과", 20, 23, "여자", "MBTI"),
            ConnectFromUserData("", "마크", 7, "컴퓨터과학", 17, 28, "남자", "MBTI"),
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