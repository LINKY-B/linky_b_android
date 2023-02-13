package com.example.linkybproject.myprofile

import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogUnblockBinding

class UnblockDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogUnblockBinding
    private val dlg = Dialog(context)

    fun Mydlg() {
        binding = DialogUnblockBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.setCancelable(false)

        binding.btnClose.setOnClickListener {
            dlg.dismiss()
        }

        binding.btnUnblock.setOnClickListener {
            Toast.makeText(context, "차단 해제되었습니다.", Toast.LENGTH_SHORT).show()
            dlg.dismiss()
        }

        dlg.show()
    }

}