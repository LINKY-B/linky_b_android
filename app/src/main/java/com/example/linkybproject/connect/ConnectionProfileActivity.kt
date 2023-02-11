package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.linkybproject.AcceptDialog
import com.example.linkybproject.BlockDialog
import com.example.linkybproject.RefuseDialog
import com.example.linkybproject.ReportDialog
import com.example.linkybproject.databinding.ActivityConnectionProfileBinding

class ConnectionProfileActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityConnectionProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityConnectionProfileBinding.inflate(layoutInflater)
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
                        val dlgReport = ReportDialog(this@ConnectionProfileActivity)
                        dlgReport.Mydlg()
                        dlgReport.setOnClickedListener(object : ReportDialog.ButtonClickListener {
                            override fun onClicked(myName: String) {
                                if (myName == "reported") {
                                    Toast.makeText(this@ConnectionProfileActivity, "신고되었습니다.", Toast.LENGTH_SHORT).show()
                                }
                            }
                        })
                    }
                    else if (myName == "block") {
                        val dlgBlock = BlockDialog(this@ConnectionProfileActivity)
                        dlgBlock.Mydlg()
                        dlgBlock.setOnClickedListener(object : BlockDialog.ButtonClickListener {
                            override fun onClicked(myName: String) {
                                if (myName == "blocked") {
                                    Toast.makeText(this@ConnectionProfileActivity, "차단되었습니다.", Toast.LENGTH_SHORT).show()
                                }
                            }
                        })
                    }
                }
            })
        }

        viewBinding.btnConnectionRefuse.setOnClickListener {
            val dlg = RefuseDialog(this)
            dlg.Mydlg()
        }

        viewBinding.btnConnectionAccept.setOnClickListener {
            val dlg = AcceptDialog(this)
            dlg.Mydlg()
        }
    }
}