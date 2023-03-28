package com.example.linkybproject.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.auth.LoginActivity
import com.example.linkybproject.auth.signup.SignupActivity
import com.example.linkybproject.databinding.ActivityPrevLoginBinding

class PrevLoginActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityPrevLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityPrevLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        viewBinding.btnSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}