package com.example.linkybproject.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.MainActivity
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivitySignup4Binding

class SignupActivity4 : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySignup4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivitySignup4Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.textViewBtnNext5.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}