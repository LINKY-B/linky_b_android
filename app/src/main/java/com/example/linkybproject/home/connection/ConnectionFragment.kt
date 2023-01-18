package com.example.linkybproject.home.connection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityMainBinding
import com.example.linkybproject.databinding.FragmentConnectionBinding

class ConnectionFragment : AppCompatActivity() {
    private lateinit var viewBinding: FragmentConnectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = FragmentConnectionBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.fullConnectFrom.setOnClickListener {
            val intent = Intent(this, ConnectFromFragment::class.java)
            startActivity(intent)
        }

        viewBinding.fullConnectTo.setOnClickListener {
            val intent = Intent(this, ConnectToFragment::class.java)
            startActivity(intent)
        }
    }
}