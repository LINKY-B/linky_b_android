package com.example.linkybproject.myprofile

import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogMemberLeaveBinding

class MemberLeaveDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogMemberLeaveBinding
    private val dlg = Dialog(context)

    fun Mydlg() {
        binding = DialogMemberLeaveBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.setCancelable(false)

        dlg.show()
    }

}