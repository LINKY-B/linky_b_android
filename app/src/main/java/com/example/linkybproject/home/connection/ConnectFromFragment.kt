package com.example.linkybproject.home.connection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentConnectFromBinding

class ConnectFromFragment : AppCompatActivity() {
    private lateinit var viewBinding: FragmentConnectFromBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = FragmentConnectFromBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}