package com.example.linkybproject.connect

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentConnectionBinding
import com.example.linkybproject.homes.UserData

class ConnectionFragment : Fragment() {
    private lateinit var binding: FragmentConnectionBinding
    private lateinit var adapter1: ConnectFromRecyclerViewAdapter
    private lateinit var adapter2: ConnectToRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConnectionBinding.inflate(inflater, container, false)

/*
        val btnFullConnectFrom: ImageButton = binding.btnFullConnectFrom
        btnFullConnectFrom.setOnClickListener {
            val intent = Intent(context, ConnectFromMeFragment::class.java)
            startActivity(intent)
        }
*/

        return binding.root

    }

}