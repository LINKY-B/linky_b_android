package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.databinding.ActivityConnectToMeBinding

class ConnectToMeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityConnectToMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectToMeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        viewBinding.btnConnectionAllAcceptance.setOnClickListener {
            val dlg = AllAcceptDialog(this)
            dlg.Mydlg()
        }
    }
}