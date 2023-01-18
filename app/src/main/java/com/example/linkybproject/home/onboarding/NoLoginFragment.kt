package com.example.linkybproject.home.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentNoLoginBinding

class NoLoginFragment : AppCompatActivity() {
    private lateinit var viewBinding: FragmentNoLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = FragmentNoLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}