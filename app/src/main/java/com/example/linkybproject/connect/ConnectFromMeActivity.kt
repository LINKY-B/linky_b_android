package com.example.linkybproject.connect

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.ActivityConnectFromMeBinding

class ConnectFromMeActivity : AppCompatActivity(), ConnectView {
    private lateinit var viewBinding: ActivityConnectFromMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectFromMeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        /* 리사이클러뷰 */
        val connectList: ArrayList<LBUser> = arrayListOf()

        viewBinding.recyclerConnectFrom.layoutManager = LinearLayoutManager(this)
        viewBinding.recyclerConnectFrom.setHasFixedSize(true)
        viewBinding.recyclerConnectFrom.adapter = ConnectRAdapter(connectList)

        /* 나에게 매칭 시도한 유저 전체 조회 api 호출 */
        val connectService = ConnectService()
        connectService.setConnectFromMeView(this)
        connectService.connectFromMeList(getSharedPreferences("auth", Context.MODE_PRIVATE).getString("accessToken", "")!!)


        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        viewBinding.btnConnectionAllDelete.setOnClickListener {
            val dlg = AllDeleteDialog(this)
            dlg.Mydlg()
        }
    }

    /* 내가 매칭 시도한 유저 전체 조회 api 호출 결과 */
    override fun onConnectSuccess(connectFromMeList: MatchingResponse) {
        Log.d("ConnectFromMe", "Success")
        viewBinding.recyclerConnectFrom.adapter = ConnectRAdapter(connectFromMeList.data)
    }

    override fun onConnectFailure() {
        Log.d("ConnectFromMe", "Failure")
    }
}