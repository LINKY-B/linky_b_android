package com.example.linkybproject.connect

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
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
        dlg.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.window?.setGravity(Gravity.BOTTOM)
        dlg.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dlg.setCancelable(false)

        binding.btnCancle.setOnClickListener {
            dlg.dismiss()
        }

        dlg.show()
    }

}