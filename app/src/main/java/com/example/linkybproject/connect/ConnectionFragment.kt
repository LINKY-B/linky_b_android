package com.example.linkybproject.connect

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentConnectionBinding
import com.example.linkybproject.homes.UserData

class ConnectionFragment : Fragment() {
    private lateinit var adapter1: ConnectFromRecyclerViewAdapter
    private lateinit var adapter2: ConnectToRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentConnectionBinding.inflate(layoutInflater)

        val btnFullConnectFrom: ImageButton = binding.btnFullConnectFrom
        btnFullConnectFrom.setOnClickListener {
            val intent = Intent(activity, ConnectFromMeFragment::class.java)
            startActivity(intent)
        }

/*
        val datalist = mutableListOf<UserData>()
        binding.connectionFrom.adapter = adapter1
        datalist.apply {
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
            add(UserData("", "배고픈 청설모", 20, "정보시스템공학과", "", ""))
        }
*/


        val btnFullConnectTo: ImageButton = binding.btnFullConnectTo
        btnFullConnectTo.setOnClickListener {
            val intent = Intent(activity, ConnectToMeFragment::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}