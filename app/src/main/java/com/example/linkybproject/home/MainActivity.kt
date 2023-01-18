package com.example.linkybproject.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityMainBinding
import com.example.linkybproject.home.onboarding.OnBoardingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.fragment_connection)

/*
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, OnBoardingFragment())
            .commit()
*/
    }
}