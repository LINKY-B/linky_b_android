package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.ActivityConnectToMeBinding
import com.example.linkybproject.homes.Interest

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
        }

        val adapter = ConnectToRecyclerViewAdapter(this)

        adapter.datalist = mutableListOf(
            ConnectToUserData("", "퍼플", 0, "휴먼지능정보공학", 18, 26, "남자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"))),
            ConnectToUserData("", "쿼티", 1, "컴퓨터학과", 20, 25, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"))),
            ConnectToUserData("", "주이", 2, "컴퓨터소프트웨어", 20, 23, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            ConnectToUserData("", "에이치", 3, "컴퓨터학과", 20, 24, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"))),
            ConnectToUserData("", "케빈", 4, "컴퓨터과학", 18, 25, "남자", "ESFP", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"))),
            ConnectToUserData("", "홍시", 5, "시각디자인학과", 19, 25, "여자", "ENFP", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            ConnectToUserData("", "얼리시", 6, "정보시스템공학과", 20, 23, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"))),
            ConnectToUserData("", "마크", 7, "컴퓨터과학", 17, 28, "남자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"))),
            ConnectToUserData("", "리나", 8, "물리학과", 19, 24, "여자", "ESFP", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            ConnectToUserData("", "캐롤린", 9, "컴퓨터소프트웨어", 20, 24, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"))),
            ConnectToUserData("", "퍼플", 10, "휴먼지능정보공학", 18, 26, "남자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"))),
            ConnectToUserData("", "쿼티", 11, "컴퓨터학과", 20, 25, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            ConnectToUserData("", "주이", 12, "컴퓨터소프트웨어", 20, 23, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"))),
            ConnectToUserData("", "에이치", 13, "컴퓨터학과", 20, 24, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"))),
            ConnectToUserData("", "케빈", 14, "컴퓨터과학", 18, 25, "남자", "ESFP", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            ConnectToUserData("", "홍시", 15, "시각디자인학과", 19, 25, "여자", "ENFP", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"))),
            ConnectToUserData("", "얼리시", 16, "정보시스템공학과", 20, 23, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"))),
            ConnectToUserData("", "마크", 17, "컴퓨터과학", 17, 28, "남자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            ConnectToUserData("", "리나", 18, "물리학과", 19, 24, "여자", "ESFP", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"))),
            ConnectToUserData("", "캐롤린", 19, "컴퓨터소프트웨어", 20, 24, "여자", "MBTI", listOf<Character>(Character("외향적"), Character("사교적")),listOf<Interest>(Interest("정보공유"),Interest("스터디메이트")))
        )

        viewBinding.recyclerConnectTo.adapter = adapter
        viewBinding.recyclerConnectTo.layoutManager = LinearLayoutManager(this)

    }
}