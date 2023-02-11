package com.example.linkybproject

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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
        dlg.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dlg.setCancelable(false)

        binding.btnClose.setOnClickListener {
            dlg.dismiss()
        }

/*
        binding.btnRefuse.setOnClickListener {
            onClickedListener.onClicked("refuse")
            dlg.dismiss()
        }
*/

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