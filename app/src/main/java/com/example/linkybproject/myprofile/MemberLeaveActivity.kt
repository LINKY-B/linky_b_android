package com.example.linkybproject.myprofile

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityMemberLeaveBinding
import com.example.linkybproject.databinding.DialogMemberLeaveBinding
import com.example.linkybproject.onBoarding.PrevLoginActivity

class MemberLeaveActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMemberLeaveBinding
    private lateinit var userPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMemberLeaveBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnMemberLeaveGrey.isEnabled = false
        viewBinding.btnMemberLeaveGreen.visibility = View.INVISIBLE

        viewBinding.btnBackToSetUp.setOnClickListener {
            finish()
        }

        viewBinding.etAccountPassword.addTextChangedListener {
            val pw = viewBinding.etAccountPassword.text.toString()
            val pwCheck = userPassword

            // 입력한 비밀번호와 같은지 확인
            if (pw == pwCheck) {
                viewBinding.tvErrorAccountPassword.visibility = View.INVISIBLE
            } else {
                viewBinding.tvErrorAccountPassword.visibility = View.VISIBLE
            }

        }

        if (viewBinding.tvErrorAccountPassword.visibility == View.INVISIBLE) {
            viewBinding.btnMemberLeaveGrey.visibility = View.INVISIBLE
            viewBinding.btnMemberLeaveGreen.visibility = View.VISIBLE
        }

        viewBinding.btnMemberLeaveGreen.setOnClickListener {
            val dlg = MemberLeaveDialog(this)
            dlg.Mydlg()

            dlg.setOnClickedListener(object : MemberLeaveDialog.ButtonClickListener {
                override fun onClicked(myName: String) {
                    if (myName == "leave") {
                        val intent = Intent(this@MemberLeaveActivity, PrevLoginActivity::class.java)
                        startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))
                        finish()
                    }
                }
            })
        }
    }
}