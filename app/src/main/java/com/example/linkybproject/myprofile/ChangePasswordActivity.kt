package com.example.linkybproject.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityChangePasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityChangePasswordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnChangePassword.setOnClickListener {
            val intent = Intent(this, MemberLeaveActivity::class.java)
            startActivity(intent)
        }
    }
}