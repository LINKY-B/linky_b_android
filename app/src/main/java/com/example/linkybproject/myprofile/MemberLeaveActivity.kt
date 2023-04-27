package com.example.linkybproject.myprofile

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.widget.addTextChangedListener
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivityMemberLeaveBinding
import com.example.linkybproject.databinding.DialogMemberLeaveBinding
import com.example.linkybproject.onBoarding.PrevLoginActivity

class MemberLeaveActivity : AppCompatActivity(), MyProfileView {
    private lateinit var viewBinding: ActivityMemberLeaveBinding
    private lateinit var userPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMemberLeaveBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        // back 버튼
        viewBinding.btnBackToSetUp.setOnClickListener {
            finish()
        }

        // 초기 뷰 설정
        viewBinding.btnMemberLeaveGrey.isEnabled = false
        viewBinding.btnMemberLeaveGreen.visibility = View.INVISIBLE
        viewBinding.tvErrorAccountPassword.visibility = View.INVISIBLE

        /* 현재 사용자 정보 상세 조회 api */
        val profileService = MyProfileService()
        profileService.setMyProfileView(this)
        profileService.getUser(this.getSharedPreferences("auth", Context.MODE_PRIVATE).getString("accessToken", "")!!) // this 맞나

        // 키보드 입력 동시에 비번 같나 확인
        viewBinding.etAccountPassword.addTextChangedListener {
            val pw = viewBinding.etAccountPassword.text.toString()
            val pwCheck = userPassword

            if (pw == pwCheck) {
                viewBinding.tvErrorAccountPassword.visibility = View.INVISIBLE
            } else {
                viewBinding.tvErrorAccountPassword.visibility = View.VISIBLE
            }

        }

        if (viewBinding.tvErrorAccountPassword.visibility == View.INVISIBLE) {
            viewBinding.btnMemberLeaveGrey.visibility = View.INVISIBLE
            viewBinding.btnMemberLeaveGreen.visibility = View.VISIBLE
        }

        viewBinding.btnMemberLeaveGreen.setOnClickListener {
            val dlg = MemberLeaveDialog(this)
            dlg.Mydlg()

            dlg.setOnClickedListener(object : MemberLeaveDialog.ButtonClickListener {
                override fun onClicked(myName: String) {
                    if (myName == "leave") {
                        val intent = Intent(this@MemberLeaveActivity, PrevLoginActivity::class.java)
                        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                    }
                }
            })
        }
    }

    override fun onGetUserSuccess(result: MyProfileResponse) {
        Log.d("onGetUserSuccess", "Success")
        Log.d("RESULT.DATA", result.data.toString())

        // 받아오려고 했는데 password가 없다.

    }

    override fun onGetUserFailure() {
        Log.d("onGetUserFailure", "Failure")
    }
}