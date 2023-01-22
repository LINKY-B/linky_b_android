package com.example.linkybproject

import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogRefuseBinding

class RefuseDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogRefuseBinding
    private val dlg = Dialog(context)

    fun Mydlg() {
        binding = DialogRefuseBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.setCancelable(false)

        dlg.show()
    }

}