package com.example.linkybproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.R
import com.example.linkybproject.chat.ChatFragment
import com.example.linkybproject.databinding.ActivityMainBindingg

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTransactionEvent()
    }

    private fun initTransactionEvent() {
//        val homeFragment = HomeFragment()
        val chatFragment = ChatFragment()
//        val connectionFragment = ConnectionFragment()
//        val profileFragment = ProfileFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragment_container_view_main, chatFragment).commit()

        // Transaction 작업
        binding.constLayoutHomeMenu.setOnClickListener {
            
        }

    }
}