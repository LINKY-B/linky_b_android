package com.example.linkybproject.homes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentHomeStudentsBinding

class HomeStudentFragment : Fragment() {
    private lateinit var binding: FragmentHomeStudentsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeStudentsBinding.inflate(inflater,container,false)
        return binding.root
    }
}


