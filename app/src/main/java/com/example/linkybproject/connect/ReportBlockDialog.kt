package com.example.linkybproject.connect

import android.app.Dialog
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogReportBlockBinding

class ReportBlockDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogReportBlockBinding
    private val dlg = Dialog(context)

    fun Mydlg() {
        binding = DialogReportBlockBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.setCancelable(false)

        binding.btnReporting.setOnClickListener {
/*
            onClickListener.onClick(DialogReport)
*/
        }

        dlg.show()
    }

    interface BtnClickListener {
        fun onClick(view: View)
    }

    private lateinit var onClickListener: BtnClickListener

    fun setOnClickListener(listener: BtnClickListener) {
        onClickListener = listener
    }
}