package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.InterestData
import com.example.linkybproject.databinding.ActivityConnectFromMeBinding

class ConnectFromMeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityConnectFromMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectFromMeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        viewBinding.btnConnectionAllDelete.setOnClickListener {
            val dlg = AllDeleteDialog(this)
            dlg.Mydlg()
        }

        val adapter = ConnectFromRecyclerViewAdapter(this)
        adapter.datalist = mutableListOf(
            ConnectFromUserData("", "케빈", 4, "컴퓨터과학", 18, 25, "남자", "ESFP"),
            ConnectFromUserData("", "홍시", 5, "시각디자인학과", 19, 25, "여자", "ENFP"),
            ConnectFromUserData("", "얼리시", 6, "정보시스템공학과", 20, 23, "여자", "MBTI"),
            ConnectFromUserData("", "마크", 7, "컴퓨터과학", 17, 28, "남자", "MBTI"),
            ConnectFromUserData("", "퍼플", 0, "휴먼지능정보공학", 18, 26, "남자", "MBTI"),
            ConnectFromUserData("", "쿼티", 1, "컴퓨터학과", 20, 25, "여자", "MBTI"),
            ConnectFromUserData("", "주이", 2, "컴퓨터소프트웨어", 20, 23, "여자", "MBTI"),
            ConnectFromUserData("", "에이치", 3, "컴퓨터학과", 20, 24, "여자", "MBTI"),
            ConnectFromUserData("", "리나", 8, "물리학과", 19, 24, "여자", "ESFP"),
            ConnectFromUserData("", "캐롤린", 9, "컴퓨터소프트웨어", 20, 24, "여자", "MBTI"),
            ConnectFromUserData("", "퍼플", 10, "휴먼지능정보공학", 18, 26, "남자", "MBTI"),
            ConnectFromUserData("", "쿼티", 11, "컴퓨터학과", 20, 25, "여자", "MBTI"),
            ConnectFromUserData("", "주이", 12, "컴퓨터소프트웨어", 20, 23, "여자", "MBTI"),
            ConnectFromUserData("", "에이치", 13, "컴퓨터학과", 20, 24, "여자", "MBTI"),
            ConnectFromUserData("", "케빈", 14, "컴퓨터과학", 18, 25, "남자", "ESFP"),
            ConnectFromUserData("", "홍시", 15, "시각디자인학과", 19, 25, "여자", "ENFP"),
            ConnectFromUserData("", "얼리시", 16, "정보시스템공학과", 20, 23, "여자", "MBTI"),
            ConnectFromUserData("", "마크", 17, "컴퓨터과학", 17, 28, "남자", "MBTI"),
            ConnectFromUserData("", "리나", 18, "물리학과", 19, 24, "여자", "ESFP"),
            ConnectFromUserData("", "캐롤린", 19, "컴퓨터소프트웨어", 20, 24, "여자", "MBTI")

        )
        viewBinding.recyclerConnectFrom.adapter = adapter
        viewBinding.recyclerConnectFrom.layoutManager = LinearLayoutManager(this)

/*
        val adapterInterest = ConnectInterestAdapter()
        adapterInterest.datalist = mutableListOf(
            InterestData("정보공유"),
            InterestData("스터디메이트"),
            InterestData("취업준비"),
        )
*/

    }
}