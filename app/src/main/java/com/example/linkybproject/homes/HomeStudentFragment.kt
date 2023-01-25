package com.example.linkybproject.homes

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentHomeStudentsBinding

class HomeStudentFragment : Fragment() {
    private lateinit var binding: FragmentHomeStudentsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeStudentsBinding.inflate(inflater,container,false)

        val adapter = HomeRecyclerViewAdapter();

        adapter.datalist = mutableListOf(
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
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

        binding.recyclerviewHome.adapter  = adapter
        binding.recyclerviewHome.layoutManager = LinearLayoutManager(context);

        return binding.root
    }
}


