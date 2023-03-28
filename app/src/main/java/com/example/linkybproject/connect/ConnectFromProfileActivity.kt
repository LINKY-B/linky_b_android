package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.common.BlockDialog
import com.example.linkybproject.common.ReportBlockDialog
import com.example.linkybproject.common.ReportDialog
import com.example.linkybproject.databinding.ActivityConnectFromProfileBinding
import com.example.linkybproject.homes.Interest

class ConnectFromProfileActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityConnectFromProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectFromProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnConnectionProfileBack.setOnClickListener {
            finish()
        }

        val name = intent.getStringExtra("name")
        viewBinding.profileName.text = name

        val like = intent.getIntExtra("like", 0)
        viewBinding.profileLike.text = like.toString()

        val numOfLink = intent.getIntExtra("numOfLink", 0)
        viewBinding.numberOfLink.text = numOfLink.toString()

        val major = intent.getStringExtra("major")
        viewBinding.profileMajor.text = major

        val classOf = intent.getIntExtra("classOf", 0)
        viewBinding.profileClassOf.text = classOf.toString()

        val age = intent.getIntExtra("age", 0)
        viewBinding.profileAge.text = age.toString()

        val gender = intent.getStringExtra("gender")
        viewBinding.profileGender.text = gender

        val mbti = intent.getStringExtra("mbti")
        viewBinding.profileMbti.text = mbti

        val interest = intent

        viewBinding.btnReportBlock.setOnClickListener {
            val dlg = ReportBlockDialog(this)
            dlg.Mydlg()

            dlg.setOnClickedListener(object : ReportBlockDialog.ButtonClickListener {
                override fun onClicked(myName: String) {
                    if (myName == "report") {
                        val dlgReport = ReportDialog(this@ConnectFromProfileActivity)
                        dlgReport.Mydlg()
                    } else if (myName == "block") {
                        val dlgBlock = BlockDialog(this@ConnectFromProfileActivity)
                        dlgBlock.Mydlg()
                    }
                }
            })
        }

        viewBinding.btnConnectionDelete.setOnClickListener {
            val dlg = DeleteDialog(this)
            dlg.Mydlg()
        }
    }
}