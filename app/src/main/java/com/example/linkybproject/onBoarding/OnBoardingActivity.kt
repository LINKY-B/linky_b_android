package com.example.linkybproject.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.linkybproject.MainActivity
import com.example.linkybproject.connect.ConnectionProfileActivity
import com.example.linkybproject.databinding.ActivityOnBoardingBinding
import com.example.linkybproject.myprofile.ManageBlockingActivity
import com.example.linkybproject.myprofile.SetUpActivity

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }}