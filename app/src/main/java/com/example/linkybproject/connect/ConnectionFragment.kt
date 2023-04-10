package com.example.linkybproject.connect

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.FragmentConnectionBinding

class ConnectionFragment : Fragment(), MatchingMainView {
    private lateinit var viewBinding: FragmentConnectionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = FragmentConnectionBinding.inflate(layoutInflater)


        /* 리사이클러뷰 */
        val connectList: ArrayList<LBUser> = arrayListOf()
        viewBinding.rvConnectToMeList.layoutManager = LinearLayoutManager(activity)
        viewBinding.rvConnectToMeList.setHasFixedSize(true)
        viewBinding.rvConnectToMeList.adapter = ConnectRAdapter(connectList)


        /* 매칭 홈 전체 조회 api 호출 */
        val connectService = ConnectService()
        connectService.setConnectMainView(this)
        connectService.connectMainList(requireContext().getSharedPreferences("auth", Context.MODE_PRIVATE).getString("accessToken", "")!!)


        /* 이벤트 리스너 */
        viewBinding.btnFullConnectFrom.setOnClickListener {
            val intent = Intent(activity, ConnectFromMeActivity::class.java)
            startActivity(intent)
        }

        viewBinding.btnFullConnectToMe.setOnClickListener {
            val intent = Intent(context, ConnectActivity::class.java)
            startActivity(intent)
        }

        return viewBinding.root
    }

    /* 매칭 홈 조회 api 호출 결과 */
    override fun onMatchingMainSuccess(connectList: MatchingMainResponse) {
        Log.d("ConnectMain", "Success")
        viewBinding.rvConnectToMeList.adapter = ConnectRAdapter(connectList.data.userToMe)
    }

    override fun onMatchingMainFailure() {
        Log.d("ConnectMain", "Failure")
    }
}