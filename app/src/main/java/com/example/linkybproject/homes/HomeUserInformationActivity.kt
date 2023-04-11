package com.example.linkybproject.homes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.common.BlockDialog
import com.example.linkybproject.common.ReportDialog
import com.example.linkybproject.common.ReportBlockDialog
import com.example.linkybproject.databinding.ActivityHomeUserInformationBinding

class HomeUserInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeUserInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeUserInformationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ibHomeBack.setOnClickListener {
            finish()
        }

        binding.btnReportBlock.setOnClickListener {
            val dlg = ReportBlockDialog(this)
            dlg.Mydlg()

            dlg.setOnClickedListener(object : ReportBlockDialog.ButtonClickListener {
                override fun onClicked(myName: String) {
                    if (myName == "report") {
                        val dlgReport = ReportDialog(this@HomeUserInformationActivity)
                        dlgReport.Mydlg()
                    }
                    else if (myName == "block") {
                        val dlgBlock = BlockDialog(this@HomeUserInformationActivity)
                        dlgBlock.Mydlg()
                    }
                }
            })
        }

        binding.ibHomeConnect.setOnClickListener {
            val dlg = ConnectDialog(this)
            dlg.Mydlg()

/*
            dlg.setOnClickedListener(object : ConnectDialog.ButtonClickListener {
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