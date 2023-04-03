package com.example.linkybproject.connect

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.FragmentConnectionBinding

class ConnectionFragment : Fragment(), ConnectToMeView {
    private lateinit var binding: FragmentConnectionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConnectionBinding.inflate(layoutInflater)

        /* 리사이클러뷰 */
        val connectList: ArrayList<LBUser> = arrayListOf()

        binding.rvConnectToMeList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvConnectToMeList.setHasFixedSize(true)
        binding.rvConnectToMeList.adapter = ConnectRAdapter(connectList)

        /* 나에게 매칭 시도한 유저 전체 조회 api 호출 */
        val connectService = ConnectService()
        connectService.setConnectToMeView(this)

        connectService.connectToMeList("")
        // requireContext().getSharedPreferences("auth", Context.MODE_PRIVATE).getString("accessToken", "")!!

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

    /* 나에게 매칭 시도한 유저 전체 조회 api 호출 결과 */
    override fun onConnectToMeSuccess(connectToMeList: MatchingResponse) {
        Log.d("ConnectToMe", "Success")
        binding.rvConnectToMeList.adapter = ConnectRAdapter(connectToMeList.result)
    }

    override fun onConnectToMeFailure() {
        Log.d("ConnectToMe", "Failure")
    }
}