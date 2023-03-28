package com.example.linkybproject.homes

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentHomeStudentsBinding

class HomeStudentFragment : Fragment() {
    private lateinit var binding: FragmentHomeStudentsBinding
    var mainAppActivity: AppCompatActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AppCompatActivity) {
            mainAppActivity = context
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeStudentsBinding.inflate(inflater, container, false)

        val adapter = mainAppActivity?.let { HomeRecyclerViewAdapter(it) }

        adapter?.datalist = mutableListOf(
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 20, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 23, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 22, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 20, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),
            UserData("", "배고픈 청설모1", 29, "시각디자인학과", 19, "","", listOf<Interest>(Interest("정보공유"),Interest("스터디메이트"),Interest("취업준비"))),

            )

        binding.recyclerviewHomeStudents.adapter = adapter
        binding.recyclerviewHomeStudents.layoutManager = LinearLayoutManager(context)


/*
        // 위에서 만든 setMyItemClickListener를 이용해 Interface를 상속받아 객체를 만들고
        // 이 객체를 Adapter로 보냄
        adapter.setMyItemClickListener(object :
            HomeRecyclerViewAdapter.MyItemClickListener {
            // 아이템 클릭시 이벤트 정의
            override fun onItemClick(userData: UserData) {
                // 클릭했을 때 무엇을 할 지 내용 작성

                // Dialog만들기
                val mDialogView =
                    LayoutInflater.from(context).inflate(R.layout.dialog_connect, null)
                val mBuilder = AlertDialog.Builder(context)
                    .setView(mDialogView)

                val mAlertDialog = mBuilder.show()

                val okButton = mDialogView.findViewById<Button>(R.id.btn_connect_try)
                okButton.setOnClickListener {
                    Toast.makeText(context, "연결을 시도하였습니다.", Toast.LENGTH_SHORT).show()
                    mAlertDialog.dismiss()
                }
            }
        })
*/
        return binding.root
    }
}



