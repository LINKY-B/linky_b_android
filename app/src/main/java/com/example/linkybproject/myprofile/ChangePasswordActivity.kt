package com.example.linkybproject.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.linkybproject.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityChangePasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityChangePasswordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnChangePasswordGrey.isEnabled = false
        viewBinding.btnChangePasswordGreen.visibility = View.INVISIBLE

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        val password = "aaaa1111" //조건 수정
        if (viewBinding.etNowPassword.text.toString() == password &&
                viewBinding.etNewPassword.text.length >= 7 &&
                viewBinding.etNewPasswordChk.text == viewBinding.etNewPassword.text) {
            viewBinding.btnChangePasswordGrey.visibility = View.INVISIBLE
            viewBinding.btnChangePasswordGreen.visibility = View.VISIBLE
            viewBinding.btnChangePasswordGreen.isEnabled = true
        }


        viewBinding.btnChangePasswordGreen.setOnClickListener {
            val dlg = ChangePasswordDialog(this)
            dlg.Mydlg()
        }

    }

}