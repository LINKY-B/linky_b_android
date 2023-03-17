package com.example.linkybproject.common

import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
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

        binding.btnClose.setOnClickListener {
            dlg.dismiss()
        }

        var btn_select = false
        binding.report1.setOnClickListener {
            binding.report1.isSelected = binding.report1.isSelected != true
        }

        binding.report2.setOnClickListener {
            binding.report2.isSelected = binding.report2.isSelected != true
        }

        binding.report3.setOnClickListener {
            binding.report3.isSelected = binding.report3.isSelected != true
        }

        binding.report4.setOnClickListener {
            binding.report4.isSelected = binding.report4.isSelected != true
        }

        binding.report5.setOnClickListener {
            binding.report5.isSelected = binding.report5.isSelected != true
        }

        binding.report6.setOnClickListener {
            binding.report6.isSelected = binding.report6.isSelected != true
        }

        binding.btnReport.setOnClickListener {
            Toast.makeText(context, "신고되었습니다.", Toast.LENGTH_SHORT).show()
            dlg.dismiss()
        }

        dlg.show()
    }

    interface ButtonClickListener {
        fun onClicked(myName: String)
    }

    private lateinit var onClickedListener: ButtonClickListener

    fun setOnClickedListener(listener: ButtonClickListener) {
        onClickedListener = listener
    }

}