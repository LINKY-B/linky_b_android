package com.example.linkybproject.connect

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.ActivityConnectToMeBinding

class ConnectActivity : AppCompatActivity(), ConnectView {
    private lateinit var viewBinding: ActivityConnectToMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectToMeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        /* 리사이클러뷰 */
        val connectList: ArrayList<LBUser> = arrayListOf()

        viewBinding.recyclerConnectToMe.layoutManager = LinearLayoutManager(this)
        viewBinding.recyclerConnectToMe.setHasFixedSize(true)
        viewBinding.recyclerConnectToMe.adapter = ConnectRAdapter(connectList)

        /* 나에게 매칭 시도한 유저 전체 조회 api 호출 */
        val connectService = ConnectService()
        connectService.setConnectToMeView(this)
        connectService.connectToMeList(getSharedPreferences("auth", Context.MODE_PRIVATE).getString("accessToken", "")!!)

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        viewBinding.btnConnectionAllAcceptance.setOnClickListener {
            val dlg = AllAcceptDialog(this)
            dlg.Mydlg()
        }
    }

    /* 나에게 매칭 시도한 유저 전체 조회 api 호출 결과 */
    override fun onConnectSuccess(connectToMeList: MatchingResponse) {
        Log.d("ConnectToMe", "Success")
        viewBinding.recyclerConnectToMe.adapter = ConnectRAdapter(connectToMeList.data)
    }

    override fun onConnectFailure() {
        Log.d("ConnectToMe", "Failure")
    }
}