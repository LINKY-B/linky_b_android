package com.example.linkybproject.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan
import android.widget.TextView
import com.example.linkybproject.R
import com.example.linkybproject.databinding.ActivitySetUpBinding

class SetUpActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySetUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySetUpBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val text1 = SpannableStringBuilder("비활성화\n다른 사람의 피드에 내 정보가 보이지 않습니다.")
        text1.apply {
            setSpan(RelativeSizeSpan(0.6f),5, 31, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        viewBinding.setUpSwitch1.text = text1

        val text2 = SpannableStringBuilder("알림\n연결 시도, 수락, 채팅 등의 알림을 받을 수 있습니다.")
        text2.apply {
            setSpan(RelativeSizeSpan(0.6f), 3, 34, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        viewBinding.setUpSwitch2.text = text2

        viewBinding.reportManagement.setOnClickListener {
            val intent = Intent(this, ManageBlockingActivity::class.java)
            startActivity(intent)
        }
    }
}