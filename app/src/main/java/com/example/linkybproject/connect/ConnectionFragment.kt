package com.example.linkybproject.connect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentConnectionBinding

class ConnectionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentConnectionBinding.inflate(layoutInflater)

        return binding.root
    }
}