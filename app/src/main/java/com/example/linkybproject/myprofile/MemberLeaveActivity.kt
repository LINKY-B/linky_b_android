package com.example.linkybproject.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityMemberLeaveBinding
import com.example.linkybproject.databinding.DialogMemberLeaveBinding

class MemberLeaveActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMemberLeaveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMemberLeaveBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnBackToSetUp.setOnClickListener {
            finish()
        }

        viewBinding.btnMemverLeave.setOnClickListener {
            val dlg = MemberLeaveDialog(this)
            dlg.Mydlg()
        }
    }
}