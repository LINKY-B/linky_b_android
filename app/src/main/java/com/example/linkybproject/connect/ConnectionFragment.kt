package com.example.linkybproject.connect

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
//        connectList.add(LBUser(2, "호호", "컴퓨터학과", "20", 3))

        binding.rvConnectToMeList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvConnectToMeList.setHasFixedSize(true)
        binding.rvConnectToMeList.adapter = ConnectRAdapter(connectList)

        /* 나에게 매칭 시도한 유저 전체 조회 api 호출 */
        val connectService = ConnectService()
        connectService.setConnectToMeView(this)
        connectService.connectToMeList("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2NzkyNzk4ODUsInN1YiI6ImFjY2Vzcy10b2tlbiIsImh0dHBzOi8vbG9jYWxob3N0OjgwMDEiOnRydWUsInVzZXIiOjEwLCJlbWFpbCI6InRwdGtkMTI1OEBuYXZlci5jb20iLCJyb2xlIjoiUk9MRV9VU0VSIn0.Majw20trOMc4Bh9F7zhFISTbU9Eu7_0upcOtyo9ni0Dt5wJyzdeFYMIkbiPnupPa57dmtnjWA26hDevljQuMyw")

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