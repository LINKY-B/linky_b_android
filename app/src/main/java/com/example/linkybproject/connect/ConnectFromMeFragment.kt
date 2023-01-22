package com.example.linkybproject.connect

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentConnectFromMeBinding
import com.example.linkybproject.databinding.FragmentConnectionBinding

class ConnectFromMeFragment : Fragment() {
    private lateinit var binding: FragmentConnectFromMeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConnectFromMeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }

    private fun setOnClickListener() {
/*
        binding.btnBackToConnection.setOnClickListener()
*/
    }
}