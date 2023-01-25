package com.example.linkybproject.connect

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.linkybproject.databinding.FragmentConnectFromMeBinding
import com.example.linkybproject.homes.UserData

class ConnectFromMeFragment : Fragment() {
    private lateinit var binding: FragmentConnectFromMeBinding
    private lateinit var adapter: ConnectFromRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConnectFromMeBinding.inflate(layoutInflater)

        val back_btn: ImageButton = binding.btnBackToConnection
        back_btn.setOnClickListener {
            val intent = Intent(activity, ConnectionFragment::class.java)
            startActivity(intent)
        }

        val datalist = mutableListOf<ConnectUserData>()
        binding.recyclerConnectFrom.adapter = adapter
        datalist.apply {
            add(ConnectUserData("", "배고픈 청설모", 20, "정보시스템공학과"))
            add(ConnectUserData("", "배고픈 청설모", 20, "정보시스템공학과"))
            add(ConnectUserData("", "배고픈 청설모", 20, "정보시스템공학과"))
            add(ConnectUserData("", "배고픈 청설모", 20, "정보시스템공학과"))
            add(ConnectUserData("", "배고픈 청설모", 20, "정보시스템공학과"))
        }

        return binding.root
    }
}