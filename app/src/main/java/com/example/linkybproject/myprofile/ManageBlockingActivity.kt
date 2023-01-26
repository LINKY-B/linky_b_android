package com.example.linkybproject.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.R
import com.example.linkybproject.connect.ReportBlockDialog
import com.example.linkybproject.databinding.ActivityManageBlockingBinding

class ManageBlockingActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityManageBlockingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityManageBlockingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        viewBinding.btnAllAcceptance.setOnClickListener {
            val dlg = UnblockDialog(this)
            dlg.Mydlg()
        }

    }

}