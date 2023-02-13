package com.example.linkybproject.myprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentMyprofile1Binding
import com.example.linkybproject.databinding.FragmentMyprofile2Binding

class MyProfile2Fragment : Fragment() {
    private lateinit var binding: FragmentMyprofile2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMyprofile2Binding.inflate(inflater, container, false)

        return binding.root
    }
    
}