package com.example.linkybproject.home.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentOnBoardingBinding
import com.example.linkybproject.home.MainActivity

class OnBoardingFragment : AppCompatActivity() {
    private lateinit var viewBinding: FragmentOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = FragmentOnBoardingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}