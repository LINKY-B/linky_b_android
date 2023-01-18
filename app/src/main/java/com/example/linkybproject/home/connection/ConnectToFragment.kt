package com.example.linkybproject.home.connection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentConnectToBinding

class ConnectToFragment : AppCompatActivity() {
    private lateinit var viewBinding: FragmentConnectToBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = FragmentConnectToBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}