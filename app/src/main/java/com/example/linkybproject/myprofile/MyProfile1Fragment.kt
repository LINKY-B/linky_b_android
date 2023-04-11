package com.example.linkybproject.myprofile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.linkybproject.common.MainActivity
import com.example.linkybproject.databinding.FragmentMyprofile1Binding

class MyProfile1Fragment : Fragment(), MyProfileView {
    private lateinit var binding: FragmentMyprofile1Binding
    private lateinit var mainActivity : MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMyprofile1Binding.inflate(inflater, container, false)

        /* 현재 사용자 정보 상세 조회 api */
        val profileService = ProfileService()
        profileService.setMyProfileView(this)
        profileService.getUser(requireContext().getSharedPreferences("auth", Context.MODE_PRIVATE).getString("accessToken", "")!!)


        /* 이벤트 리스너 */
        binding.imageViewMyProfileSettings.setOnClickListener {
            val intent = Intent(activity, SetUpActivity::class.java)
            startActivity(intent)
        }

        binding.imageViewMyProfileEdit.setOnClickListener {
            mainActivity.myprofile1Tomyprofile2()
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onGetUserSuccess(result: MyProfileResponse) {
        Log.d("onGetUserSuccess", "Success")
        binding.textViewMyProfileBeanCount.text = result.data.userLikeCount.toString()
        binding.textViewMyProfileGreen2.text = result.data.userMatchingCount.toString() + "명과 링크 중입니다."
        binding.textViewMyProfileNickname.text = result.data.userNickName
        binding.textViewMyProfileIntro.text = result.data.userSelfIntroduction
        binding.textViewMyProfileMajorDetail.text = result.data.userMajorName
        binding.textViewMyProfileNoDetail.text = result.data.userStudentNum
        binding.textViewMyProfileMbtiDetail.text = result.data.userMBTI

    }

    override fun onGetUserFailure() {
        Log.d("onGetUserFailure", "Failure")
    }
}