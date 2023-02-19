package com.example.linkybproject.chat

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogChatBinding

class ChatDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogChatBinding
    private val dlg = Dialog(context)

    fun Mydlg() {
        binding = DialogChatBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.window?.setGravity(Gravity.BOTTOM)
        dlg.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dlg.setCancelable(false)

        binding.btnReporting.setOnClickListener {
            onClickedListener.onClicked("report")
            dlg.dismiss()
        }

        binding.btnBlocking.setOnClickListener {
            onClickedListener.onClicked("block")
            dlg.dismiss()
        }

        binding.btnLeave.setOnClickListener {
            onClickedListener.onClicked("leave")
            dlg.dismiss()
        }

        binding.btnCancle.setOnClickListener {
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