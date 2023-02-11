package com.example.linkybproject.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.linkybproject.AcceptDialog
import com.example.linkybproject.RefuseDialog
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

        viewBinding.btnReportDelete.setOnClickListener {
            val dlg = ReportBlockDialog(this)
            dlg.Mydlg()
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