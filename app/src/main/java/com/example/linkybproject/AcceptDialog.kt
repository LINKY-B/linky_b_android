package com.example.linkybproject

import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogAcceptBinding

class AcceptDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogAcceptBinding
    private val dlg = Dialog(context)

    fun Mydlg() {
        binding = DialogAcceptBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.setCancelable(false)

        binding.btnClose.setOnClickListener {
            dlg.dismiss()
        }

/*
        binding.btnAccept.setOnClickListener {
            onClickedListener.onClicked("accept")
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