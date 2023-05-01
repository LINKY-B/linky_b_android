package com.example.linkybproject.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.example.linkybproject.databinding.ActivityChangePasswordBinding
import java.util.regex.Pattern

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityChangePasswordBinding
    private lateinit var userPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityChangePasswordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnChangePasswordGrey.isEnabled = false
        viewBinding.btnChangePasswordGreen.visibility = View.INVISIBLE
        viewBinding.tvErrorNowPassword.visibility = View.INVISIBLE
        viewBinding.tvErrorNewPassword.visibility = View.INVISIBLE
        viewBinding.tvErrorNewPasswordChk.visibility = View.INVISIBLE

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        viewBinding.etNewPassword.addTextChangedListener {
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkPwValid()
                    checkOptions()
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkPwValid()
                    checkOptions()
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkPwValid()
                    checkOptions()
                }
            }
        }

        viewBinding.etNewPasswordChk.addTextChangedListener {
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkPwCheckValid()
                    checkOptions()
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    checkPwCheckValid()
                    checkOptions()
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkPwCheckValid()
                    checkOptions()
                }
            }
        }

        viewBinding.btnChangePasswordGreen.setOnClickListener {
            val dlg = ChangePasswordDialog(this)
            dlg.Mydlg()

            dlg.setOnClickedListener(object : ChangePasswordDialog.ButtonClickListener {
                override fun onClicked(myName: String) {
                    if (myName == "changePassword") {
                        val intent = Intent(this@ChangePasswordActivity, SetUpActivity::class.java)
                        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                        finish()
                    }
                }
            })
        }

    }

    // 5. 비밀번호 유효성 검사 함수
    private fun checkPwValid() {
        val pw = viewBinding.etNewPassword.text.toString()

        // 길이 검증
        if (pw.length < 7) {
            viewBinding.tvErrorNewPassword.visibility = View.VISIBLE
            return
        }

        // 영문, 숫자, 특수문자 검증
        for (i in 0 until pw.length) {
            if(!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{7,20}$", pw)) {
                viewBinding.tvErrorNewPassword.visibility = View.VISIBLE
                return
            }
        }

        // PW is valid
        viewBinding.tvErrorNewPassword.visibility = View.INVISIBLE
    }

    // 5-1. 비밀번호 확인 함수
    private fun checkPwCheckValid() {
        val pw = viewBinding.etNewPassword.text.toString()
        val pwCheck = viewBinding.etNewPasswordChk.text.toString()

        // 입력한 비밀번호와 같은지 확인
        if (pw == pwCheck) {
            viewBinding.tvErrorNewPasswordChk.visibility = View.INVISIBLE
            userPassword = pw
        } else {
            viewBinding.tvErrorNewPasswordChk.visibility = View.VISIBLE
        }
    }

    private fun checkOptions() {
        if (viewBinding.tvErrorNowPassword.visibility == View.INVISIBLE &&
            viewBinding.tvErrorNewPassword.visibility == View.INVISIBLE &&
            viewBinding.tvErrorNewPasswordChk.visibility == View.INVISIBLE) {
            viewBinding.btnChangePasswordGrey.visibility = View.INVISIBLE
            viewBinding.btnChangePasswordGreen.visibility = View.VISIBLE
        }
        else {
            viewBinding.btnChangePasswordGrey.isEnabled = false
            viewBinding.btnChangePasswordGreen.visibility = View.INVISIBLE
        }
    }
}