package com.example.linkybproject.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.ActivityManageBlockingBinding
import com.example.linkybproject.homes.UserData

class ManageBlockingActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityManageBlockingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityManageBlockingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        viewBinding.btnAllUnblocking.setOnClickListener {
            val dlg = UnblockDialog(this)
            dlg.Mydlg()
        }

        val adapter = ManageBlockingAdapter()
        adapter.datalist = mutableListOf(
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과/20학번", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모1", 29, "정보시스템공학과", "", ""),
            UserData("", "배고픈 청설모2", 20, "정보시스템공학과", "", ""),
            )
        viewBinding.listBlocking.adapter = adapter
        viewBinding.listBlocking.layoutManager = LinearLayoutManager(this)

    }

}