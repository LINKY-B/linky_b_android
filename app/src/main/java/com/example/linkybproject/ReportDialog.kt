package com.example.linkybproject

import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogReportBinding

class ReportDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogReportBinding
    private val dlg = Dialog(context)

    fun Mydlg() {
        binding = DialogReportBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.setCancelable(false)

        dlg.show()
    }
}