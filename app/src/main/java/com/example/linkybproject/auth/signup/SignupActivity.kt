package com.example.linkybproject.auth.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.linkybproject.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back 버튼
        binding.imageViewSignupBack.setOnClickListener {
            finish()
        }

        // 뷰 안 보이게 설정
        binding.imageButtonCheckAll.visibility = View.INVISIBLE
        binding.textViewBtnNext1Grey.isEnabled = false
        binding.textViewBtnNext1Green.visibility = View.INVISIBLE

        binding.imageButtonUncheck1.setOnClickListener {
            binding.imageButtonUncheck1.visibility = View.INVISIBLE
            binding.imageButtonCheck1.visibility = View.VISIBLE
            checkOptions()
        }

        binding.imageButtonCheck1.setOnClickListener{
            binding.imageButtonCheck1.visibility = View.INVISIBLE
            binding.imageButtonUncheck1.visibility = View.VISIBLE
            checkOptions()
        }

        binding.imageButtonUncheck2.setOnClickListener {
            binding.imageButtonUncheck2.visibility = View.INVISIBLE
            binding.imageButtonCheck2.visibility = View.VISIBLE
            checkOptions()
        }

        binding.imageButtonCheck2.setOnClickListener{
            binding.imageButtonCheck2.visibility = View.INVISIBLE
            binding.imageButtonUncheck2.visibility = View.VISIBLE
            checkOptions()
        }

        binding.imageButtonUncheck3.setOnClickListener {
            binding.imageButtonUncheck3.visibility = View.INVISIBLE
            binding.imageButtonCheck3.visibility = View.VISIBLE
            checkOptions()
        }

        binding.imageButtonCheck3.setOnClickListener{
            binding.imageButtonCheck3.visibility = View.INVISIBLE
            binding.imageButtonUncheck3.visibility = View.VISIBLE
            checkOptions()
        }

        binding.imageButtonUncheck4.setOnClickListener {
            binding.imageButtonUncheck4.visibility = View.INVISIBLE
            binding.imageButtonCheck4.visibility = View.VISIBLE
            checkOptions()
        }

        binding.imageButtonCheck4.setOnClickListener{
            binding.imageButtonCheck4.visibility = View.INVISIBLE
            binding.imageButtonUncheck4.visibility = View.VISIBLE
            checkOptions()
        }

        binding.imageButtonUncheckAll.setOnClickListener {
            binding.imageButtonUncheck1.visibility = View.INVISIBLE
            binding.imageButtonUncheck2.visibility = View.INVISIBLE
            binding.imageButtonUncheck3.visibility = View.INVISIBLE
            binding.imageButtonUncheck4.visibility = View.INVISIBLE
            binding.imageButtonUncheckAll.visibility = View.INVISIBLE
            binding.textViewBtnNext1Grey.visibility = View.INVISIBLE
            binding.imageButtonCheck1.visibility = View.VISIBLE
            binding.imageButtonCheck2.visibility = View.VISIBLE
            binding.imageButtonCheck3.visibility = View.VISIBLE
            binding.imageButtonCheck4.visibility = View.VISIBLE
            binding.imageButtonCheckAll.visibility = View.VISIBLE
            binding.textViewBtnNext1Green.visibility = View.VISIBLE
            checkOptions()
        }

        binding.imageButtonCheckAll.setOnClickListener{
            binding.imageButtonCheck1.visibility = View.INVISIBLE
            binding.imageButtonCheck2.visibility = View.INVISIBLE
            binding.imageButtonCheck3.visibility = View.INVISIBLE
            binding.imageButtonCheck4.visibility = View.INVISIBLE
            binding.imageButtonCheckAll.visibility = View.INVISIBLE
            binding.textViewBtnNext1Green.visibility = View.INVISIBLE
            binding.imageButtonUncheck1.visibility = View.VISIBLE
            binding.imageButtonUncheck2.visibility = View.VISIBLE
            binding.imageButtonUncheck3.visibility = View.VISIBLE
            binding.imageButtonUncheck4.visibility = View.VISIBLE
            binding.imageButtonUncheckAll.visibility = View.VISIBLE
            binding.textViewBtnNext1Grey.visibility = View.VISIBLE
            checkOptions()
        }

        binding.textViewBtnNext1Green.setOnClickListener {
            val intent = Intent(this, SignupActivity2::class.java)
            startActivity(intent)
        }

    }

    private fun checkOptions() {
        if (binding.imageButtonUncheck1.visibility == View.INVISIBLE &&
                binding.imageButtonUncheck2.visibility == View.INVISIBLE &&
                binding.imageButtonUncheck3.visibility == View.INVISIBLE &&
                binding.imageButtonUncheck4.visibility == View.INVISIBLE) {
            binding.imageButtonUncheckAll.visibility = View.INVISIBLE
            binding.imageButtonCheckAll.visibility = View.VISIBLE
            binding.textViewBtnNext1Grey.visibility = View.INVISIBLE
            binding.textViewBtnNext1Green.visibility = View.VISIBLE
        } else {
            binding.imageButtonCheckAll.visibility = View.INVISIBLE
            binding.imageButtonUncheckAll.visibility = View.VISIBLE
            binding.textViewBtnNext1Green.visibility = View.INVISIBLE
            binding.textViewBtnNext1Grey.visibility = View.VISIBLE
        }
    }



}