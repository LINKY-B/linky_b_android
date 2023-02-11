package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.ActivityConnectToMeBinding

class ConnectToMeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityConnectToMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectToMeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        viewBinding.btnConnectionAllDelete.setOnClickListener {
            val dlg = AllRefuseDialog(this)
            dlg.Mydlg()
        }

        val adapter = ConnectToRecyclerViewAdapter(this)

        adapter.datalist = mutableListOf(
            ConnectUserData("", "퍼플", 26, "휴먼지능정보공학", 18, 26, "남자", "MBTI"),
            ConnectUserData("", "쿼티", 25, "컴퓨터학과", 20, 25, "여자", "MBTI"),
            ConnectUserData("", "주이", 23, "컴퓨터소프트웨어", 20, 23, "여자", "MBTI"),
            ConnectUserData("", "에이치", 24, "컴퓨터학과", 20, 24, "여자", "MBTI"),
            ConnectUserData("", "케빈", 25, "컴퓨터과학", 17, 25, "남자", "MBTI"),
            ConnectUserData("", "홍시", 25, "시각디자인학과", 18, 25, "여자", "MBTI"),
            ConnectUserData("", "얼리시", 23, "정보시스템공학과", 20, 23, "여자", "MBTI"),
            ConnectUserData("", "마크", 28, "컴퓨터과학", 18, 28, "남자", "MBTI"),
            ConnectUserData("", "리나", 24, "물리학과", 19, 24, "여자", "ESFP"),
            ConnectUserData("", "캐롤린", 24, "컴퓨터소프트웨어", 20, 24, "여자", "MBTI")
        )

        viewBinding.recyclerConnectTo.adapter = adapter
        viewBinding.recyclerConnectTo.layoutManager = LinearLayoutManager(this)

    }
}