package com.example.linkybproject.connect

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.MainActivity
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentConnectionBinding

class ConnectionFragment : Fragment() {
    private lateinit var binding: FragmentConnectionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConnectionBinding.inflate(inflater, container, false)

        binding.btnFullConnectFrom.setOnClickListener {
            val intent = Intent(activity, ConnectFromMeActivity::class.java)
            startActivity(intent)
        }

        val adapter1 = ConnectFromRecyclerViewAdapter()
        adapter1.datalist = mutableListOf(
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
        )
        binding.connectionList1.adapter = adapter1
        binding.connectionList1.layoutManager = LinearLayoutManager(context)

        val adapter2 = ConnectToRecyclerViewAdapter()
        adapter2.datalist = mutableListOf(
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            ConnectUserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
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