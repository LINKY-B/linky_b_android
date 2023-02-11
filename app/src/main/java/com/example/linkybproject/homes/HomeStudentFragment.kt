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
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentHomeStudentsBinding

class HomeStudentFragment : Fragment() {
    private lateinit var binding: FragmentHomeStudentsBinding


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeStudentsBinding.inflate(inflater, container, false)

        val adapter = HomeRecyclerViewAdapter()

        adapter.datalist = mutableListOf(
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과/20학번", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),

            )

        binding.recyclerviewHomeStudents.adapter = adapter
        binding.recyclerviewHomeStudents.layoutManager = LinearLayoutManager(context)


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
        return binding.root
    }
}



