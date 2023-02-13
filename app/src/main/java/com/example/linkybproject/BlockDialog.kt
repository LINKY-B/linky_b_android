package com.example.linkybproject

import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.linkybproject.databinding.DialogBlockBinding

class BlockDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogBlockBinding
    private val dlg = Dialog(context)

    fun Mydlg() {
        binding = DialogBlockBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)
        dlg.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dlg.setCancelable(false)

        binding.btnClose.setOnClickListener {
            dlg.dismiss()
        }

        binding.btnBlock.setOnClickListener {
            Toast.makeText(context, "차단되었습니다.", Toast.LENGTH_SHORT).show()
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