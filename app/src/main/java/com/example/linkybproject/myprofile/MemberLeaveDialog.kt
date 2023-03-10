package com.example.linkybproject.myprofile

import android.app.Dialog
import android.content.Intent
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogMemberLeaveBinding
import com.example.linkybproject.onBoarding.PrevLoginActivity

class MemberLeaveDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogMemberLeaveBinding
    private val dlg = Dialog(context)

    fun Mydlg() {
        binding = DialogMemberLeaveBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.setCancelable(false)

        binding.btnClose.setOnClickListener {
            dlg.dismiss()
        }

        binding.btnLeave.setOnClickListener {
            onClickedListener.onClicked("leave")
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