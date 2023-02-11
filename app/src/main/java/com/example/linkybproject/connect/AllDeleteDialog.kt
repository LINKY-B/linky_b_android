package com.example.linkybproject.connect

import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogAllDeleteBinding

class AllDeleteDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogAllDeleteBinding
    private val dlg = Dialog(context)

    fun Mydlg() {
        binding = DialogAllDeleteBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.setCancelable(false)

        binding.btnClose.setOnClickListener {
            dlg.dismiss()
        }

        binding.btnAllDelete.setOnClickListener {
            onClickedListener.onClicked("all delete")
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