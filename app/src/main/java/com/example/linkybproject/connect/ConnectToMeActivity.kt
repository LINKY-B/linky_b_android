package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.ActivityConnectToMeBinding

class ConnectToMeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityConnectToMeBinding
    private lateinit var adapter: ConnectToRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectToMeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

/*
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

        viewBinding.recyclerConnectTo.adapter = adapter
*/
/*
        viewBinding.recyclerConnectTo.layoutManager = LinearLayoutManager(context);
*/

    }
}