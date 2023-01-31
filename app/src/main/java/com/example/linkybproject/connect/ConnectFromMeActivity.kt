package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.ActivityConnectFromMeBinding

class ConnectFromMeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityConnectFromMeBinding
    private lateinit var adapter: ConnectFromRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectFromMeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

/*
        adapter.datas = mutableListOf(
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

        viewBinding.recyclerConnectFrom.adapter = adapter
*/
/*
        viewBinding.recyclerConnectFrom.layoutManager = LinearLayoutManager(context)
*/

    }
}