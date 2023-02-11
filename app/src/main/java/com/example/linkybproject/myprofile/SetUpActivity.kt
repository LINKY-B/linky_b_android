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
            var dialog = AlertDialog.Builder(this)
            dialog.setTitle("로그아웃을 하시겠습니까?")
            dialog.setMessage("서비스를 이용해주셔서 감사합니다.")

            fun toast() {
                Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
/*
                MyApplication.prefs.edit.remove("email") // 여기서 Shared Preference 를 remove 한다!
                MyApplication.prefs.edit.remove("password")
                MyApplication.prefs.edit.commit() // SP 삭제되는 것을 확인
*/
                val intent = Intent(this, PrevLoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
            }
            var dialogLister = DialogInterface.OnClickListener { p0, p1 ->
                when (p1) {
                    DialogInterface.BUTTON_POSITIVE -> toast()
                }
            }
            dialog.setPositiveButton("YES", dialogLister)
            dialog.setNegativeButton("NO", null)
            dialog.show()
/*
            val dlg = LogoutDialog(this)
            dlg.Mydlg()
*/
        }

        viewBinding.btnSetUpMemberLeave.setOnClickListener {
            val intent = Intent(this, MemberLeaveActivity::class.java)
            startActivity(intent)
        }

    }

}