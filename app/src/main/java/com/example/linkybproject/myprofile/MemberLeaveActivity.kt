package com.example.linkybproject.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityMemberLeaveBinding
import com.example.linkybproject.databinding.DialogMemberLeaveBinding

class MemberLeaveActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMemberLeaveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMemberLeaveBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnMemberLeaveGrey.isEnabled = false
        viewBinding.btnMemberLeaveGrey.visibility = View.VISIBLE
        viewBinding.btnMemberLeaveGreen.visibility = View.INVISIBLE

        viewBinding.btnBackToSetUp.setOnClickListener {
            finish()
        }

        val password = "aaaa1111" //조건 수정
        if (viewBinding.etAccountPassword.text.toString() == password) {
            viewBinding.btnMemberLeaveGrey.visibility = View.INVISIBLE
            viewBinding.btnMemberLeaveGreen.visibility = View.VISIBLE
            viewBinding.btnMemberLeaveGreen.isEnabled = true
        }

        viewBinding.btnMemberLeaveGreen.setOnClickListener {
            val dlg = MemberLeaveDialog(this)
            dlg.Mydlg()
        }
    }
}