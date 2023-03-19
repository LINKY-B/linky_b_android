package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linkybproject.databinding.ActivityConnectFromMeBinding

class ConnectFromMeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityConnectFromMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectFromMeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnBackToConnection.setOnClickListener {
            finish()
        }

        viewBinding.btnConnectionAllDelete.setOnClickListener {
            val dlg = AllDeleteDialog(this)
            dlg.Mydlg()
        }
    }
}