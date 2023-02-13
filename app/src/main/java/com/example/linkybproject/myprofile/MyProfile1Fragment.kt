package com.example.linkybproject.myprofile

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.linkybproject.MainActivity
import com.example.linkybproject.R
import com.example.linkybproject.databinding.FragmentMyprofile1Binding

class MyProfile1Fragment : Fragment() {
    private lateinit var binding: FragmentMyprofile1Binding

    private lateinit var mainActivity : MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMyprofile1Binding.inflate(inflater, container, false)

        binding.imageViewMyProfileSettings.setOnClickListener {
            val intent = Intent(activity, SetUpActivity::class.java)
            startActivity(intent)
        }

        binding.imageViewMyProfileEdit.setOnClickListener {
            mainActivity.changeFragment()
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }
}