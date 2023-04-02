package com.example.linkybproject.auth

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.linkybproject.auth.signup.SignupActivity
import com.example.linkybproject.common.MainActivity
import com.example.linkybproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginView {
    private lateinit var viewBinding: com.example.linkybproject.databinding.ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.buttonLoginSubmit.setOnClickListener {
            login()
        }

        viewBinding.textViewLoginGoSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        viewBinding.textViewLoginFindPassword.setOnClickListener {
            val intent = Intent(this, FindPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login() {
        val id: String = viewBinding.editTextLoginId.text.toString()
        val password: String = viewBinding.editTextLoginPassword.text.toString()

        val loginService = LoginService()
        loginService.setLoginView(this)
        loginService.login(LoginRequest(id, password))
    }

    override fun onLoginSuccess(result: LoginResponse) {
        Toast.makeText(this, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()

        // 액세스 토큰 저장
        val accessToken = result.data.accessToken
        getSharedPreferences("auth", MODE_PRIVATE)
            .edit()
            .putString("accessToken", accessToken)
            .apply()

        // 메인 페이지로 이동
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK))
    }

    override fun onLoginFailure() {
        Toast.makeText(this, "로그인에 실패했습니다", Toast.LENGTH_SHORT).show()
    }
}