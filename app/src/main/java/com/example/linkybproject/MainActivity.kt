package com.example.linkybproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.chat.ChatFragment
import com.example.linkybproject.connect.ConnectionFragment
import com.example.linkybproject.databinding.ActivityMainBinding
import com.example.linkybproject.homes.HomeFragment
import com.example.linkybproject.myprofile.MyProfile1Fragment
import com.example.linkybproject.myprofile.MyProfile2Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainerViewMain.id, HomeFragment())
            .commitAllowingStateLoss()

        binding.bottomNavigationViewMainMenu.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_home -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.fragmentContainerViewMain.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_connection -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.fragmentContainerViewMain.id, ConnectionFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_chat -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.fragmentContainerViewMain.id, ChatFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_profile -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.fragmentContainerViewMain.id, MyProfile1Fragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
        }
    }
    
    // ????????? ?????? 1 -> ?????? ?????? -> ????????? ?????? 2
    fun myprofile1Tomyprofile2() {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainerViewMain.id, MyProfile2Fragment())
            .commitAllowingStateLoss()
    }

    // ????????? ?????? 2 -> ?????? ?????? -> ????????? ?????? 1 (?????? ???????????? ????????? ???)
    fun myprofile2Tomyprofil1() {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainerViewMain.id, MyProfile1Fragment())
            .commitAllowingStateLoss()
    }
}