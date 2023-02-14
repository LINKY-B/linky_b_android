package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.AcceptDialog
import com.example.linkybproject.databinding.ActivityConnectFromProfileBinding

class ConnectFromProfileActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityConnectFromProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectFromProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnConnectionDelete.setOnClickListener {
            val dlg = DeleteDialog(this)
            dlg.Mydlg()

/*
            dlg.setOnClickedListener(object : DeleteDialog.ButtonClickListener {
                override fun onClicked(myName: String) {
                    if (myName == "done") {
                        finish()
                    }
                }
            })
*/

        }
    }
}