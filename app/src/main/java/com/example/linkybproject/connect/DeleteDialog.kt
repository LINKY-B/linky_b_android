package com.example.linkybproject.connect

import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogDeleteBinding

class DeleteDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogDeleteBinding
    private val dlg = Dialog(context)

    fun Mydlg() {
        binding = DialogDeleteBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.setCancelable(false)

        binding.btnClose.setOnClickListener {
            dlg.dismiss()
        }

        binding.btnDelete.setOnClickListener {
/*
            onClickedListener.onClicked("done")
*/
            Toast.makeText(context, "연결 시도 내역을 삭제하였습니다.", Toast.LENGTH_SHORT).show()
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