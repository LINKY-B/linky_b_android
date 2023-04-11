package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.common.*
import com.example.linkybproject.databinding.ActivityConnectToProfileBinding

class ConnectToProfileActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityConnectToProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectToProfileBinding.inflate(layoutInflater)
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

        viewBinding.btnReportBlock.setOnClickListener {
            val dlg = ReportBlockDialog(this)
            dlg.Mydlg()

            dlg.setOnClickedListener(object : ReportBlockDialog.ButtonClickListener {
                override fun onClicked(myName: String) {
                    if (myName == "report") {
                        val dlgReport = ReportDialog(this@ConnectToProfileActivity)
                        dlgReport.Mydlg()
                    }
                    else if (myName == "block") {
                        val dlgBlock = BlockDialog(this@ConnectToProfileActivity)
                        dlgBlock.Mydlg()
                    }
                }
            })
        }

        viewBinding.btnConnectionRefuse.setOnClickListener {
            val dlg = RefuseDialog(this)
            dlg.Mydlg()

/*
            dlg.setOnClickedListener(object : RefuseDialog.ButtonClickListener {
                override fun onClicked(myName: String) {
                    if (myName == "done") {
                        finish()
                    }
                }
            })
*/
        }

        viewBinding.btnConnectionAccept.setOnClickListener {
            val dlg = AcceptDialog(this)
            dlg.Mydlg()

/*
            dlg.setOnClickedListener(object : AcceptDialog.ButtonClickListener {
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