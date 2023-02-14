package com.example.linkybproject.myprofile

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivitySetUpBinding
import com.example.linkybproject.onBoarding.PrevLoginActivity

class SetUpActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySetUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySetUpBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnBack.setOnClickListener {
            finish()
        }

        viewBinding.reportManagement.setOnClickListener {
            val intent = Intent(this, ManageBlockingActivity::class.java)
            startActivity(intent)
        }

        viewBinding.btnSetUpPasswordChange.setOnClickListener {
            val intent = Intent(this, ChangePasswordActivity::class.java)
            startActivity(intent)
        }

        viewBinding.btnSetUpLogout.setOnClickListener {
            val dlg = LogoutDialog(this)
            dlg.Mydlg()

            dlg.setOnClickedListener(object : LogoutDialog.ButtonClickListener {
                override fun onClicked(myName: String) {
                    if (myName == "logout") {
                        Toast.makeText(this@SetUpActivity, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@SetUpActivity, PrevLoginActivity::class.java)
                        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                    }
                }
            })
        }

        viewBinding.btnSetUpMemberLeave.setOnClickListener {
            val intent = Intent(this, MemberLeaveActivity::class.java)
            startActivity(intent)
        }

    }

}