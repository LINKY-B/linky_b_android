package com.example.linkybproject.connect

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.FragmentConnectionBinding
import com.example.linkybproject.homes.Interest

class ConnectionFragment : Fragment() {
    private lateinit var binding: FragmentConnectionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConnectionBinding.inflate(layoutInflater)

        /* 리사이클러뷰 */
        val connectList: ArrayList<LBUser> = arrayListOf()
        connectList.add(LBUser(2, "호호", "컴퓨터학과", "20", 3))

        binding.rvConnectToMeList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvConnectToMeList.setHasFixedSize(true)
        binding.rvConnectToMeList.adapter = ConnectRAdapter(connectList)

        /* 이벤트 리스너 */
        binding.btnFullConnectFrom.setOnClickListener {
            val intent = Intent(activity, ConnectFromMeActivity::class.java)
            startActivity(intent)
        }

        binding.btnFullConnectTo.setOnClickListener {
            val intent = Intent(context, ConnectToMeActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }



}