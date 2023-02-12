package com.example.linkybproject.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.connect.ConnectUserData
import com.example.linkybproject.databinding.ActivityManageBlockingBinding
import com.example.linkybproject.homes.UserData

class ManageBlockingActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityManageBlockingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityManageBlockingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        viewBinding.btnAllUnblocking.setOnClickListener {
            val dlg = UnblockDialog(this)
            dlg.Mydlg()
        }

        val adapter = ManageBlockingAdapter()
        adapter.datalist = mutableListOf(
            ConnectUserData("", "퍼플", 0, "휴먼지능정보공학", 18, 26, "남자", "MBTI"),
            ConnectUserData("", "쿼티", 1, "컴퓨터학과", 20, 25, "여자", "MBTI"),
            ConnectUserData("", "주이", 2, "컴퓨터소프트웨어", 20, 23, "여자", "MBTI"),
            ConnectUserData("", "에이치", 3, "컴퓨터학과", 20, 24, "여자", "MBTI"),
            ConnectUserData("", "케빈", 4, "컴퓨터과학", 17, 25, "남자", "MBTI"),
            ConnectUserData("", "홍시", 5, "시각디자인학과", 18, 25, "여자", "MBTI"),
            ConnectUserData("", "얼리시", 6, "정보시스템공학과", 20, 23, "여자", "MBTI"),
            ConnectUserData("", "마크", 7, "컴퓨터과학", 18, 28, "남자", "MBTI"),
            ConnectUserData("", "리나", 8, "물리학과", 19, 24, "여자", "ESFP"),
            ConnectUserData("", "캐롤린", 9, "컴퓨터소프트웨어", 20, 24, "여자", "MBTI"),
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
        viewBinding.listBlocking.adapter = adapter
        viewBinding.listBlocking.layoutManager = LinearLayoutManager(this)

    }

}