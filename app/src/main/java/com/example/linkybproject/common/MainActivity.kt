package com.example.linkybproject.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.R
import com.example.linkybproject.chat.ChatFragment
import com.example.linkybproject.connect.ConnectionFragment
import com.example.linkybproject.databinding.ActivityMainBinding
import com.example.linkybproject.homes.HomeFragment
import com.example.linkybproject.myprofile.MyProfile1Fragment
import com.example.linkybproject.myprofile.MyProfile2Fragment
import com.example.linkybproject.myprofile.update.MyProfileImgFragment

class MainActivity : AppCompatActivity(){

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val accessToken = getSharedPreferences("auth", MODE_PRIVATE).getString("accessToken", "")

        // 내비게이션
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

    // 프로필 화면 1 -> 연필 버튼 -> 프로필 화면 2
    fun myprofile1Tomyprofile2(fragment: MyProfile2Fragment, birth: String, profileImg: String, nickName: String, introduction: String, major: String, studentNum: String, age: String, gender: String
    ) {
        val bundle = Bundle()
        bundle.putString("birth", birth)
        bundle.putString("profileImg", profileImg)
        bundle.putString("nickName", nickName)
        bundle.putString("introduction", introduction)
        bundle.putString("major", major)
        bundle.putString("studentNum", studentNum)
        bundle.putString("age", age)
        bundle.putString("gender", gender)

        fragment.arguments = bundle
        setFragment(fragment)

    }
    fun setFragment(fragment: MyProfile2Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainerViewMain.id, fragment)
            .commitAllowingStateLoss()
    }

    // 프로필 화면 2 -> 수정 버튼 -> 프로필 화면 1 (수정 반영돼서 나와야 함)
    fun myprofile2Tomyprofil1() {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainerViewMain.id, MyProfile1Fragment())
            .commitAllowingStateLoss()
    }

    // 프로필 화면 2 -> 연필 버튼 -> 프로필 화면 3 (프로필 이미지 수정)
    fun myprofile2Tomyprofil3(myProfileImgFragment: MyProfileImgFragment, birth: String, nickName: String, introduction: String, major: String, studentNum: String, age: String, gender: String) {
        val bundle = Bundle()
        bundle.putString("birth", birth)
        bundle.putString("nickName", nickName)
        bundle.putString("introduction", introduction)
        bundle.putString("major", major)
        bundle.putString("studentNum", studentNum)
        bundle.putString("age", age)
        bundle.putString("gender", gender)

        myProfileImgFragment.arguments = bundle
        setFragment(myProfileImgFragment)
    }
    fun setFragment(fragment: MyProfileImgFragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainerViewMain.id, fragment)
            .commitAllowingStateLoss()
    }

    // 프로필 화면 1 -> 연필 버튼 -> 프로필 화면 2
    fun myprofile3Tomyprofile2(fragment: MyProfile2Fragment, birth: String, profileImg: String, nickName: String, introduction: String, major: String, studentNum: String, age: String, gender: String) {
        val bundle = Bundle()
        bundle.putString("birth", birth)
        bundle.putString("profileImg", profileImg)
        bundle.putString("nickName", nickName)
        bundle.putString("introduction", introduction)
        bundle.putString("major", major)
        bundle.putString("studentNum", studentNum)
        bundle.putString("age", age)
        bundle.putString("gender", gender)

        fragment.arguments = bundle
        setFragment3to2(fragment)

    }
    fun setFragment3to2(fragment: MyProfile2Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainerViewMain.id, fragment)
            .commitAllowingStateLoss()
    }

}