package com.example.linkybproject.connect

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.FragmentConnectFromMeBinding
import com.example.linkybproject.homes.HomeRecyclerViewAdapter
import com.example.linkybproject.homes.UserData

class ConnectFromMeFragment : Fragment() {
    private lateinit var binding: FragmentConnectFromMeBinding
    private lateinit var adapter: ConnectFromRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConnectFromMeBinding.inflate(inflater,container,false)

/*
        val back_btn: ImageButton = binding.btnBackToConnection
        back_btn.setOnClickListener {
            val intent = Intent(activity, ConnectionFragment::class.java)
            startActivity(intent)
        }
*/

        adapter.datalist = mutableListOf(
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

        binding.recyclerConnectFrom.adapter = adapter
        binding.recyclerConnectFrom.layoutManager = LinearLayoutManager(context);

        return binding.root
    }
}