package com.example.linkybproject.homes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentHomeGraduateBinding

class HomeGraudateFragment : Fragment() {
    private lateinit var binding: FragmentHomeGraduateBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeGraduateBinding.inflate(inflater,container,false)

        val adapter = HomeRecyclerViewAdapter()

        adapter.datalist = mutableListOf(  UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))), UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))), UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))), UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))), UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))), UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))), UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))), UserData("", "배고픈 청설모1", 29, "시각디자인학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", "", listOf<Interest>(Interest("jj"))),
        )

        binding.recyclerviewHomeGraduate.adapter  = adapter
        binding.recyclerviewHomeGraduate.layoutManager = LinearLayoutManager(context)



        return binding.root
    }
}


