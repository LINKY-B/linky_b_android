package com.example.linkybproject.homes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.linkybproject.BlockDialog
import com.example.linkybproject.ReportDialog
import com.example.linkybproject.ReportBlockDialog
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
                        dlgReport.setOnClickedListener(object : ReportDialog.ButtonClickListener {
                            override fun onClicked(myName: String) {
                                if (myName == "reported") {
                                    Toast.makeText(this@HomeUserInformationActivity, "신고되었습니다.", Toast.LENGTH_SHORT).show()
                                }
                            }
                        })
                    }
                    else if (myName == "block") {
                        val dlgBlock = BlockDialog(this@HomeUserInformationActivity)
                        dlgBlock.Mydlg()
                        dlgBlock.setOnClickedListener(object : BlockDialog.ButtonClickListener {
                            override fun onClicked(myName: String) {
                                if (myName == "blocked") {
                                    Toast.makeText(this@HomeUserInformationActivity, "차단되었습니다.", Toast.LENGTH_SHORT).show()
                                }
                            }
                        })
                    }
                }
            })
        }

        binding.ibHomeConnect.setOnClickListener {
            val dlg = ConnectDialog(this)
            dlg.Mydlg()
        }

    }
}