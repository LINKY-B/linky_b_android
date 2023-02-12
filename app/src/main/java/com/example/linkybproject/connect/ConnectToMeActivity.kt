package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        viewBinding.btnConnectionAllAcceptance.setOnClickListener {
            val dlg = AllAcceptDialog(this)
            dlg.Mydlg()

            dlg.setOnClickedListener(object : AllAcceptDialog.ButtonClickListener {
                override fun onClicked(myName: String) {
                    if (myName == "all accept") {
                        Toast.makeText(this@ConnectToMeActivity, "모든 연결을 수락하였습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }

        val adapter = ConnectToRecyclerViewAdapter(this)

        adapter.datalist = mutableListOf(
            ConnectUserData("", "퍼플", 0, "휴먼지능정보공학", 18, 26, "남자", "MBTI"),
            ConnectUserData("", "쿼티", 1, "컴퓨터학과", 20, 25, "여자", "MBTI"),
            ConnectUserData("", "주이", 2, "컴퓨터소프트웨어", 20, 23, "여자", "MBTI"),
            ConnectUserData("", "에이치", 3, "컴퓨터학과", 20, 24, "여자", "MBTI"),
            ConnectUserData("", "케빈", 4, "컴퓨터과학", 18, 25, "남자", "ESFP"),
            ConnectUserData("", "홍시", 5, "시각디자인학과", 19, 25, "여자", "ENFP"),
            ConnectUserData("", "얼리시", 6, "정보시스템공학과", 20, 23, "여자", "MBTI"),
            ConnectUserData("", "마크", 7, "컴퓨터과학", 17, 28, "남자", "MBTI"),
            ConnectUserData("", "리나", 8, "물리학과", 19, 24, "여자", "ESFP"),
            ConnectUserData("", "캐롤린", 9, "컴퓨터소프트웨어", 20, 24, "여자", "MBTI"),
            ConnectUserData("", "퍼플", 10, "휴먼지능정보공학", 18, 26, "남자", "MBTI"),
            ConnectUserData("", "쿼티", 11, "컴퓨터학과", 20, 25, "여자", "MBTI"),
            ConnectUserData("", "주이", 12, "컴퓨터소프트웨어", 20, 23, "여자", "MBTI"),
            ConnectUserData("", "에이치", 13, "컴퓨터학과", 20, 24, "여자", "MBTI"),
            ConnectUserData("", "케빈", 14, "컴퓨터과학", 18, 25, "남자", "ESFP"),
            ConnectUserData("", "홍시", 15, "시각디자인학과", 19, 25, "여자", "ENFP"),
            ConnectUserData("", "얼리시", 16, "정보시스템공학과", 20, 23, "여자", "MBTI"),
            ConnectUserData("", "마크", 17, "컴퓨터과학", 17, 28, "남자", "MBTI"),
            ConnectUserData("", "리나", 18, "물리학과", 19, 24, "여자", "ESFP"),
            ConnectUserData("", "캐롤린", 19, "컴퓨터소프트웨어", 20, 24, "여자", "MBTI")
        )

        viewBinding.recyclerConnectTo.adapter = adapter
        viewBinding.recyclerConnectTo.layoutManager = LinearLayoutManager(this)

    }
}